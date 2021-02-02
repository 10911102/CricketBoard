package com;

import java.util.Calendar;
import java.util.Scanner;
import java.util.TreeSet;

public class DriverCode {

	public static void main(String[] args) {
		TreeSet<Player> players = new TreeSet<Player>();
		CricketBoard.addPlayer(players, new Player("Sachin"));
		CricketBoard.addPlayer(players, new Player("Saurabh"));
		CricketBoard.addPlayer(players, new Player("Sehwag"));
		CricketBoard.addPlayer(players, new Player("Rohit"));
		CricketBoard.addPlayer(players, new Player("Virat"));
		CricketBoard.addPlayer(players, new Player("Rahul"));
		CricketBoard.addPlayer(players, new Player("Jasprit"));
		CricketBoard.addPlayer(players, new Player("Dhoni"));
		CricketBoard.addPlayer(players, new Player("Ravindra"));
		// creating new team India
		CricketBoard.addTeam(Country.INDIA, players);

		TreeSet<Player> players1 = new TreeSet<Player>();
		CricketBoard.addPlayer(players1, new Player("David Warner"));
		CricketBoard.addPlayer(players1, new Player("Steve Smith"));
		CricketBoard.addPlayer(players1, new Player("Glenn Maxwell"));
		CricketBoard.addPlayer(players1, new Player("Marcus Stoinis"));
		CricketBoard.addPlayer(players1, new Player("Alex Carey"));
		CricketBoard.addPlayer(players1, new Player("Matthew Wade"));
		CricketBoard.addPlayer(players1, new Player("Peter Handscomb"));
		CricketBoard.addPlayer(players1, new Player("Adam Zampa"));
		CricketBoard.addPlayer(players1, new Player("Kane Richardson"));
		// creating new team Australia
		CricketBoard.addTeam(Country.AUSTRALIA, players1);
		// adding new player in exiting team
		CricketBoard.addPlayer(new Player("Harbhajan"), Country.INDIA);
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
					CricketBoard.showTeams();
					break;
				case 2:
					CricketBoard.showTeams(Calendar.getInstance());
					break;
				case 3:
					str=showCountry();
					CricketBoard.showTeam(str);
					break;
				case 4:
					CricketBoard.showTeams(1);
					break;
				case 5:
					CricketBoard.showTotalTeams();
					break;
				case 6:
					System.out.println("Enter any name to search");
					str = sc.nextLine();
					CricketBoard.search(str);
					break;
				case 7:
					str=showCountry();
					CricketBoard.searchTeam("str");
					break;
				case 8:
					System.out.println("Enter player name to search");
					str = sc.nextLine();
					CricketBoard.searchPlayer("str");
					break;
				case 9:
					System.out.println("India wickets" + CricketBoard.getWickets(Country.INDIA.toString()));
					System.out.println("Australia wickets" + CricketBoard.getWickets(Country.AUSTRALIA.toString()));
					break;
				case 10:
					System.out.println(CricketBoard.matchResult(Country.INDIA, Country.AUSTRALIA));
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
