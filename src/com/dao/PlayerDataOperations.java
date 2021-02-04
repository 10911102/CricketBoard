package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cricket.Player2;

public class PlayerDataOperations {
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
	 * Insert player data into match_history table
	 * 
	 * @param player details of player
	 * 
	 */
	
	public static void insertIntoPlayer(Player2 player) {
		try {
			con = MysqlCon.getConnection();
			sql = "insert into player(playerName,runs,playsFor) values(?,?,?)";
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
	public static List<Player2> getAll() {
		List<Player2> players = new ArrayList<Player2>();
		try {
			con = MysqlCon.getConnection();
			stmt = con.createStatement();
			sql = "select * from player";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Player2 player = new Player2(rs.getString(2), rs.getInt(3),rs.getString(4));
				players.add(player);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return players;

	}


}
