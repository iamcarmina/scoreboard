package com.self.edu.model;

import java.util.Date;

public abstract class Match {

	protected Integer matchId;
	protected Team homeTeam;
	protected Team awayTeam;
	protected Date gameStartDate;
	protected Date gameEndDate;
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
		this.gameStartDate = new Date();
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

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
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

	/**
	 * @return the gameStartDate
	 */
	public Date getGameStartDate() {
		return gameStartDate;
	}

	/**
	 * @param gameStartDate the gameStartDate to set
	 */
	public void setGameStartDate(Date gameStartDate) {
		this.gameStartDate = gameStartDate;
	}

	/**
	 * @return the gameEndDate
	 */
	public Date getGameEndDate() {
		return gameEndDate;
	}

	/**
	 * @param gameEndDate the gameEndDate to set
	 */
	public void setGameEndDate(Date gameEndDate) {
		this.gameEndDate = gameEndDate;
	}

}
