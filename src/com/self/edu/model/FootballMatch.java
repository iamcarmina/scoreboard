package com.self.edu.model;

public class FootballMatch extends Match {

	public FootballMatch(int matchId) {
		super(matchId);
	}

	public FootballMatch(int matchId, Team homeTeam, Team awayTeam) {
		super(matchId, homeTeam, awayTeam);
	}
	
	@Override
	public FootballMatch initTeamScore() {
		this.homeTeam.setScore(0);
		this.awayTeam.setScore(0);
		return this;
	}

}
