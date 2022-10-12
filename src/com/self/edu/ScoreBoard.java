package com.self.edu;

import java.util.ArrayList;
import java.util.List;

import com.self.edu.model.Match;
import com.self.edu.service.IScoreBoard;

/**
 * A scoreboard contains a lists of {@code Match}(es), where a {@code Match} should have two {@code Team}(s).
 */
public class ScoreBoard implements IScoreBoard {

	public List<Match> getMatches() {
		// TODO Auto-generated method stub
		return new ArrayList<Match>();
	}

	@Override
	public void initScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateScore(Match match) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateFinalScore(Match match) {
		// TODO Auto-generated method stub
		
	}
	
	

}
