package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class TeamDB implements IDBConnections<Team> {

	Map<String, Team> teamCache = new HashMap<>();

	@Override
	public void saveAndUpdate(Team team) {

		if (team != null) {
			teamCache.put(team.getName(), team);
			System.out.println("Team is Added ...");
		}
	}

	@Override
	public Team get(String name) {
		// TODO Auto-generated method stub
		return teamCache.get(name);
	}

	@Override
	public boolean remove(Team t) {
		// TODO Auto-generated method stub
		return teamCache.remove(t.getName()) != null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		return teamCache.size();
	}

	@Override
	public boolean searchPlayer(String playerName, String teamName) {
		// TODO Auto-generated method stub
		boolean result = false;
		if (teamCache.containsKey(teamName)) {
			Team myTeam = teamCache.get(teamName);
			List<Player> myList = myTeam.getPlayerList();
			for (Player p : myList) {

				if (p.getName().equals(playerName)) {
					return result = true;
				}
			}
		}
		return result = false;

	}

	@Override
	public void sortPlayerList(String teamName) {
		// TODO Auto-generated method stub
		if (teamCache.containsKey(teamName)) {
			Team myTeam = teamCache.get(teamName);
			List<Player> playerList = myTeam.getPlayerList();
			Collections.sort(playerList, Player.PlayerComp);
			for (Player p : playerList) {
				System.out.println(p.getName());
			}

		}

	}

	@Override
	public void sortTeam() {
		if (teamCache != null) {
			Map<String, Team> sorted = new TreeMap<>(teamCache);
			Set<Entry<String, Team>> enteries = sorted.entrySet();
			System.out.println("List of Teams Sorted By Team Name");
			for (Entry<String, Team> mapping : enteries) {
				System.out.println(mapping.getKey() + "   " + mapping.getValue().getCreation());
			}

		} else {
			System.out.println("Team does not Exist..");
		}

	}

	@Override
	public void SortTeamCrationDate() {

		if (teamCache != null) {
			Set<Entry<String, Team>> entries = teamCache.entrySet();
			Comparator<Entry<String, Team>> DateComparator = new Comparator<Entry<String, Team>>() {

				@Override
				public int compare(Entry<String, Team> o1, Entry<String, Team> o2) {
					// TODO Auto-generated method stub
					Date date1 = o1.getValue().getCreation();
					Date date2 = o2.getValue().getCreation();
					return date1.compareTo(date2);
				}

			};

			List<Entry<String, Team>> listOfEntries = new ArrayList<Entry<String, Team>>(entries);
			Collections.sort(listOfEntries, DateComparator);
			LinkedHashMap<String, Team> sortedByDate = new LinkedHashMap<String, Team>(listOfEntries.size());
			for (Entry<String, Team> entry : listOfEntries) {
				sortedByDate.put(entry.getKey(), entry.getValue());
			}
			System.out.println("Sorted Team List by Creation Date :");
			Set<Entry<String, Team>> entrySetSortedByDate = sortedByDate.entrySet();
			for (Entry<String, Team> mapping : entrySetSortedByDate) {
				System.out.println(mapping.getKey() + " ---> " + mapping.getValue().getCreation());
			}

		} else {
			System.out.println("Team does not Exist..");
		}

	}

	@Override
	public void addPlayerToTeamPlayerList(Player player, String teamName) {
		// TODO Auto-generated method stub

		if (teamCache.containsKey(teamName)) {
			Team team = teamCache.get(teamName);
			team.playerList.add(player);
			System.out.println("Player is Added Successfully ...!");
		} else {

			System.out.println("Team Team does not Exist..");
		}

	}

	@Override
	public void removePlayer(String pName, String tName) {
		// TODO Auto-generated method stub
		if (teamCache.containsKey(tName)) {
			Team myTeam = teamCache.get(tName);
			myTeam.playerList.remove(pName);
			System.out.println("Player is Removed Successfully...!");

		} else {

			System.out.println("Team Team does not Exist..");
		}
	}

	@Override
	public int playerCount(String teamName) {
		// TODO Auto-generated method stub
		int count = 0;
		if (teamCache.containsKey(teamName)) {
			Team myTeam = teamCache.get(teamName);
			count = myTeam.playerList.size();
		}
		return count;
	}

	@Override
	public void playMatch(String team1, String team2, Match matchobj) {
		// TODO Auto-generated method stub
		Team myTeam1 = teamCache.get(team1);
		Team myTeam2 = teamCache.get(team2);
		int score1 = matchobj.getRecordTeam1().getRuns();
		int score2 = matchobj.getRecordTeam2().getRuns();
		if (myTeam1 != null && myTeam2 != null) {

			if (score1 == score2) {
				System.out.println("Match is Draw..");
			} else if (score1 >= score1) {
				System.out.println("Winner Team is " + myTeam1.getName());
			} else {
				System.out.println("Winner Team is" + myTeam2.getName());
			}

		}else {
			System.out.println("please enter valid two Teams..! ");
		}
	}

}
