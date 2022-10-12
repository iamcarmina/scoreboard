package com.self.edu;

import java.util.Arrays;
import java.util.List;

import com.self.edu.model.FootballMatch;
import com.self.edu.model.Team;

public class App {

	public static void main(String... args) throws Exception {
		List<FootballMatch> matchList = Arrays.asList(buildMatch(1, "Mexico", "Canada"),
				buildMatch(2, "Spain", "Brazil"), buildMatch(3, "Germany", "France"), buildMatch(4, "Uruguay", "Italy"),
				buildMatch(5, "Argentina", "Australia"));

		ScoreBoard scoreBoard = new ScoreBoard(matchList);
		System.out.println("   INITIALIZING MATCH");
		System.out.println("-------------------------");
		scoreBoard.initScore();

		System.out.println("\n   UPDATING SCORE FOR MATCH ID = 1  ");
		System.out.println("----------------------------------------");
		scoreBoard.updateScore(1, 1, 0);
		scoreBoard.updateScore(2, 1, 0);
		scoreBoard.updateScore(3, 2, 2);
		scoreBoard.updateScore(4, 10, 12);
		scoreBoard.updateScore(5, 3, 1);
		scoreBoard.getMatches().stream().forEach(e->scoreBoard.printMatchDetails(e));
		
		System.out.println("\n   FINISHING GAME FOR MATCH ID = 1");
		System.out.println("----------------------------------------");
		scoreBoard.finishMatch(new FootballMatch(1));
		
		System.out.println("----------------------------------------");
		scoreBoard.getMatches().stream().forEach(e->scoreBoard.printMatchDetails(e));
		
	}

	public static FootballMatch buildMatch(int matchId, String teamA, String teamB) {
		return new FootballMatch(matchId, new Team(teamA), new Team(teamB));
	}
}
