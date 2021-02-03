package com;

public class Match {
	private Team team1;
	private Team team2;
	private int team1Runs;
	private int team2Runs;
	private int team1Wickets;
	private int team2Wickets;
	
	public Match(String team1, String team2) {
		this.team1 = CricketBoard.searchTeam(team1);
		this.team2 = CricketBoard.searchTeam(team2);
		this.team1Runs = CricketBoard.getRuns(team1);
		this.team2Runs = CricketBoard.getRuns(team2);
		this.team1Wickets = CricketBoard.getWickets(team1);
		this.team2Wickets = CricketBoard.getWickets(team2);
	}
	
	

	public Match(String team1, String team2, int team1Runs, int team2Runs, int team1Wickets, int team2Wickets) {
		this.team1 = CricketBoard.searchTeam(team1);
		this.team2 = CricketBoard.searchTeam(team2);
		this.team1Runs = team1Runs;
		this.team2Runs = team2Runs;
		this.team1Wickets = team1Wickets;
		this.team2Wickets = team2Wickets;
	}



	/**
	 * @return the team1
	 */
	public Team getTeam1() {
		return team1;
	}
	/**
	 * @param team1 the team1 to set
	 */
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	/**
	 * @return the team2
	 */
	public Team getTeam2() {
		return team2;
	}
	/**
	 * @param team2 the team2 to set
	 */
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	/**
	 * @return the team1Runs
	 */
	public int getTeam1Runs() {
		return team1Runs;
	}
	/**
	 * @param team1Runs the team1Runs to set
	 */
	public void setTeam1Runs(int team1Runs) {
		this.team1Runs = team1Runs;
	}
	/**
	 * @return the team2Runs
	 */
	public int getTeam2Runs() {
		return team2Runs;
	}
	/**
	 * @param team2Runs the team2Runs to set
	 */
	public void setTeam2Runs(int team2Runs) {
		this.team2Runs = team2Runs;
	}
	
	/**
	 * @return the team1Wickets
	 */
	public int getTeam1Wickets() {
		return team1Wickets;
	}

	/**
	 * @param team1Wickets the team1Wickets to set
	 */
	public void setTeam1Wickets(int team1Wickets) {
		this.team1Wickets = team1Wickets;
	}

	/**
	 * @return the team2Wickets
	 */
	public int getTeam2Wickets() {
		return team2Wickets;
	}

	/**
	 * @param team2Wickets the team2Wickets to set
	 */
	public void setTeam2Wickets(int team2Wickets) {
		this.team2Wickets = team2Wickets;
	}

	@Override
	public String toString() {
		return  team1.getTeamName()+"      "+team2.getTeamName()+"         " + team1Runs + "       " + team2Runs+"     ";
	}
	public static String result(Match match) {
		String str;
		if (match.team1Runs < match.team2Runs) {
			str = (match.team2.getTeamName() + " won by " + (match.team2Runs - match.team1Runs) + " runs");
		} else {
			str = (match.team1.getTeamName() + " won by " + (match.team1Runs - match.team2Runs) + " runs");
		}
		return str;
	}

}
