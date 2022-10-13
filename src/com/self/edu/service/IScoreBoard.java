package com.self.edu.service;

import java.util.List;

import com.self.edu.model.Match;

public interface IScoreBoard<M extends Match> {

	/**
	 * Adds new match to the scoreboard.
	 */
	void addMatch(M match) throws Exception;

	/**
	 * Updates scores of a match
	 */
	void updateScore(int matchId, int homeScore, int awayScore) throws Exception;

	/**
	 * Finish the game and remove the match from the scoreboard
	 */
	List<M> finishMatch(M match) throws Exception;

	/**
	 * Summarize the games based in order based on the most total score
	 */
	void summarizeMatch();
}
