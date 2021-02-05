package services;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import cache.IDBConnections;
import pojo.Match;
import pojo.Player;
import pojo.Record;
import pojo.Team;

public class TeamService implements TeamBSI {

	IDBConnections<Team> connection;

	public TeamService(IDBConnections<Team> connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
	}

	@Override
	public void createAndUpdateTeam(Team tname) {
		// TODO Auto-generated method stub

		connection.saveAndUpdate(tname);
	}

	@Override
	public Team getTeam(String teamName) {
		// TODO Auto-generated method stub
		return connection.get(teamName);
	}

	@Override
	public boolean remove(Team teamName) {
		// TODO Auto-generated method stub
		return connection.remove(teamName);
	}

	@Override
	public int getTotalTeamCount() {
		// TODO Auto-generated method stub

		return connection.getCount();
	}

	@Override
	public boolean seachPlayer(String playerName, String teamName) {
		// TODO Auto-generated method stub

		return connection.searchPlayer(playerName, teamName);
	}

	public void sortPlayerList(String teamName) {
		// TODO Auto-generated method stub

		connection.sortPlayerList(teamName);

	}

	@Override
	public void sortTeamByName() {
		
		connection.sortTeam();
		
	}

	@Override
	public void sortTeamByDate() {
		
		connection.SortTeamCrationDate();
		
	}
	@Override
	public void addPlayer(Player player, String teamName) {
	
		connection.addPlayerToTeamPlayerList(player,teamName);
	}

	public void removePlayerFromTeam(String pName, String tName) {
		// TODO Auto-generated method stub
		connection.removePlayer(pName,tName);
		
	}

	@Override
	public int playerCount(String teamName) {
		// TODO Auto-generated method stub
		return connection.playerCount(teamName);
	}

	@Override
	public void playMatch(String team1, String team2) {
		Match matchobj=new Match(new Random().nextInt(),new Record(new Random().nextInt(), 343, 5),new Record(new Random().nextInt(), 241, 6));
		
		 connection.playMatch(team1, team2,  matchobj);
		
	}

	


	
}
