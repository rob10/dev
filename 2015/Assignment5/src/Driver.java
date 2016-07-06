import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Driver {

	public static void main(String[] args) {
		
		
		Driver dr =  new Driver();
		dr.driverStart();
		

	}
	
	
	public void driverStart()
	{
		
		TimeZones est = new TimeZones("EST");
		TimeZones cst = new TimeZones("CST");
		TimeZones pst = new TimeZones("PST");
		
		ExecutorService executeService = Executors.newCachedThreadPool();
		
		executeService.execute(est);
		executeService.execute(cst);
		executeService.execute(pst);
	}

}
