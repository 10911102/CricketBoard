package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Database related operations like create table, insert into table
 * 
 * @author swapnilu
 *
 */
public class DataOperations {
	private static Connection con;
	private static Statement stmt;
	private static String sql;

	/**
	 * Creates table Player in Database
	 */
	public static void createPlayerTable() {

		try {
			con = MysqlCon.getConnection();
			stmt = con.createStatement();
			sql = "CREATE TABLE PLAYER " + "(id INTEGER not NULL AUTO_INCREMENT, " + " playerName VARCHAR(20), "
					+ " runs INTEGER, " + " playsFor VARCHAR(20), " + " PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Creates table Team in Database
	 */
	public static void createTeamTable() {

		try {
			con = MysqlCon.getConnection();
			stmt = con.createStatement();
			sql = "CREATE TABLE Team " + "(id INTEGER not NULL AUTO_INCREMENT, " + " tamName VARCHAR(20), "
					 + " date Date, " + " PRIMARY KEY ( id ))";
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
			stmt.setString(1, team.getTeamName());
			stmt.setDate(2, team.getDate());
			stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static List<Team2> getTeamTable() {
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

	/**
	 * Insert player data into match_history table
	 * 
	 * @param player details of player
	 * 
	 */
	public static void insertIntoPlayer(Player2 player) {
		try {
			con = MysqlCon.getConnection();
			sql = "insert into player(name,runs,playsFor) values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, player.getName());
			stmt.setInt(2, player.getRun());
			stmt.setString(3, player.getPlaysFor());
			stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Creates table Match_History in Database
	 */
	public static void createMatchTable() {

		try {
			con = MysqlCon.getConnection();
			stmt = con.createStatement();
			sql = "CREATE TABLE MATCH_HISTORY " + "(id INTEGER not NULL AUTO_INCREMENT, " + " Team1 VARCHAR(20), "
					+ " Team2 VARCHAR(20), " + "Team1Runs INTEGER," + "Team2Runs INTEGER," + "Team1Wickets INTEGER,"
					+ "Team2Wickets INTEGER," + " PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	

	/**
	 * Insert record(match) into match_history table
	 * 
	 * @param match details of match
	 */
	public static void insertMatchTable(Match match) {

		try {
			con = MysqlCon.getConnection();
			sql = "insert into MATCH_HISTORY " + "( Team1, Team2, Team1Runs, Team2Runs, Team1Wickets, Team2Wickets)"
					+ "values(?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, match.getTeam1().getTeamName().toString());
			stmt.setString(2, match.getTeam2().getTeamName().toString());
			stmt.setInt(3, match.getTeam1Runs());
			stmt.setInt(4, match.getTeam2Runs());
			stmt.setInt(5, match.getTeam1Wickets());
			stmt.setInt(6, match.getTeam2Wickets());
			stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static List<Match> getMatchTable() {
		List<Match> matches = new ArrayList<Match>();
		try {
			con = MysqlCon.getConnection();
			stmt = con.createStatement();
			sql = "select * from match_history";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Match match = new Match(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getInt(7));
				matches.add(match);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return matches;
	}

	

}
