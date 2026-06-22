package com.tka.entity;

public class Player {
	
private int jersyNo;
private String name;
private String teamName;
private String category;
private int runs;
private int wickets;


public Player() {
	super();
	// TODO Auto-generated constructor stub
}


public Player(int jersyNo,String name,String teamName, String category, int runs, int wickets) {
	super();
	this.name = name;
	this.jersyNo = jersyNo;
	this.teamName = teamName;
	this.category = category;
	this.runs = runs;
	this.wickets = wickets;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getJersyNo() {
	return jersyNo;
}
public void setJersyNo(int jersyNo) {
	this.jersyNo = jersyNo;
}
public String getTeamName() {
	return teamName;
}
public void setTeamName(String teamName) {
	this.teamName = teamName;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getRuns() {
	return runs;
}
public void setRuns(int runs) {
	this.runs = runs;
}
public int getWickets() {
	return wickets;
}
public void setWickets(int wickets) {
	this.wickets = wickets;
}


@Override
public String toString() {
	return "Player [name=" + name + ", jersyNo=" + jersyNo + ", teamName=" + teamName + ", category=" + category
			+ ", runs=" + runs + ", wickets=" + wickets + "]";
}




}
