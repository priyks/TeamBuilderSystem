package cache;

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
import java.util.stream.Collectors;

import pojo.Record;
import pojo.Match;
import pojo.Player;
import pojo.Team;

public class TeamDB implements IDBConnections<Team> {

	Map<String, Team> teamCache = new HashMap<>();

	/**
	 * this method will save passed team in teamCache
	 */
	@Override
	public void saveAndUpdate(Team team) {

		if (team != null) {
			teamCache.put(team.getName(), team);
			System.out.println("Team is Added ...");
		}
	}

	/**
	 * this method will return a team
	 */
	@Override
	public Team get(String name) {

		return teamCache.get(name);
	}

	/**
	 * this method will remove passed Team from teamCache map
	 */
	@Override
	public boolean remove(Team t) {

		return teamCache.remove(t.getName()) != null;
	}

	/**
	 * this method will return number of team present in system
	 */
	@Override
	public int getCount() {

		return teamCache.size();
	}

	/**
	 * this method will return true if it founds given player name in list
	 */
	@Override
	public boolean searchPlayer(String playerName, String teamName) {

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

	/**
	 * this method accepts team name and sorts player List by their names
	 */

	@Override
	public void sortPlayerList(String teamName) {

		/*
		 * if (teamCache.containsKey(teamName)) { Team myTeam = teamCache.get(teamName);
		 * List<Player> playerList = myTeam.getPlayerList();
		 * Collections.sort(playerList, Player.PlayerComp); for (Player p : playerList)
		 * { System.out.println(p.getName()); }
		 * 
		 * }
		 */

		Team myTeam = teamCache.get(teamName);
		if (myTeam != null) {
			List<Player> players = myTeam.getPlayerList();
			players.sort(Comparator.comparing(Player::getName));
			players.stream().forEach(player -> System.out.println(player));
		}

	}

	/**
	 * this method displays sorted team by their names which is sorted by keys which
	 * are stored in teamCache
	 */
	@Override
	public void sortTeam() {
		/*
		 * if (teamCache != null) { // old logic Map<String, Team> sorted = new
		 * TreeMap<>(teamCache); Set<Entry<String, Team>> enteries = sorted.entrySet();
		 * System.out.println("List of Teams Sorted By Team Name"); for (Entry<String,
		 * Team> mapping : enteries) { System.out.println(mapping.getKey() + "   " +
		 * mapping.getValue().getCreation()); }
		 * 
		 * } else { System.out.println("Team does not Exist.."); }
		 */

		if (teamCache != null) { // it will sort by teams by their names
			teamCache.entrySet().stream().sorted(Map.Entry.<String, Team>comparingByKey()).forEach(System.out::println);
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
				sortedByDate.put(entry.getKey(), entry.getValue()); // it puts sorted date in linkedHashMap object
			}
			System.out.println("Sorted Team List by Creation Date :");
			Set<Entry<String, Team>> entrySetSortedByDate = sortedByDate.entrySet();

			/*
			 * for (Entry<String, Team> mapping : entrySetSortedByDate) {
			 * System.out.println(mapping.getKey() + " ---> " +
			 * mapping.getValue().getCreation());
			 * 
			 * }
			 */

			sortedByDate.entrySet().stream().forEach((e -> System.out.println(e.getKey() + ":" + e.getValue())));

		} else {
			System.out.println("Team does not Exist..");
		}

	}

	@Override
	public void addPlayerToTeamPlayerList(Player player, String teamName) {

		if (teamCache.containsKey(teamName)) {
			Team team = teamCache.get(teamName);
			List<Player> myPlayer = new ArrayList<>(team.getPlayerList());
			myPlayer.add(player);
			team.setPlayerList(myPlayer);
			// team.playerList.add(player);
			System.out.println("Player is Added Successfully ...!");
		} else {

			System.out.println("Team Team does not Exist..");
		}

	}

	@Override
	public void removePlayer(String pName, String tName) {

		if (teamCache.containsKey(tName)) {
			Team myTeam = teamCache.get(tName);
			List<Player> myPlayer = new ArrayList<>(myTeam.getPlayerList());
			myPlayer.remove(pName);
			myTeam.setPlayerList(myPlayer.stream().distinct().collect(Collectors.toList())); // it store only distinct
																								// player in list
			System.out.println("Player is Removed Successfully...!");

		} else {

			System.out.println("Team Team does not Exist..");
		}
	}

	/**
	 * this methods returns total number of players in team.
	 */
	@Override
	public int playerCount(String teamName) { // this will return count of players in team

		int count = 0;
		if (teamCache.containsKey(teamName)) {
			Team myTeam = teamCache.get(teamName);
			count = myTeam.getPlayerList().size();
		}
		return count;
	}

	/**
	 * this method accepts two team and match and displays match result according
	 * their record.
	 */
	@Override
	public void playMatch(String team1, String team2, Match matchobj) {

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

		} else {
			System.out.println("please enter valid two Teams..! ");
		}
	}

}
