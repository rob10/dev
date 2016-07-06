package lab;


public class AMGraph {

	private AMEdge[][] graph;
	private String[] label;

	public AMGraph(int size) {
		graph = new AMEdge[size][size];
		label = new String[size];
	}

	/* (non-Javadoc)
	 * @see MyGraph#addEdge(int, int, int)
	 */
	//@Override
	public void addEdge(int source, int target, int cost) {
		graph[source][target] = new AMEdge();
		graph[source][target].setCost(cost);
	}

	/* (non-Javadoc)
	 * @see MyGraph#isEdge(int, int)
	 */
	//@Override
	public boolean isEdge(int source, int target) {
		return (graph[source][target] != null);
	}

	/* (non-Javadoc)
	 * @see MyGraph#edgeCost(int, int)
	 */
	//@Override
	public int edgeCost(int source, int target) {
		if (!isEdge(source, target) ) {
			return Integer.MIN_VALUE;
		} else {
			return graph[source][target].getCost();
		}
	}

	/* (non-Javadoc)
	 * @see MyGraph#removeEdge(int, int)
	 */
	//@Override
	public void removeEdge(int source, int target) {

		// If you care about whether an edge exists before you delete it
		// You should probably do something here.


		graph[source][target] = null;
	}

	/* (non-Javadoc)
	 * @see MyGraph#getLabel(int)
	 */
	//@Override
	public String getLabel(int vertex) {
		if ((vertex < 0) || (vertex >= label.length)) {
			return "Invalid Vertex";
		}
		return label[vertex];
	}

	/* (non-Javadoc)
	 * @see MyGraph#setLabel(int, java.lang.String)
	 */
	//@Override
	public boolean setLabel(int vertex, String label) {
		if ((vertex < 0) || (vertex >= this.label.length)) {
			return false;
		}
		
		this.label[vertex] = label;
		return true;
	}

	/* (non-Javadoc)
	 * @see MyGraph#neighbors(int)
	 */
	//@Override
	public boolean[] neighbors(int vertex) {
		boolean[] rtn = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (graph[vertex][i] != null) {
				rtn[i] = true;
			} else {
				rtn[i] = false;
			}
		}

		return rtn;
	}

	/* (non-Javadoc)
	 * @see MyGraph#neighborsCost(int)
	 */
	//@Override
	public int[] neighborsCost(int vertex) {
		int[] rtn = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			rtn[i] = edgeCost(vertex, i);
		}

		return rtn;
	}


	public String toString() {
		String rtn = "";

		rtn += "         \t";  // for alignment
		for (int i = 0; i < label.length; i++) {
			rtn += i + "\t";
		}
		rtn += "\n";
		
		for (int i = 0; i < label.length; i++) {
			rtn += "Vertex " + i + ":\t";
			for (int j = 0; j < label.length; j++) {
				if (graph[i][j] != null) {
					rtn += edgeCost(i, j) + "\t";
				} else {
					rtn += "none\t";
				}
			}
			rtn += "\n";
		}
		
		return rtn;
	}
}
