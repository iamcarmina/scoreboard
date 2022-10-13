package com.self.edu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.self.edu.model.FootballMatch;
import com.self.edu.model.Team;

public class App {

	public static void main(String... args) throws Exception {
		List<FootballMatch> matchList = new ArrayList<FootballMatch>();
		matchList.add(buildMatch(1, "Mexico", "Canada"));
		matchList.add(buildMatch(2, "Spain", "Brazil"));
		matchList.add(buildMatch(3, "Germany", "France"));
		matchList.add(buildMatch(4, "Uruguay", "Italy"));
		matchList.add(buildMatch(5, "Argentina", "Australia"));

		ScoreBoard scoreBoard = new ScoreBoard(matchList);
		System.out.println("   INITIALIZING MATCH ");
		System.out.println("----------------------------------------");
		scoreBoard.getMatches().stream().forEach(e -> scoreBoard.printMatchDetails(e));

		System.out.println("\n   UPDATING SCORE FOR MATCH ID = 1  ");
		System.out.println("----------------------------------------");
		scoreBoard.updateScore(1, 1, 0);
		scoreBoard.updateScore(2, 1, 0);
		scoreBoard.updateScore(3, 2, 2);
		scoreBoard.updateScore(4, 10, 12);
		scoreBoard.updateScore(5, 3, 1);
		scoreBoard.getMatches().stream().forEach(e -> scoreBoard.printMatchDetails(e));

		System.out.println("\n   ADDING NEW MATCHES ");
		System.out.println("----------------------------------------");
		FootballMatch newMatch = buildMatch(6, "Singapore", "Malaysia");

		// The game time is purposely set to demonstrate item #4 in the coding exercise.
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 5);
		newMatch.setGameStartDate(cal.getTime());
		scoreBoard.addMatch(newMatch);

		FootballMatch secondNewMatch = buildMatch(7, "Indonesia", "Cambodia");
		// The game time is purposely set to demonstrate item #4 in the coding exercise.
		cal.set(Calendar.HOUR, 4);
		secondNewMatch.setGameStartDate(cal.getTime());
		scoreBoard.addMatch(secondNewMatch);
		// scoreBoard.updateScore(6, 3, 1);

		System.out.println("\n   UPDATED MATCH LIST ");
		System.out.println("----------------------------------------");
		scoreBoard.getMatches().stream().forEach(e -> scoreBoard.printMatchDetails(e));

		System.out.println("\n   FINISHING GAME FOR MATCH ID = 4");
		System.out.println("----------------------------------------");
		List<FootballMatch> newMatchList = scoreBoard.finishMatch(new FootballMatch(4));
		newMatchList.stream().forEach(e -> scoreBoard.printMatchDetails(e));

		System.out.println("\n   SUMMARIZING MATCH ");
		System.out.println("----------------------------------------");
		scoreBoard.summarizeMatch();
		scoreBoard.getMatches().stream().forEach(e -> scoreBoard.printMatchDetails(e));

	}

	public static FootballMatch buildMatch(int matchId, String teamA, String teamB) {
		return new FootballMatch(matchId, new Team(teamA), new Team(teamB));
	}
}
