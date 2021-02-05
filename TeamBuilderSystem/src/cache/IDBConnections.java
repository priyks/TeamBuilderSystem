package cache;

import java.util.List;

import pojo.Match;
import pojo.Player;

public interface IDBConnections<T> {

	public void saveAndUpdate(T t);
	public T get(String name);
	public boolean remove(T t);
	public int getCount();
	public boolean searchPlayer(String playerName, String teamName);
	public void sortPlayerList(String teamName);
	public void sortTeam();
	public void SortTeamCrationDate();
	public void addPlayerToTeamPlayerList(Player player, String teamName);
	public void removePlayer(String pName, String tName);
	public int playerCount(String teamName);
	public void playMatch(String team1, String team2, Match matchobj);
	

}
