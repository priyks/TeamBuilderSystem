package pojo;

public class Match {

	private int id;
	private Team team1;
	private Team team2;
	private Record recordTeam1;
	private Record recordTeam2;
	private MatchResult result;
	
	public Match(int id, Team team1, Team team2) {
		super();
		this.id = id;
		this.team1 = team1;
		this.team2 = team2;
	}
	
	public Match(int id, Record recordTeam1, Record recordTeam2) {
		super();
		this.id = id;
		this.recordTeam1 = recordTeam1;
		this.recordTeam2 = recordTeam2;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	public Record getRecordTeam1() {
		return recordTeam1;
	}
	public void setRecordTeam1(Record recordTeam1) {
		this.recordTeam1 = recordTeam1;
	}
	public Record getRecordTeam2() {
		return recordTeam2;
	}
	public void setRecordTeam2(Record recordTeam2) {
		this.recordTeam2 = recordTeam2;
	}
	public MatchResult getResult() {
		return result;
	}
	public void setResult(MatchResult result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Match [team1=" + team1 + ", team2=" + team2 + ", recordTeam1=" + recordTeam1 + ", recordTeam2="
				+ recordTeam2 + "]";
	}
	
	
	
}
