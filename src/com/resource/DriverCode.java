package com.resource;

import java.io.IOException;
import java.io.InputStream;
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
		CricketBoard.addTeam("India", players);

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
		CricketBoard.addTeam("Australia", players1);
		// adding new player in exiting team
		CricketBoard.addPlayer(new Player("Harbhajan"), "India");
		int key = 0;
		int switchKey;
		String str;
		try(Scanner sc = new Scanner(System.in)){
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
				System.out.println("Enter the team name");
				str=sc.nextLine();
				CricketBoard.showTeam(str);
				break;
			case 4:
				CricketBoard.showTeams(1);
				break;
			case 5:
				CricketBoard.showTotalTeams();
				break;
			case 6:
				System.out.println("Enter name to search");
				str=sc.nextLine();
				CricketBoard.search(str);
				break;
			case 7:
				System.out.println("Enter team name to search");
				str=sc.nextLine();
				CricketBoard.searchTeam("str");
				break;
			case 8:
				System.out.println("Enter player name to search");
				str=sc.nextLine();
				CricketBoard.searchPlayer("str");
				break;
			case 9:
				System.out.println("India wickets" + CricketBoard.getWickets("India"));
				System.out.println("Australia wickets" + CricketBoard.getWickets("Australia"));
				break;
			case 10:
				CricketBoard.matchResult("India", "Australia");
				break;
				default :
					System.out.println("Plase select correct option");
			}
			System.out.println("Press 0 to exit");
			key=sc.nextInt();
			sc.nextLine();
		} while (key != 0);
		}
	}

}
