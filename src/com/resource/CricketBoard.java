package com.resource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Utility class for Cricket Team System
 * 
 * @author swapnilu
 *
 */
public class CricketBoard {
	private static List<Team> teams = new ArrayList<Team>();

	/**
	 * Add new team
	 * 
	 * @param name    for new team
	 * @param players set of players
	 * @return true if new team created successfully
	 */
	public static boolean addTeam(String name, TreeSet<Player> players) {
		Team t = new Team(name, players);
		teams.add(t);
		return true;
	}

	/**
	 * Add new player in existing team
	 * 
	 * @param player player object to add in player set in team
	 * @param team   name of the team
	 * @return true if new player added successfully
	 */
	public static boolean addPlayer(Player player, String team) {
		// Team team1=new Team(team);
		boolean flag = false;
		for (Team t : teams) {
			if (t.getTeamName().equals(team)) {
				t.getPlayers().add(player);
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * Add player in existing set of players
	 * 
	 * @param players existing set of players
	 * @param player  new object to add in set
	 * @return true if new player added successfully
	 */
	public static boolean addPlayer(TreeSet<Player> players, Player player) {
		players.add(player);
		return true;
	}

	/**
	 * shows the list of team and players(sorted) in team.
	 */
	public static void showTeams() {
		int count = 0;
		List<Team> t1 = teams;
		Collections.sort(t1);
		System.out.println("Name of Teams Sorted By Name");
		for (Team to : t1)
			System.out.println(++count + ".  " + to.getTeamName());
	}

	/**
	 * shows the list of team sorted by time of team created.
	 * @param date false parameter for overloading method
	 */
	public static void showTeams(Calendar date) {
		Comparator<Team> com = new Comparator<Team>() {

			@Override
			public int compare(Team o1, Team o2) {
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
		List<Team> t1 = teams;
		int count = 0;
		Collections.sort(t1, com);
		System.out.println("Name of Teams Sorted By Date");
		for (Team to : t1) {
			System.out.println(++count + ".  " + to.getTeamName());
		}

	}

	/**
	 * Displays the list of players in given team
	 * 
	 * @param string name of the team
	 */
	public static void showTeam(String string) {
		for (Team t : teams) {
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
		for (Team t : teams) {
			System.out.println(++i + "  " + t.getTeamName() + "  No. of players : " + t.getPlayers().size());
		}
	}
	/**
	 * Displays the total number of teams 
	 * 
	 */
	public static void showTotalTeams() {
		System.out.println("Number of teams : "+teams.size());
		
	}

}
