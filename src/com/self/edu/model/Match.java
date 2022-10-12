package com.self.edu.model;

public class Match {

	private Team homeTeam;
	private Team awayTeam;
	
	
	public Match(Team homeTeam, Team awayTeam) {
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
	
	

}
