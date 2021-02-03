package com;

import java.util.Calendar;
import java.util.Scanner;

public class DriverCode2 {

	public static void main(String[] args) {
		
		//testing db
		//DataOperations.createPlayerTable();
		//DataOperations.createMatchTable();
		//DataOperations.createTeamTable();
		//CricketBoard2.addPlayer();
		//CricketBoard2.addTeam("Australia");
		//CricketBoard2.addTeam("Shreelanka");
		
		int key = 0;
		int switchKey;
		String str;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("Welcome select option");
				System.out.println("1.show all teams alphabetically ");
				System.out.println("2.show all teams sorted by date");
				System.out.println("3.show all players in team");
				System.out.println("4.show all teams with number of player");
				System.out.println("5.show total number of teams");
				System.out.println("6.search the given string is Team or Player");
				System.out.println("7.search the object of team by given string");
				System.out.println("8.search the object of Player by given string");
				System.out.println("9.show wickets of the team");
				System.out.println("10. Ooohhhooo!! Play the Game");
				System.out.println("11. show old Matches");
				switchKey = sc.nextInt();
				sc.nextLine();
				switch (switchKey) {
				case 1:
					CricketBoard2.showTeams();
					break;
				case 2:
					CricketBoard2.showTeams(Calendar.getInstance());
					break;
				case 3:
					str=showCountry();
					CricketBoard2.showTeam(str);
					break;
				case 4:
					CricketBoard2.showTeams(1);
					break;
				case 5:
					CricketBoard2.showTotalTeams();
					break;
				case 6:
					System.out.println("Enter any name to search");
					str = sc.nextLine();
					CricketBoard2.search(str);
					break;
				case 7:
					str=showCountry();
					CricketBoard2.searchTeam("str");
					break;
				case 8:
					System.out.println("Enter player name to search");
					str = sc.nextLine();
					CricketBoard.searchPlayer("str");
					break;
				case 9:
					System.out.println("India wickets" + CricketBoard2.getWickets(Country.INDIA.toString()));
					System.out.println("Australia wickets" + CricketBoard2.getWickets(Country.AUSTRALIA.toString()));
					break;
				case 10:
					System.out.println(CricketBoard.matchResult(Country.INDIA.toString(), Country.AUSTRALIA.toString()));
					break;
				case 11:
					CricketBoard.showHistory();
					break;
				default:
					System.out.println("Plase select correct option");
				}
				System.out.println("Press 0 to exit");
				key = sc.nextInt();
				sc.nextLine();
			} while (key != 0);
		}
	}

	private static String showCountry() {
		String str="";
		try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Select the team name");
		System.out.println(
				"1." + Country.INDIA + "2." + Country.AUSTRALIA + "3." + Country.SHREELANKA + "\n");
		int i = sc.nextInt();
		switch (i) {
		case 1:
			str = Country.INDIA.toString();
			break;
		case 2:
			str = Country.AUSTRALIA.toString();
			break;
		case 3:
			str = Country.SHREELANKA.toString();
			break;
		}
		sc.nextLine();
		}
		
		return str;
	}

}
