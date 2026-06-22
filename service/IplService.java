package com.tka.service;

import java.util.*;
import java.util.List;

import com.tka.dao.IplDao;
import com.tka.entity.Player;

public class IplService {
	
	private List<Player> ipl_db=null;
	private IplDao ipldao=null;
	
	public List<Player> getAllPlayer()
	{
		ipldao=new IplDao();
		
		ipl_db=ipldao.getAllPlayer();
		
		return ipl_db;
	}
	
	private List<Player> player_by_team=null;
	public List<Player> getPlayerByTeam(String team)
	{
		ipldao = new IplDao();
		
		ipl_db = ipldao.getAllPlayer();
		player_by_team = new ArrayList<>();
		
		for(int i=0;i<ipl_db.size();i++)
		{
		Player p = ipl_db.get(i);
		
		if(team.equals(p.getTeamName()))
		{
			player_by_team.add(p);
		}
		}
		return player_by_team;
	}
	
	/*public void insertPlayer(String name, int jersyNo, String teamName, String category, int runs, int wickets) {
		
		IplDao ipldao = new IplDao();
		
		ipldao.insertPlayer(name,jersyNo,teamName,category,runs,wickets);
		
	}*/

	public void insertPlayer(Player p) {
        IplDao ipldao = new IplDao();
		ipldao.insertPlayer(new Player(p.getJersyNo(),p.getName(),p.getTeamName(),p.getCategory(),p.getRuns(),p.getWickets()));
	}

	public void deletePlayerByJersyNo(int jersyNo) {
		IplDao ipldao=new IplDao();
		ipldao.deletePlayerByJersyNo(jersyNo);
		
	}

}
