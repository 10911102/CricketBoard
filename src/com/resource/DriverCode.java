package com.resource;

import java.util.Calendar;
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
		//creating new team India
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
		//creating new team Australia
		CricketBoard.addTeam("Australia", players1);
		// adding new player in exiting team
		CricketBoard.addPlayer(new Player("Harbhajan"), "India");
		//showing all teams alphabetically 
		CricketBoard.showTeams();
		CricketBoard.showTeams(Calendar.getInstance());
		CricketBoard.showTeam("India");
		CricketBoard.showTeams(1);
		CricketBoard.showTotalTeams();
		
		
		
	}

}
