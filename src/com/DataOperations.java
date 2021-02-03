package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Database related operations like create table, inster into table
 * 
 * @author swapnilu
 *
 */
public class DataOperations {
	private static Connection con;
	private static Statement stmt;
	private static String sql;
	public static int count = 1;

	/**
	 * Creates table Player in Database
	 */
	public static void createPlayerTable() {

		try {
			con = MysqlCon.getConnection();
			stmt = con.createStatement();
			sql = "CREATE TABLE PLAYER " + "(id INTEGER not NULL AUTO_INCREMENT, " + " name VARCHAR(20), "
					+ " runs INTEGER, " + " PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
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
			// CREATE TABLE MATCH (id INTEGER not NULL AUTO_INCREMENT, Team1 VARCHAR(20),
			// Team2 VARCHAR(20), Team1Runs INTEGER, Team2Runs INTEGER, Team1Wickets
			// INTEGER, Team2Wickets INTEGER, PRIMARY KEY ( id ));
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

	/**
	 * Insert player data into match_history table
	 * 
	 * @param player details of player
	 * 
	 */
	public static void insertIntoPlayer(Player player) {
		try {
			con = MysqlCon.getConnection();
			sql = "insert into player(name,runs) values(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, player.getName());
			stmt.setInt(2, player.getRun());
			stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
