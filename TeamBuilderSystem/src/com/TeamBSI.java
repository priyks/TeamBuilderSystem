package com;

import java.util.List;

public interface TeamBSI {
	public void createAndUpdateTeam(Team team);
	public Team getTeam(String teamName);
	public boolean remove(Team teamName);
	public int getTotalTeamCount();
	public void sortTeamByName();
	public void sortTeamByDate();
	boolean seachPlayer(String playerName, String teamName);
	void addPlayer(Player player, String teamName);
    public int playerCount(String teamName) ;
    public void playMatch(String team1,String team2);
	
}
