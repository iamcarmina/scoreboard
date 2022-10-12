package com.self.edu.model;

public abstract class Match {

	protected int matchId;
	protected Team homeTeam;
	protected Team awayTeam;
	protected boolean isFinished;

	public Match() {
	}

	public Match(int matchId) {
		this.matchId = matchId;
	}

	// MatchID is added here since this is just a simple application and to be able
	// to do some operations I have to know the matchId.
	// If this is done with a frontend, the matchId will be auto-generated.
	public Match(int matchId, Team homeTeam, Team awayTeam) {
		this.matchId = matchId;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public Team getHomeTeam() {
		// TODO Auto-generated method stub
		return homeTeam;
	}

	public Team getAwayTeam() {
		// TODO Auto-generated method stub
		return awayTeam;
	}

	/**
	 * @param homeTeam the homeTeam to set
	 */
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	/**
	 * @param awayTeam the awayTeam to set
	 */
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	/**
	 * Forces both teams' score to be initialized to 0
	 */
	public abstract Match initTeamScore();

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

}
