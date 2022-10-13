package com.self.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.self.edu.model.FootballMatch;
import com.self.edu.model.Match;
import com.self.edu.model.Team;

public class ScoreBoardTest {

	@Test
	public void testHasMatch() {
		ScoreBoard sb = new ScoreBoard();
		Assert.assertNotNull(sb.getMatches());
	}

	@Test
	public void testTeamInitScore() {
		Team team = new Team();
		Assert.assertEquals(0, team.getScore(), 0);
	}

	@Test
	public void testMatchIsValid() {
		Match match = buildNewMatch(1, "TeamA", "TeamB");
		Assert.assertNotNull(match.getHomeTeam());
		Assert.assertNotNull(match.getAwayTeam());
	}

	@Test
	public void testMatchInitScore() {
		Match match = buildNewMatch(1, "TeamA", "TeamB");

		Assert.assertEquals(0, match.getHomeTeam().getScore(), 0);
		Assert.assertEquals(0, match.getAwayTeam().getScore(), 0);
	}

	@Test
	public void testTeamMatchValid() {
		Match match = buildNewMatch(1, "TeamA", "TeamB");
		Assert.assertNotEquals(match.getHomeTeam().getName(), match.getAwayTeam().getName());
	}

	@Test
	public void testTeamMatchValidInitScore() {
		Match match = buildNewMatch(1, "TeamA", "TeamB");
		Assert.assertEquals(match.getHomeTeam().getScore(), match.getAwayTeam().getScore());
	}

	@Test
	public void testIsGameFinished() throws Exception {
		FootballMatch match = (FootballMatch) buildNewMatch(1, "TeamA", "TeamB");
		ScoreBoard sb = new ScoreBoard();
		sb.addMatch(match);

		sb.finishMatch(match);
		Assert.assertTrue(match.isFinished());
	}

	@Test
	public void testNewMatch() {
		ScoreBoard sb = new ScoreBoard();
		FootballMatch match1 = (FootballMatch) buildNewMatch(1, "TeamA", "TeamB");
		try {
			sb.addMatch(match1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Optional<FootballMatch> matchFound = sb.getMatches().stream().filter(e -> e.getMatchId() == match1.getMatchId())
				.findFirst();

		Assert.assertTrue(matchFound.isPresent());
	}

	@Test
	public void testMatchRemoved() {
		FootballMatch m1 = (FootballMatch) buildNewMatch(1, "Mexico", "Canada");
		FootballMatch m2 = (FootballMatch) buildNewMatch(2, "Spain", "Brazil");
		FootballMatch m3 = (FootballMatch) buildNewMatch(3, "Germany", "France");

		List<FootballMatch> matchList = new ArrayList<FootballMatch>();
		matchList.add(m1);
		matchList.add(m2);
		matchList.add(m3);
		ScoreBoard sb = new ScoreBoard(matchList);
		try {
			List<FootballMatch> newMatchList = sb.finishMatch(m2);
			Optional<FootballMatch> opMatchRemoved = newMatchList.stream()
					.filter(e -> e.getMatchId() == m2.getMatchId()).findAny();
			Assert.assertFalse(opMatchRemoved.isPresent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//// Helper methods
	private Match buildNewMatch(int matchId, String homeTeamName, String awayTeamName) {
		return new FootballMatch(matchId, new Team(homeTeamName), new Team(awayTeamName));
	}

}
