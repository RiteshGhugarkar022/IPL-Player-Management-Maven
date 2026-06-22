package com.tka.controller;

import java.util.List;

import com.tka.entity.Player;
import com.tka.service.IplService;

public class IplController {
	
	public static void main(String[] args) {
		
	IplService iplservice=new IplService();
	
	List<Player> allPlayers =iplservice.getAllPlayer();
	System.out.println("All Players List\n");
	System.out.println("Name-->>JersyNo-->>TeamName-->>Category-->>Runs-->>Wickets");
	for(int i=0;i<allPlayers.size();i++)
	{
		Player p=allPlayers.get(i);
		System.out.println(p.getName()+" -->> "+p.getJersyNo()+" -->> "+p.getTeamName()+" -->> "+p.getCategory()+" -->> "+p.getRuns()+" -->> "+p.getWickets());
	}
	
	System.out.println();
	System.out.println("Players List By Team\n");
	List<Player> playersByTeam =iplservice.getPlayerByTeam("RCB");
	for(int i=0;i<playersByTeam.size();i++)
	{
		Player p=playersByTeam.get(i);
		System.out.println(p.getName()+" -->> "+p.getJersyNo()+" -->> "+p.getTeamName()+" -->> "+p.getCategory()+" -->> "+p.getRuns()+" -->> "+p.getWickets());
		
	}
	
	iplservice.insertPlayer(new Player(864,"Shreyas Iyyer","PBKS","Batsman",7856,3));
	
	
	iplservice.deletePlayerByJersyNo(45);
	
}
}
