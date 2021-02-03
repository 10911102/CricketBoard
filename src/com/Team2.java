package com;

import java.sql.Date;


public class Team2 implements Comparable<Team2> {
	private String teamName;
	private Date date;

	public Team2(String teamName) {
		this.teamName=teamName;
		this.date=new Date(System.currentTimeMillis());
	}

	public Team2(String teamName, Date date) {
		this.teamName=teamName;
		this.date=date;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
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
		if (obj == null && !(obj instanceof Team2))
			return false;
		return this.teamName.equals(((Team2) obj).teamName);
	}

	@Override
	public String toString() {
		String str = "Team : " + this.teamName + " Date : " + "\n";
		return str;
	}

	@Override
	public int compareTo(Team2 o) {

		return this.teamName.toString().compareTo(o.teamName.toString());
	}

}
