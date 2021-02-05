package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cricket.Match;

/**
 * Database related operations like create table, insert into table
 * 
 * @author swapnilu
 *
 */
public class MatchDataOperations {
	private static Connection con;
	private static Statement stmt;
	private static String sql;

	

	/**
	 * Creates table Match_History in Database
	 */
	public static void createMatchTable() {

		try {
			con = MysqlCon.getConnection();
			stmt = con.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS MATCH_HISTORY " + "(id INTEGER IDENTITY PRIMARY KEY , " + " Team1 VARCHAR(20), "
					+ " Team2 VARCHAR(20), " + "Team1Runs INTEGER," + "Team2Runs INTEGER," + "Team1Wickets INTEGER,"
					+ "Team2Wickets INTEGER)";
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
	
	public static void insert(Match match) {

		try {
			con = MysqlCon.getConnection();
			sql = "insert into MATCH_HISTORY " + "( Team1, Team2, Team1Runs, Team2Runs, Team1Wickets, Team2Wickets)"
					+ "values(?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, match.getTeam1().getName());
			stmt.setString(2, match.getTeam2().getName());
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

	public static List<Match> getAll() {
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
