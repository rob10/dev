
public class Graphs {

	/*
	 * AM GRAPH
	 * 
	 */
	
	//public class AMGraph implements MyGraph {

		private AMEdge[][] graph;
		private String[] label;

		public AMGraph(int size) {
			graph = new AMEdge[size][size];
			label = new String[size];
		}

		/* (non-Javadoc)
		 * @see MyGraph#addEdge(int, int, int)
		 */
		@Override
		public void addEdge(int source, int target, int cost) {
			graph[source][target] = new AMEdge();
			graph[source][target].setCost(cost);
		}

		/* (non-Javadoc)
		 * @see MyGraph#isEdge(int, int)
		 */
		@Override
		public boolean isEdge(int source, int target) {
			return (graph[source][target] != null);
		}

		/* (non-Javadoc)
		 * @see MyGraph#edgeCost(int, int)
		 */
		@Override
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
		@Override
		public void removeEdge(int source, int target) {

			// If you care about whether an edge exists before you delete it
			// You should probably do something here.


			graph[source][target] = null;
		}

		/* (non-Javadoc)
		 * @see MyGraph#getLabel(int)
		 */
		@Override
		public String getLabel(int vertex) {
			if ((vertex < 0) || (vertex >= label.length)) {
				return "Invalid Vertex";
			}
			return label[vertex];
		}

		/* (non-Javadoc)
		 * @see MyGraph#setLabel(int, java.lang.String)
		 */
		@Override
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
		@Override
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
		@Override
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
	
		
		//public class AMEdge {

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
		//}
			
	
			/* 
			 * EL Graph
			 * 
			 */
			
			
			//public class ELGraph implements MyGraph {

				private ELVertex[] graph; 
				
				public ELGraph(int size) {
					graph = new ELVertex[size];
					for (int i = 0; i < size; i++) {
						graph[i] = new ELVertex();
					}
				}

				@Override
				public void addEdge(int source, int target, int cost) {
					ELEdge edge = new ELEdge();
					edge.setVertex(target);
					edge.setCost(cost);
				
					edge.setNext(graph[source].getEdges());
					graph[source].setEdges(edge);
				}

				@Override
				public boolean isEdge(int source, int target) {
					ELEdge edge = graph[source].getEdges();
					
					while (edge != null) {
						if (edge.getVertex() == target) {
							return true;
						}
						edge = edge.getNext();
					}
					
					return false;
				}

				@Override
				public int edgeCost(int source, int target) {
					ELEdge edge = graph[source].getEdges();
					
					while (edge != null) {
						if (edge.getVertex() == target) {
							return edge.getCost();
						}
						edge = edge.getNext();
					}
					
					return Integer.MIN_VALUE;
				}

				@Override
				public void removeEdge(int source, int target) {
					// TODO Auto-generated method stub
					ELEdge cur = graph[source].getEdges();
					ELEdge prev = null;
					
					while (cur != null) {
						if (cur.getVertex() == target) {
							// Found it
							if (prev == null) {
								// First entry in list
								graph[source].setEdges(graph[source].getEdges().getNext());
								return;
							} else {
								// Second or later
								prev.setNext(cur.getNext());
								return;
							}
						}
						prev = cur;
						cur = cur.getNext();
					}
				}

				@Override
				public String getLabel(int vertex) {
					return graph[vertex].getLabel();
				}

				@Override
				public boolean setLabel(int vertex, String label) {
					graph[vertex].setLabel(label);
					
					//TODO:  Should this return a real value?
					return true;
				}

				@Override
				public boolean[] neighbors(int vertex) {
					boolean[] rtn = new boolean[graph.length];
					
					for (int i = 0; i < graph.length; i++) {
						rtn[i] = false;
					}
					
					ELEdge edge = graph[vertex].getEdges();
					
					while (edge != null) {
						rtn[edge.getVertex()] = true;
						edge = edge.getNext();
					}
					
					return rtn;
				}

				@Override
				public int[] neighborsCost(int vertex) {
					int[] rtn = new int[graph.length];
					
					for (int i = 0; i < graph.length; i++) {
						rtn[i] = Integer.MIN_VALUE;
					}
					
					ELEdge edge = graph[vertex].getEdges();
					
					while (edge != null) {
						rtn[edge.getVertex()] = edge.getCost();
						edge = edge.getNext();
					}
					
					return rtn;
				}
				
				public String toString() {
					String rtn = "";
					for (int i = 0; i < graph.length; i++) {
						rtn += "vertex[" + i + "] = " + graph[i];
						ELEdge edge = graph[i].getEdges();
						while (edge != null) {
							rtn += edge + " ";
							edge = edge.getNext();
						}
						rtn += "\n";
					}
					
					return rtn;
				}

			//}
				
				public class ELEdge {
					
					private int cost;
					
					// If we want an index of the vertex in the array
					private int vertex;
					private ELEdge next;
					
					

					@Override
					public String toString() {
						return "[vertex = " + vertex + ", cost = " + cost + "] ";
					}

					public ELEdge getNext() {
						return next;
					}

					public void setNext(ELEdge next) {
						this.next = next;
					}

					public int getCost() {
						return cost;
					}

					public void setCost(int cost) {
						this.cost = cost;
					}

					public int getVertex() {
						return vertex;
					}

					public void setVertex(int vertex) {
						this.vertex = vertex;
					}
					
					// If we want a reference to the vertex
					//private ELVertex vertex;
				}
				
				public class ELVertex {
					private String label;
					ELEdge edges;
					
					
					@Override
					public String toString() {
						return "[label=" + label + "] ";
					}
					public String getLabel() {
						return label;
					}
					public void setLabel(String label) {
						this.label = label;
					}
					public ELEdge getEdges() {
						return edges;
					}
					public void setEdges(ELEdge edges) {
						this.edges = edges;
					}

				}

/*
 * driver
 */
				
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
						graph.addEdge(0, 3, 0);
						
						graph.addEdge(0 0, 15);
								
						
						System.out.println(graph);
						graph.removeEdge(0, 3);
						System.out.println(graph);
						
						
						
					}
					
					

				}




}
