package com.self.edu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.self.edu.model.FootballMatch;
import com.self.edu.model.Team;
import com.self.edu.service.IScoreBoard;

/**
 * A scoreboard contains a lists of {@code Match}(es), where a {@code Match}
 * should have two {@code Team}(s).
 */
public class ScoreBoard implements IScoreBoard<FootballMatch> {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private List<FootballMatch> matchList;

	public ScoreBoard() {
		this.matchList = new ArrayList<>();
	}

	public ScoreBoard(List<FootballMatch> matchList) {
		this.matchList = matchList;
	}

	public List<FootballMatch> getMatches() {
		return this.matchList;
	}

	@Override
	public void updateScore(int matchId, int homeScore, int awayScore) throws Exception {

		if (matchId < 0)
			throw new Exception("No matchId set to update");
		if (homeScore < 0 || awayScore < 0)
			throw new Exception("No score to be updated");

		this.matchList.stream().forEach(m -> {
			if (m.getMatchId() == matchId) {
				m.getHomeTeam().setScore(m.getHomeTeam().getScore() + homeScore);
				m.getAwayTeam().setScore(m.getAwayTeam().getScore() + awayScore);
			}
		});

	}

	@Override
	public List<FootballMatch> finishMatch(FootballMatch match) throws Exception {

		if (match == null)
			throw new Exception("No match to finish");

		this.matchList.stream().forEach(m -> {
			if (m.getMatchId() == match.getMatchId()) {
				m.setFinished(true);
				m.setGameEndDate(new Date());
			}
		});

		List<FootballMatch> newMatchList = this.matchList.stream().filter(m -> m.getMatchId() != match.getMatchId())
				.collect(Collectors.toList());

		return newMatchList;

	}

	@Override
	public void summarizeMatch() {
		// TODO Auto-generated method stub
		this.matchList.sort((o1, o2) -> {
			int o1Ts = o1.getHomeTeam().getScore() + o1.getAwayTeam().getScore();
			int o2Ts = o2.getHomeTeam().getScore() + o2.getAwayTeam().getScore();
			if (o1Ts < o2Ts)
				return 1;
			if (o1Ts > o2Ts)
				return -1;
			if (o1Ts == o2Ts) {
				return o1.getGameStartDate().compareTo(o2.getGameStartDate());
			}
			return 0;
		});
	}

	@Override
	public void addMatch(FootballMatch match) throws Exception {
		if (this.matchList == null)
			throw new Exception("No matchList found");

		// Assign random ID match does not pass any ID
		if (match == null)
			throw new Exception("No match to add");

		this.matchList.add(match);

	}

	public void printMatchDetails(FootballMatch match) {
		if (match != null) {
			Optional<Team> opHt = Optional.of(match.getHomeTeam());
			StringBuilder strHome = new StringBuilder();
			strHome.append(opHt.get().getName());
			strHome.append("(".concat(String.valueOf(opHt.get().getScore()).concat(")")));
			strHome.append(" - ");

			Optional<Team> opAt = Optional.of(match.getAwayTeam());
			StringBuilder strAway = new StringBuilder();
			strHome.append(opAt.get().getName());
			strHome.append("(".concat(String.valueOf(opAt.get().getScore()).concat(")")));

			System.out.println(match.getMatchId() + " --> " + strHome.toString().concat(strAway.toString()) + " S: "
					+ sdf.format(match.getGameStartDate()) + " E: "
					+ (match.getGameEndDate() != null ? sdf.format(match.getGameEndDate()) : "-"));

		}

	}

}
