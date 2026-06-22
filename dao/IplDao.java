package com.tka.dao;
import com.tka.entity.Player;

import java.sql.*;
import java.util.*;

public class IplDao {
	//Using ArrayList
	
	private List<Player> ipl_db=null;
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String url="jdbc:mysql://localhost:3306/IPLProjectDB";
	String uname="root";
	String pass="root";
	
	
	private Connection getConnection()
	{
	
		try{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,uname,pass);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public List<Player> getAllPlayer()
	{
		ipl_db=new ArrayList<>();
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//conn=DriverManager.getConnection(url,uname,pass);
			getConnection();
			pst=conn.prepareStatement("Select * From Player");
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				int jersyNo=rs.getInt(1);
				String name=rs.getString(2);
				String teamName=rs.getString(3);
				String category=rs.getString(4);
				int runs=rs.getInt(5);
				int wickets=rs.getInt(6);
				
				Player p=new Player(jersyNo,name,teamName,category,runs,wickets);
				ipl_db.add(p);
		
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return ipl_db;
	}

	

	public void insertPlayer(Player p) {
		
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//conn=DriverManager.getConnection(url,uname,pass);
			getConnection();
			pst=conn.prepareStatement("INSERT INTO Player VALUES(?,?,?,?,?,?)");
			
			pst.setInt(1,p.getJersyNo());
			pst.setString(2,p.getName());
			pst.setString(3,p.getTeamName());
			pst.setString(4,p.getCategory());
			pst.setInt(5,p.getRuns());
			pst.setInt(6,p.getWickets());
			
			int rowsAffected=pst.executeUpdate();
			if(rowsAffected>0)
				System.out.println("Player Inserted Successfully...");
			
		}
		
		 catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	public void deletePlayerByJersyNo(int jersyNo) {
		getConnection();
		
		try {
			pst=conn.prepareStatement("Delete From Player where jersyNo=(?)");
			pst.setInt(1,jersyNo);
			int a=pst.executeUpdate();
			
			if(a>0)
				System.out.println("Player Deleted Successfully...");
			else
				System.out.println("Player not found...");
			
			} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	

}
