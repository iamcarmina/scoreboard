package com.self.edu;

import org.junit.Assert;
import org.junit.Test;

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
		Match match = buildNewMatch();
		Assert.assertNotNull(match.getHomeTeam());
		Assert.assertNotNull(match.getAwayTeam());
	}

	@Test
	public void testMatchInitScore() {
		Match match = buildNewMatch();

		Assert.assertEquals(0, match.getHomeTeam().getScore(), 0);
		Assert.assertEquals(0, match.getAwayTeam().getScore(), 0);
	}

	@Test
	public void testTeamMatchValid() {
		Match match = buildNewMatch();
		Assert.assertNotEquals(match.getHomeTeam().getName(), match.getAwayTeam().getName());
	}

	@Test
	public void testTeamMatchValidInitScore() {
		Match match = buildNewMatch();
		Assert.assertEquals(match.getHomeTeam().getScore(), match.getAwayTeam().getScore());
	}

	
	
	//// Helper methods
	private Match buildNewMatch() {
		return new Match(new Team("Team A", 0), new Team("Team B", 0));
	}

}
