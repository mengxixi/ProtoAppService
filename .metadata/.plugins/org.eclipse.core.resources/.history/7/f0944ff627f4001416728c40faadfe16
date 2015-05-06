package com.srk.pkg;

import java.util.ArrayList;
import java.util.Random;

public class Team {
	private ArrayList<String> members;
	private int teamNumber;
	private boolean isQuestioning;
	private int score;
	private String captain;
	
	public Team(){
		members = new ArrayList<String>();
		isQuestioning = false;
		score = 0;
		captain = null;
		
	}
	
	public void selectCaptain() {
		if (this.members.size() < 3) return;
		Random rand = new Random(System.currentTimeMillis());
	    int randomNum = rand.nextInt((2 - 0) + 1) + 0;
	    captain = members.get(randomNum);
	    
	}
	
	public ArrayList<String> getMembers() {
		return members;
	}
	
	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}
	
	public boolean isQuestioning() {
		return isQuestioning;
	}
	
	public void setQuestioning(boolean isQuestioning) {
		this.isQuestioning = isQuestioning;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

}
