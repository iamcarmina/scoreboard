package com.self.edu.model;

public class Team {

	private int score;
	private String name;

	public Team() {
		this.name = "";
		this.score = 0;
	}

	public Team(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
