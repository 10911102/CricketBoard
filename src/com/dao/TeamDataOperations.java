package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cricket.Team2;

/**
 * Database related operations like create table, insert into table
 * 
 * @author swapnilu
 *
 */
public class TeamDataOperations {
	private static Connection con;
	private static Statement stmt;
	private static String sql;

	

	/**
	 * Creates table Team in Database
	 */
	public static void createTeamTable() {

		try {
			con = MysqlCon.getConnection();
			stmt = con.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS Team " + "(id INTEGER IDENTITY  PRIMARY KEY , " + " tamName VARCHAR(20), "
					 + " date Date)";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void insertIntoTeam(Team2 team) {
		try {
			con = MysqlCon.getConnection();
			sql = "insert into team(tamName,date) values(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, team.getName());
			stmt.setDate(2, team.getDate());
			stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static List<Team2> getAll() {
		List<Team2> teams = new ArrayList<Team2>();
		try {
			con = MysqlCon.getConnection();
			stmt = con.createStatement();
			sql = "select * from Team";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Team2 team = new Team2(rs.getString(2), rs.getDate(3));
				teams.add(team);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return teams;

	}

	

	

}
