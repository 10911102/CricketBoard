package com.resource;

import java.util.Calendar;
import java.util.TreeSet;

public class Team implements Comparable<Team>{
	private String teamName;
	private TreeSet<Player> players;
	private Calendar date;

	public Team(String teamName, TreeSet<Player> players) {
		this.teamName = teamName;
		this.players = players;
		this.date = Calendar.getInstance();
	}

	public Team(TreeSet<Player> players, Calendar date) {
		this.players = players;
		this.date = date;
	}

	public Team(String team) {
		this.teamName = team;
	}

	/**
	 * @return the players
	 */
	public TreeSet<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(TreeSet<Player> players) {
		this.players = players;
	}

	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null && !(obj instanceof Team))
			return false;
		return this.teamName.equals(((Team) obj).teamName);
	}

	@Override
	public String toString() {
		int count = 0;
		String str = "Team : " + this.teamName + " Date : "+this.date.get(1)+"/"+this.date.get(0)+"/"+this.date.get(6)+"\n";
		for (Player p : players) {
			str += ++count + "  " + p + System.lineSeparator();
		}
		return str;
	}

	@Override
	public int compareTo(Team o) {
		
		return this.teamName.compareTo(o.teamName);
	}
	public int totalRuns() {
		int total=0;
		for(Player p:players) {
			total+=p.getRun();
		}
		return total;
	}

}
