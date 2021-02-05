package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import pojo.Team;
import services.TeamBuilder;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		TeamBuilder teamBuilder = new TeamBuilder();

		/*teamBuilder.createTeam("xyz", new Date());
		teamBuilder.createTeam("abc", new Date());
		System.out.println(teamBuilder.getTeam("xyz"));
		System.out.println(teamBuilder.getTeam("abc"));
		Team team1 = teamBuilder.getTeam("xyz");
		Team team2 = teamBuilder.getTeam("abc");

		System.out.println("team 1:");

		System.out.println(team1.playerList.add(new Player(new Random().nextInt(), "joy smith",
				new Record(new Random().nextInt(), 34, 56), PlayerType.BATSMEN)));
		System.out.println(team1.playerList.add(new Player(new Random().nextInt(), "kin herry",
				new Record(new Random().nextInt(), 340, 6), PlayerType.BOWLLER)));
		System.out.println(team1.playerList.add(new Player(new Random().nextInt(), "rahul dev",
				new Record(new Random().nextInt(), 240, 4), PlayerType.WIKEETKEEPER)));
		System.out.println(team1.playerList.add(new Player(new Random().nextInt(), "Ashwin",
				new Record(new Random().nextInt(), 340, 6), PlayerType.BOWLLER)));
		System.out.println(team1.getPlayerList());

		System.out.println("team 2:");

		System.out.println(team2.playerList.addAll(Arrays.asList(new Player("John"), new Player("Sam"),
				new Player("Will"), new Player("Dan"), new Player("Joe"))));

		System.out.println(team2.getPlayerList());
		System.out.println("total teams in system :" + teamBuilder.getTeamCount());
		// sort team
		System.out.println("All Sorted Teams In System by Name  ");
		teamBuilder.sortTeamExistInSystem();
		// search player
		// System.out.println("player present in team 1: " +
		// teamBuilder.SearchPlayerByName("joy smith", team1));
		// System.out.println("player present in team 2: " +
		// teamBuilder.SearchPlayerByName("kapil dev", team2));
		// sort player list
		System.out.println("Team 2 sorted list : ");
		/*
		 * List<Player> playerList = teamBuilder.sortPlayerList("xyz"); for (Player p :
		 * playerList) { System.out.println(p); }
		 */
		/*teamBuilder.createTeam("temp", new Date());
		// sorted team List by creation Date
		teamBuilder.sortTeamByDate(); */

		System.out.println("*******************Team Builder System ********************");
		int e = 0;
		do {
			System.out.println("Press 1 to Create Team : ");
			System.out.println("Press 2 to Add Player In Team : ");
			System.out.println("Press 3 to Show Total Teams In System : ");
			System.out.println("Press 4 to Show Sorted Team By Team Name : ");
			System.out.println("Press 5 to Show Sorted Team By Team Date Creation : ");
			System.out.println("Press 6 to Show Players list Team Wise : ");
			System.out.println("Press 7 to Search Player :");
			System.out.println("Press 8 to Seach Team : ");
			System.out.println("Press 9 to get Player Count team Wise :");
			System.out.println("Press 10 to play match : ");
			System.out.println("Press 11 to Exit : ");
			int choiceTeam = Integer.parseInt(br.readLine());

			switch (choiceTeam) {

			case 1:
				System.out.println("Enter Team Name :");
				String TeamName = br.readLine();
				teamBuilder.createTeam(TeamName, new Date());
				break;
			case 2:
				System.out.println("Enter Player Name");
				String playerName = br.readLine();
				System.out.println("Enter Team Name");
				String teamName = br.readLine();
				teamBuilder.addPlayerToTeam(playerName, teamName);
				break;
			case 3:
				System.out.println("total teams in system :" + teamBuilder.getTeamCount());
				break;
			case 4:
				System.out.println("All Sorted Teams In System by Name");
				teamBuilder.sortTeamExistInSystem();
				break;
			case 5:
				System.out.println("All Sorted Teams In System by Creation Date");
				teamBuilder.sortTeamByDate();
				break;
			case 6:
				System.out.println("Enter Team Name");
				String teamName1 = br.readLine();
				System.out.println("Player List In Sorted Order ");
				teamBuilder.sortPlayerList(teamName1);
				break;
			case 7:
				System.out.println("Enter Player Name");
				String playerName1 = br.readLine();
				System.out.println("Enter Team Name");
				String name = br.readLine();
				boolean result = teamBuilder.searchPlayerByName(playerName1, name);
				System.out.println("Result of Search : " + result);
				break;
			case 8:
				System.out.println("Enter Team Name");
				String myTeamName1 = br.readLine();;
				Team searchTeam=teamBuilder.getTeam(myTeamName1);
				System.out.println("Search Result :"+searchTeam.getName()+" is Present ");
				break;
			case 9:
				System.out.println("Enter Team Name");
				String myTeamName = br.readLine();
				int i=teamBuilder.getPlayerCount(myTeamName);
				System.out.println("Total Players in " + myTeamName + " : " + i);
				break;
			case 10	:
				 System.out.println("Enter Team1 Name : ");
				 String matchTeam1=br.readLine();
				 System.out.println("Enter Team2 Name : ");
				 String matchTeam2=br.readLine();
				 teamBuilder.playeMatch(matchTeam1, matchTeam2);
				 break;
			case 11:
				e = 11;
				break;
			}
		} while (e != 11);
	}

}
