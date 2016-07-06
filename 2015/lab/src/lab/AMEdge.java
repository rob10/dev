package lab;

public class AMEdge {

	private int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String toString() {
		String rtn = "";
		rtn += "[cost = " + cost + "] ";
		return rtn;
	}
}
