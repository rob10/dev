package lab;



/*
 * Robert Gomez
 * Yovanny Feliz
 * Zawir Amin
 * 
 * 
 * 
 * 
 * 
 */

import java.util.Arrays;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		
		AMGraph graph = new AMGraph(7);
		
		graph.setLabel(0, "S0");
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 2);
		graph.addEdge(0, 5, 5);
		graph.addEdge(1, 5, 4);
		graph.addEdge(1, 4, 2);
		graph.addEdge(2, 4, 3);
		graph.addEdge(3, 2, 3);
		graph.addEdge(3, 6, 4);
		graph.addEdge(4, 6, 2);
		graph.addEdge(5, 6, 3);
		
		int [][]output = new int [7][7];
		
		int count = 0;
		while(count <= 6)
		{
			int cost [] = new int[7];
			
			for(int i = 0; i < cost.length; i++)
			{
				cost[i] = Integer.MAX_VALUE;
				
			}

			cost = recurse(graph, count, cost, 0);
			
			
			for(int i = 0; i<cost.length; i++)
			{
				if(cost[i]==Integer.MAX_VALUE)
				{
					cost[i]=0;
				}
				output[count][i] = cost[i];
			}
			
			count++;
			
		}
		
		System.out.println(Arrays.deepToString(output));
		
		
	}
	
	
	/*
	 * We used recursion to solve this. the vertix is passed in and all
	 * its neighbors are retrieved. It adds its cost to the cost that
	 * it took to get there(sum) and if it is lower than what it is in the
	 * integer array that holds all the costs then it replaces
	 * that cost. if current  is 6 then it reached the end of the graph 
	 * and it breaks out and returns an integer array which would be the row for the
	 * given vertex 
	 * 
	 */
	
	public int[] recurse(AMGraph graph, int current, int[] cost, int sum)
	{
		
		if(current==6)
		{
			return cost;
		}
		
		int[] neighbors = graph.neighborsCost(current);
		int next = 0;

		for(int i = 0; i<neighbors.length;i++)
		{
			if(neighbors[i]>0)
			{
				if((neighbors[i]+sum)<cost[i])
				{
					cost[i] = neighbors[i]+sum;
					
					//this is used to find which next node
					//to go to
					if(cost[next]>cost[i] || next==0)
					{
						next = i;
						
					}
														
				}
				
				
			}
			
		}
		//if we get here and next equals to 0
		//then that means we didn't find a shorther path
		//so we break out of the method and return the row
		if(next==0)
		{
			return cost;
		}
		
		return recurse(graph, next, cost, cost[next]);
		
	}
	
	
	}