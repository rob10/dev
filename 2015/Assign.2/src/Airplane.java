/*
 * Airplane class has 3 var. a time limit to be in queue, how long it has been in queue
 * and if it is landing plane or taking off plane
 * 
 */
public class Airplane {
	private boolean landing;
	private int age;
	private int timeInQueue;
	public boolean isLanding() {
		return landing;
	}
	public void setLanding(boolean landing) {
		this.landing = landing;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "<" + age +","+ timeInQueue + ">";
	}
	public int getTimeInQueue() {
		return timeInQueue;
	}
	public void setTimeInQueue(int timeInQueue) {
		this.timeInQueue = timeInQueue;
	}

}
