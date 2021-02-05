package services;

import java.util.List;

import pojo.Player;
import pojo.Team;

public interface TeamBSI {
	public void createAndUpdateTeam(Team team);
	public Team getTeam(String teamName);
	public boolean remove(Team teamName);
	public int getTotalTeamCount();
	public void sortTeamByName();
	public void sortTeamByDate();
	boolean seachPlayer(String playerName, String teamName);
	public void addPlayer(Player player, String teamName);
    public int playerCount(String teamName) ;
    public void playMatch(String team1,String team2);
	
}
