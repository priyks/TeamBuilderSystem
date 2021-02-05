package pojo;

public class Record {
   
	private long id;
    private int runs;
    private int wickets;
    
    
    
	public Record(long id, int runs, int wickets) {
		super();
		this.id = id;
		this.runs = runs;
		this.wickets = wickets;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
    
	 @Override
		public String toString() {
			return "Record runs=" + runs + ", wickets=" + wickets + "";
		}
    
}
