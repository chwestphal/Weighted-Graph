import java.util.*;

public class WeightedGraph {
		private PriorityQueue<Vertex> queue;
		
		public WeightedGraph() {
			queue = new PriorityQueue<Vertex>();
		}
		
		public void createUnweightedGraph(int vertices, int edges) {
			Vertex A = new Vertex("A");
			Vertex B = new Vertex("B");
			Vertex C = new Vertex("C");
			Vertex D = new Vertex("D");
			Vertex E = new Vertex("E");
			Vertex F = new Vertex("F");
			Vertex G = new Vertex("G");
			
			A.setNeighbours(new Edge[]{new Edge(B, 10), new Edge(G, 3)});
			B.setNeighbours(new Edge[]{new Edge(C, 10), new Edge(A, 3)});
			C.setNeighbours(new Edge[]{new Edge(F, 10), new Edge(F, 3)});
			D.setNeighbours(new Edge[]{new Edge(A, 10), new Edge(G, 3)});
			E.setNeighbours(new Edge[]{new Edge(G, 10), new Edge(D, 3)});
			F.setNeighbours(new Edge[]{new Edge(D, 10), new Edge(A, 3)});
			G.setNeighbours(new Edge[]{new Edge(F, 10), new Edge(C, 3)});
		}
		
		public void distance(Vertex start) {
			start.setDistance(0);
			queue.add(start);
			
			while(!queue.isEmpty()) {
				Vertex curr = queue.poll();
				
				for(Edge e : curr.getNeighbours()) {
					Vertex next = e.getTarget();
					
					int currDistance = curr.getDistance() + e.getWeight();
					
					if(currDistance<next.getDistance()) {
						queue.remove(curr);
						next.setDistance(currDistance);
						next.setPrevious(curr);
						queue.add(next);
					}
				}
			}
		}
		
		public ArrayList<String> shortestPathTo(Vertex target) {
			ArrayList<String> vertices = new ArrayList<>();
			for(Vertex vertex = target; vertex != null; vertex = vertex.getPrevious()) {
				vertices.add(vertex.getName());
			}
			Collections.reverse(vertices);
			return vertices;
		}
	}