package com.self.edu;



import org.junit.Assert;
import org.junit.Test;

public class ScoreBoardTest {

	//Test a team's score initialized to 0
	@Test
	public void testTeamInitScore() {
		Team team = new Team();
		Assert.assertEquals(0, team.getScore(), 0);
	}
	
	
	//Test that two teams has scores initialized to 0
	@Test
	public void testMatchInitScore() {
		Match match = new Match(new Team("Team A", 0), new Team("Team B", 0));
		
		Assert.assertEquals(0, match.getHomeTeam().getScore(), 0);
		Assert.assertEquals(0, match.getAwayTeam().getScore(), 0);
	}
	
	//Test that match is valid with two teams
//	@Test
//	public void testMatchIsValid() {
//		Match match = new Match(null, null);
//		Assert.assertNotNull(match.getHomeTeam());
//		Assert.assertNotNull(match.getAwayTeam());
//	}
	
	//Test that teams for match are not from the same team
	@Test
	public void testTeamMatchValid() {
		Match match = buildNewMatch();
		Assert.assertNotEquals(match.getHomeTeam().getName(), match.getAwayTeam().getName());
	}
	
	//Test that teams for match have the same init score
	@Test
	public void testTeamMatchValidInitScore() {
		Match match = buildNewMatch();
		Assert.assertEquals(match.getHomeTeam().getScore(), match.getAwayTeam().getScore());
	}
	
	private Match buildNewMatch() {
		return new Match(new Team("Team A", 0), new Team("Team B", 0));
	}

}
