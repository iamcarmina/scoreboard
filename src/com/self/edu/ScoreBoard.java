package com.self.edu;

import java.util.ArrayList;
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

	private List<FootballMatch> matchList;

	public ScoreBoard() {
		this.matchList = new ArrayList<>();
	}

	public ScoreBoard(List<FootballMatch> matchList) {
		this.matchList = matchList;
	}

	public List<FootballMatch> getMatches() {
		// TODO Auto-generated method stub
		return this.matchList;
	}

	@Override
	public void initScore() {
		if (this.matchList != null && this.matchList.size() > 0) {
			// TODO Auto-generated method stub
			this.matchList.stream().map(m -> m.initTeamScore()).forEach(e -> printMatchDetails(e));
		}

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
	public void finishMatch(FootballMatch match) throws Exception {

		if (match == null)
			throw new Exception("No match to finish");

		List<FootballMatch> newMatchList = this.matchList.stream().filter(m -> m.getMatchId() != match.getMatchId())
				.collect(Collectors.toList());
		
		newMatchList.stream().forEach(e->printMatchDetails(e));
	}

	@Override
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

			System.out.println(match.getMatchId() + " --> " + strHome.toString().concat(strAway.toString()));
		}

	}

	@Override
	public void summarizeMatch() {
		// TODO Auto-generated method stub
		this.matchList.stream().forEach(e->{
			
		});
	}

}
