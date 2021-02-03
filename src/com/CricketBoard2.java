package com;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Utility class for Cricket Team System to add or show or search teams and
 * players in system
 * 
 * @author swapnilu
 *
 */
public class CricketBoard2 {
	private static List<Team2> teams = new ArrayList<Team2>();
	private static List<Match> matches = new ArrayList<Match>();
	private static Scanner sc = new Scanner(System.in);
	/**
	 * Appends the new team object to teams list with players
	 * 
	 * @param teamName Country name
	 * @param players  collection of players belongs to Country
	 * 
	 */
	public static boolean addTeam(String teamName) {
		Team2 team = new Team2(teamName);
		teams.add(team);
		DataOperations.insertIntoTeam(team);
		Player2.setPlaying(1);
		return true;
	}

	/**
	 * Add new player in existing team
	 * 
	 * @param player player object to add in player set in team
	 * @param team   name of the team
	 * @return true if new player added successfully
	 */
	public static boolean addPlayer() {
		boolean flag = false;
		System.out.println("Enter player name");
		String playerName=sc.nextLine();
		System.out.println("select player's Team Name");
		System.out.println("1. "+Country.INDIA);
		System.out.println("2. "+Country.AUSTRALIA);
		System.out.println("3. "+Country.SHREELANKA);
		int choice=sc.nextInt();
		String teamName = null;
		sc.nextLine();
		switch(choice) {
		case 1:
			teamName=Country.INDIA.toString();
			break;
		case 2:
			teamName=Country.AUSTRALIA.toString();
			break;
		case 3:
			teamName=Country.SHREELANKA.toString();
			break;
			default:
				System.out.println("pls Enter Valid Number");
		}
		Player2 player=new Player2(playerName,teamName);
		DataOperations.insertIntoPlayer(player);
		return flag;
	}

	/**
	 * Add player in existing set of players
	 * 
	 * @param players existing Set of players
	 * @param player  new object to add in set
	 * @return true if new player added successfully
	 */
	public static boolean addPlayer(TreeSet<Player2> players, Player2 player) {
		players.add(player);
		
		return true;
	}

	/**
	 * shows the list of team and players(sorted) in team.
	 */
	public static void showTeams() {
		int count = 0;
		List<Team2> t1 = DataOperations.getTeamTable();
		Collections.sort(t1);
		System.out.println("Name of Teams Sorted By Name");
		System.out.println("SrNo.      Team Name        Date");
		for (Team2 to : t1)
			System.out.println(++count + ".     " + to.getTeamName()+"          "+to.getDate());
	}

	/**
	 * shows the list of team sorted by time of team created.
	 * 
	 * @param date false parameter for overloading method
	 */
	public static void showTeams(Calendar date) {
		Comparator<Team2> com = new Comparator<Team2>() {

			@Override
			public int compare(Team2 o1, Team2 o2) {
				if (o1 == null || o2 == null) {
					return -1;
				}
				if (o1.getDate().before(o2.getDate())) {
					return -1;
				} else if (o1.getDate().after(o2.getDate())) {
					return 1;
				}
				return 0;
			}

		};
		List<Team2> t1 = teams;

		Collections.sort(t1, com);
		System.out.println("Name of Teams Sorted By Date");
		showTeams(t1);

	}

	/**
	 * print given list
	 * 
	 * @param list collection of Team class
	 */
	public static void showTeams(List<Team2> list) {
		int count = 0;
		for (Team2 team : list) {
			System.out.println(++count + ".  " + team.getTeamName());
		}
	}

	/**
	 * Displays the list of players in given team
	 * 
	 * @param string name of the team
	 */
	public static void showTeam(String string) {
		for (Team2 t : teams) {
			if (t.getTeamName().equals(string)) {
				System.out.println(t);
			}
		}
	}

	/**
	 * Displays the list of Team and number of players in team
	 * 
	 * @param i false parameter for overloading method
	 */
	public static void showTeams(int i) {
		i = 0;
		for (Team2 t : teams) {
			System.out.println(++i + "  " + t.getTeamName() + "  No. of players : " );
		}
	}

	/**
	 * Displays the total number of teams
	 * 
	 */
	public static void showTotalTeams() {
		System.out.println("Number of teams : " + teams.size());

	}

	/**
	 * Returns the object Team if team is present else it will return null
	 * 
	 * @param string String to search team name
	 * @return Object of Team or null
	 */
	public static Team2 searchTeam(String string) {
		for (Team2 t : teams) {
			if (t.getTeamName().toString().equalsIgnoreCase(string)) {
				return t;
			}
		}
		System.out.println("Try another name!!");
		return null;
	}

	/**
	 * Returns the object Player if player is present or it will return null
	 * 
	 * @param string String to search player name
	 * @return Object of Player or null
	 */
/*	public static Player2 searchPlayer(String string) {
	*	for (Team2 t : teams) {
*			for (Player2 p : t.getPlayers()) {
	*			if (p.getName().equalsIgnoreCase(string)) {
	*				System.out.println("Player Found");
	*				return p;
	*			}
			}
		}
		System.out.println("Try another name!!");
*		return null;
*	}
*/
	/**
	 * shows the given string is Team or Player
	 * 
	 * @param string name of the team or player
	 */
	public static void search(String string) {
		for (Team2 t : teams) {
			if (t.getTeamName().toString().equalsIgnoreCase(string)) {
				System.out.println("Team " + string + " found.");
				break;
			} else {
				/*
				 * Player p = new Player(string); if (t.getPlayers().contains(p)) {
				 * System.out.println("Player " + string + " Found in team " + t.getTeamName());
				 	break;
			*/	}
				System.out.println("Try another name!!");
			}
		}
	

	/**
	 * Total runs scored by team
	 * 
	 * @param team name of the team
	 * @return total runs
	 */
	public static int getRuns(String team) {
		return 1;
	}

	/**
	 * Total Wickets gone of team
	 * 
	 * @param team name of the team
	 * @return total wickets
	 */
	public static int getWickets(String team) {
		return 1;//searchTeam(team.toString()).totalWickets();
	}

	/**
	 * Shows the match result
	 * 
	 * @param team1 first team name
	 * @param team2 second team name
	 */
	public static String matchResult(String team1, String team2) {
		Match match =new Match(team1.toString(), team2.toString());
		
		/*
		 * for(Player2 player : searchTeam(team1.toString())) player.randomInit();
		 * for(Player player : searchTeam(team2.toString()).getPlayers())
		 * player.randomInit();
		 */matches.add(match);
		DataOperations.insertMatchTable(match);
		return Match.result(match);
	}

	public static void showHistory() {
		System.out.println("  Match between             Runs by   Runs by           Wining");
		System.out.println("Team1        Team2          Team1     Team2              Team");
		for (Match match : DataOperations.getMatchTable())
			System.out.println(match+Match.result(match));
	}

}
