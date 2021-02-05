package pojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Team  {
	private long id;
	private String name;
	private Date creation;
	private List<Player> playerList=new ArrayList<>();
	
	public Team(long id, String name, Date creation) {
		super();
		this.id = id;
		this.name = name;
		this.creation = creation;
	}
	public List<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	
	@Override
	public String toString() {
		return "Team [name=" + name + ", creation=" + creation + "]";
	}
	
	
	
	
		
}
