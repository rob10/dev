
public class Driver {

	public static void main(String[] args) {
		
		//get out of static 
		Driver me = new Driver();
		
		me.startProg();

	}
	
	public void startProg()
	{
		//create cache object
		Cache cache = new Cache();
		//start cache program
		cache.Driver();
	}
	

}
