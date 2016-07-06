
public class shortestpathandrecursion {
	
	public void shortestPath(int vertex) {
		// Using Dijkstra's shortest path algorithm generate the shortest path from
		// the given vertex
		
		// Initialize the paths
		AMEdge []paths = new AMEdge[graph.length];
		for (int i = 0; i < paths.length; i++) {
			paths[i] = new AMEdge();
			paths[i].setCost(AMEdge.INFINITY);
			paths[i].setVisited(false);
		}
		
		// Initialize the current entry
		int current = vertex;
		paths[current].setCost(0);
		
		// Loop through until done updating the paths
		boolean done = false;
		while(!done) {
			// For each immediate neighbor calculate the cost
			for (int i = 0; i < paths.length; i++) {
				if (this.isEdge(current, i)) {
					// I have an edge, update the cost
					// If the cost to get to current plus the cost to the next vertex is better than
					// What I have update it
					if ((edgeCost(current, i) + paths[current].getCost()) < paths[i].getCost()) {
						paths[i].setCost(edgeCost(current, i) + paths[current].getCost());
					}
 				}
			}
			
			// Set the current node to visited
			paths[current].setVisited(true);
			
			// Find the next node (least expensive)
			int nextCost = AMEdge.INFINITY;
			int nextIndex = -1;
			for (int i = 0; i < paths.length; i++) {
				if (!paths[i].isVisited()) {
					// If this is better and unvisited, adopt it
					if (paths[i].getCost() < nextCost) {
						nextIndex = i;
						nextCost = paths[i].getCost();
					}
				}
			}
			
			if (nextIndex == -1) {
				// There are no more viable paths
				done = true;
			} else {
				// Keep moving forward
				current = nextIndex;
			}
		}
		
		for (int i = 0; i < paths.length; i++) {
			if (paths[i].getCost() == AMEdge.INFINITY) {
				System.out.print("Inf." + " ");
			} else {
				System.out.print(paths[i].getCost() + "    ");
			}
		}
		System.out.println();
		
	}
	
	
	

public class Driver {

	AMGraph graph;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	public void addEdges() {
		
		// V0
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 2);
		graph.addEdge(0, 5, 5);

		// V1
		graph.addEdge(1, 4, 2);
		graph.addEdge(1, 5, 4);
		
		// V2
		graph.addEdge(2, 4, 3);
		
		// V3
		graph.addEdge(3, 2, 3);
		graph.addEdge(3, 6, 4);
		
		// V4
		graph.addEdge(4, 6, 2);
		
		// V5
		graph.addEdge(5, 6, 3);
		
		// V6
		// 6 has no outward connections
	}
	
	public void doIt() {
		graph = new AMGraph(7);
		
		addEdges();
		
		System.out.println(graph);
		for (int i = 0; i < graph.getVertexCount(); i++) {
			graph.shortestPath(i);
		}
	}

}
/*
 * 
 * Recursion
 * 
*/

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		
		try {
			System.out.println(recFact(10));
		} catch (StackOverflowError e) {
			// TODO Auto-generated catch block
			System.out.println("Stack Overflow");
		}
		System.out.println(itFact(10));
		//funWithOr();
		System.out.println(this.fibonacciRecusion(9));
		//hanoi(5, 1, 2, 3);
		nums( 1, 10, 1);
	}
	
	
	public void nums(int start, int end, int num) {
		if (num > end) {
			return;
		}
		
		System.out.print(" " + num);
		nums(start, end, num+1);
		System.out.print(" " + num);
	}
	
	public long recFact(int num) throws StackOverflowError {
		if ((num == 1) || (num == 0))
			return 1;
		
		return num * recFact(num-1);
	}
	
	public long itFact(int num) {
		
		if ((num == 1) || (num == 0))
			return 1;
		
		int sum = 1;
		for (int i = num; i > 0; i--) {
			sum *= i;
		}
		return sum;
	}
	
	  // Java program for Fibonacci number using recursion.
    public int fibonacciRecusion(int number){
        if(number == 1 || number == 2){
            return 1;
        }
 
        return fibonacciRecusion(number-1) + fibonacciRecusion(number -2); //tail recursion
    }
 
    public static void hanoi(int n, int startPole, int intermediatePole, int endPole) {
        if (n== 0){
          return; 
        }
        hanoi(n-1, startPole, endPole, intermediatePole);
        System.out.println("Move " +n + " from " + startPole + " to " +endPole);
        hanoi(n-1, intermediatePole, startPole, endPole);
      }

	
	public void funWithOr() {
		
		int num = 6;
		int a = 3;
		if (( num == 6) | (a++ == 5)) {
			num++;
		}
		System.out.println("num = " + num + ", a = " + a);
	}
 
}


}
