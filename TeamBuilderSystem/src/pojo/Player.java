package pojo;

import java.util.Comparator;

public class Player {

	private long id;
	private String name;
	private Record record;
	private PlayerType playerType;

	public Player(String name) {
		super();
		this.name = name;
	}

	public Player(long id, String name, Record record, PlayerType playerType) {
		super();
		this.id = id;
		this.name = name;
		this.record = record;
		this.playerType = playerType;
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

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", record=" + record + ", playerType=" + playerType + "]";
	}



	public static Comparator<Player> PlayerComp = new Comparator<Player>() {

		public int compare(Player p1, Player p2) {

			String pName1 = p1.getName();
			String pName2 = p2.getName();

			// ascending order
			return pName1.compareTo(pName2);
		}
	};

}
