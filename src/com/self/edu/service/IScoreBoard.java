package com.self.edu.service;

import com.self.edu.model.Match;

public interface IScoreBoard {

	/**
	 * Initializes the score to 0 for every new match
	 */
	void initScore();
	
	/**
	 * Updates scores of a match
	 */
	void updateScore(Match match);
	
	/**
	 * Calculates the final score of a match 
	 */
	void calculateFinalScore(Match match);
}
