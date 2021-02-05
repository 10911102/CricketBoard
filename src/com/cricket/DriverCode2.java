package com.cricket;

import com.dao.MatchDataOperations;
import com.dao.PlayerDataOperations;
import com.dao.TeamDataOperations;

public class DriverCode2 {

	public static void main(String[] args) {
		
		//testing db
		PlayerDataOperations.createPlayerTable();
		MatchDataOperations.createMatchTable();
		TeamDataOperations.createTeamTable();
		//CricketBoard2.addPlayer();
		//CricketBoard2.addTeam("Australia");
		//CricketBoard2.addTeam("Shreelanka");
		Menu.showMenu();
			}

}
