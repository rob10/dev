import java.util.Random;

public class Runway {
	
	//declare variables shared through out the class
	private final int SIMULATION_TIME = 600;
	private int crashed;
	private double totalLanding;
	private double totalTakeoff;
	private double totalLandQueue;
	private double totalTakeoffQueue;
	
	public void startProg()
	{
		
		//declare variables
		int clock = 0;
		int runwayTime = 0;
		Random rand = new Random();
		Queue landing = new Queue();
		Queue takingoff = new Queue();
		int landed = 0;
		int tookOff = 0;
		
		//while loops that runs however much much "minutes" are in simulation time
		//each time it loops its like a minute passed
		while(clock < SIMULATION_TIME)
		{
						
            //new landing plane probability  
			int newLand = rand.nextInt(2)+1;
			//if it equals to 2 then add a new plane to landing queue
			if(newLand == 2)
			{
				
				Airplane ap = new Airplane();
				ap.setAge(3);
				ap.setLanding(true);
				ap.setTimeInQueue(0);
				
				landing.add(ap);
				totalLanding++;
				
			}
			
			
			//new take off plane probability
			int newTakeoff = rand.nextInt(1)+1;
			
			//if equals to 1 then add new plane to take off queue
			if(newTakeoff == 1)
			{
				
				Airplane ap = new Airplane();
				ap.setAge(3);
				ap.setLanding(false);
				ap.setTimeInQueue(0);
				
				takingoff.add(ap);
				totalTakeoff++;
				
			}
			
			//if the queue for landing is not empty and the runway is not being used then 
			//remove the plane off the queue, set the runway time to 3(how long it takes to land)
			//get how long plane was in queue and increment how many planes landed
			 if(!landing.isEmpty() && runwayTime == 0)
			{
				
				Airplane temp = landing.remove();
				totalLandQueue += temp.getTimeInQueue();
				runwayTime = 3;
				
				landed++;
			}
			//same steps as above but with runway time being 4 since that's
			//how long it takes to take off
			else if(!takingoff.isEmpty() && runwayTime == 0){
								
				Airplane temp = takingoff.remove();
				totalTakeoffQueue += temp.getTimeInQueue();
				runwayTime = 4;
				tookOff++;
				
			}		
			
			//call methods to update values for planes and remove any planes that exceeded time limit in queue
			updateVals(landing);
			updateVals(takingoff);
			
			//increment clock cause minute has passed
			clock++;
			//decrement runway time cause minute has passed 
			runwayTime--;
			
			
		}
				
		//get averages of how long planes were in queue
		double avg1 =  totalLandQueue/totalLanding;
		double avg2 = totalTakeoffQueue/totalTakeoff;
		
		//display output
		System.out.printf("landed: %d took off: %d crashed: %d \n", landed, tookOff, crashed);
		System.out.printf("Average Time in landing queue: %f \n", avg1);
		System.out.printf("Average time in takeoff queue: %f \n", avg2);
		
	}
	
	
	private void updateVals(Queue q)
	{
		//set the iterator to head
		q.resetIterator();
		
		
		while(q.hasNext())
		{
			//temp node
			Node n = q.next();
			
			//if the age is 0 then it means it ran out of time and needs to be removed off queue
			if(n.getData().getAge() == 0)
			{
				//if value is true then it means it is a landing plane and crashed
				//else then it is a take off plane and just needs to be taken off queue
				if(n.getData().isLanding())
				{
					crashed++;
					Airplane temp = q.remove();
					totalLandQueue += temp.getTimeInQueue();
					
				}
				else{
					Airplane temp = q.remove();
					totalTakeoffQueue += temp.getTimeInQueue();
					
				}
				
				
			}
			//if age is not 0 then decrement age and increment how long the plane has been in queue
			else{
				n.getData().setAge(n.getData().getAge()-1);
				n.getData().setTimeInQueue(n.getData().getTimeInQueue()+1);
				
			}
			
		}
		
		}

}
