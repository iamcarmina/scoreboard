package com.self.edu.service;

import com.self.edu.model.Match;

public interface IScoreBoard<M extends Match> {

	/**
	 * Initializes the score to 0 for every new match
	 */
	void initScore();

	/**
	 * Updates scores of a match
	 */
	void updateScore(int matchId, int homeScore, int awayScore) throws Exception;

	/**
	 * Finish the game and remove the match from the scoreboard
	 */
	void finishMatch(M match) throws Exception;

	void printMatchDetails(M match);

	void summarizeMatch();
}
