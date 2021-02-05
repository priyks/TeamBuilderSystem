package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import cache.TeamDB;
import pojo.Player;
import pojo.PlayerType;
import pojo.Record;
import pojo.Team;

public class TeamBuilder {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	TeamService teamsService = new TeamService(new TeamDB());
	int count = 0;
	PlayerType category = PlayerType.BATSMEN;

	public void createTeam(String name, Date creationDate) {

		teamsService.createAndUpdateTeam(new Team(new Random().nextInt(), name, creationDate));
	}

	public Team getTeam(String teamName) {
		return teamsService.getTeam(teamName);
	}

	public int getTeamCount() {

		return teamsService.getTotalTeamCount();
	}

	public void sortPlayerList(String teamName) {

		teamsService.sortPlayerList(teamName);

	}

	public void sortTeamExistInSystem() {

		teamsService.sortTeamByName();
	}

	public void sortTeamByDate() {

		teamsService.sortTeamByDate();

	}
	public void addPlayerToTeam(String playerName, String teamName) throws NumberFormatException, IOException {
		System.out.println("Enter Player Runs :");
		int runs = Integer.parseInt(br.readLine());
		System.out.println("Enter Player Wickets he have Taken :");
		int wickets = Integer.parseInt(br.readLine());
		System.out.println("Press 1 for Batsmen :");
		System.out.println("Press 2 for Bowller : ");
		System.out.println("press 3 for Wikcetkeeper :");
		int categoryChoice = Integer.parseInt(br.readLine());
		switch (categoryChoice) {
		case 1:
			category = PlayerType.BATSMEN;
			break;
		case 2:
			category = PlayerType.BOWLLER;
			break;
		case 3:
			category = PlayerType.WICKETKEEPER;
			break;
		}
		int id = new Random().nextInt();
		Record record = new Record(id, runs, wickets);
		teamsService.addPlayer(new Player(id, playerName, record, category), teamName);
	}

	public boolean searchPlayerByName(String playerName1, String name) {
		// TODO Auto-generated method stub
		return teamsService.seachPlayer(playerName1, name);
	}

	public void removePlayer(String pName, String tName) {
		// TODO Auto-generated method stub
		teamsService.removePlayerFromTeam(pName, tName);

	}

	public int getPlayerCount(String myTeamName) {
		// TODO Auto-generated method stub
		return teamsService.playerCount(myTeamName);

	}
	
	public void playeMatch(String team1,String team2) {
		
		 teamsService.playMatch(team1, team2);
	}
}
