import java.util.*;

public class RandomGraph implements WeightedGraph {
	private PriorityQueue<Vertex> queue;
	private ArrayList<Vertex> vertices;
	private ArrayList<Vertex> verticesToConnect;
	private ArrayList<String> vertexContent;
	private boolean weighted;
	
	public RandomGraph(int vertices, int edges) {
		this.vertices = new ArrayList<>();
		verticesToConnect = new ArrayList<>();
		vertexContent = new ArrayList<>();
		weightedGraph(vertices,edges);
	}

	public void unweightedGraph(int vertices, int edges) {
		weighted = false;
		createGraph(vertices, edges);
	}

	public void weightedGraph(int vertices, int edges) {
		weighted = true;
		createGraph(vertices, edges);
	}
	
	public void addVertex(String name) {
		Vertex vertex = new Vertex(name);
		vertices.add(vertex);
	}
	
	public void addEdge(String start, String target, int weight) {
		Vertex vStart = this.getVertex(start);
		Vertex vTarget = this.getVertex(target);
		vStart.addNeighbour(new Edge(vTarget, weight));
	}

	private void createGraph(int vertices, int edges) {
		createGraphContent();
		createVertices(vertices);
		createRandomEdges();
	}

	private void createGraphContent() {

		for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
			vertexContent.add("" + alphabet);
		}
	}

	private void createVertices(int vertices) {
		for (int i = 0; i < vertices; i++) {
			Vertex vertex = new Vertex(vertexContent.get(i));
			this.vertices.add(vertex);
			verticesToConnect.add(vertex);
			verticesToConnect.add(vertex);
		}
	}

	private void createRandomEdges() {
		Random rndm = new Random();
		int weight1 = 1;
		int weight2 = 1;
		Vertex temp1 = null;
		Vertex temp2 = null;
		for (Vertex v : this.vertices) {
			
			if (weighted) {
				weight1 = rndm.nextInt(99) + 1;
				weight2 = rndm.nextInt(99) + 1;
			}

			Vertex randVert1 = null;
			Vertex randVert2 = null;
			do {
				randVert1 = this.verticesToConnect.get(rndm.nextInt(verticesToConnect.size()));
				randVert2 = this.verticesToConnect.get(rndm.nextInt(verticesToConnect.size()));
			} while (v.compareTo(randVert1) == 1 || v.compareTo(randVert2) == 1
					|| randVert1.compareTo(randVert2) == 1);

			v.addNeighbour(new Edge(randVert1, weight1));
			v.addNeighbour(new Edge(randVert2, weight2));

			if(temp1 != null || temp2 != null) {
				this.verticesToConnect.remove(temp1);
				this.verticesToConnect.remove(temp2);
			}
			temp1 = randVert1;
			temp2 = randVert2;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see WeightedGraph01#printGraph()
	 */
	@Override
	public void printGraph() {
		for (Vertex v : vertices) {
			System.out.println(v.getName() + ": " + v.neighboursToString(weighted));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see WeightedGraph01#getElement(java.lang.String)
	 */
	@Override
	public Vertex getVertex(String name) {
		String s = name.toUpperCase();
		for (int i=0; i<vertices.size();i++) {
			Vertex v = vertices.get(i);
			if (v.getName().equals(s)) {
				return v;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see WeightedGraph01#distance(Vertex)
	 */
	@Override
	public void distance(Vertex start) {
		queue = new PriorityQueue<Vertex>();
		start.setDistance(0);
		queue.add(start);

		while (!queue.isEmpty()) {
			Vertex curr = queue.poll();

			for (Edge e : curr.getNeighbours()) {
				Vertex next = e.getTarget();

				int currDistance = curr.getDistance() + e.getWeight();

				if (currDistance < next.getDistance()) {
					queue.remove(curr);
					next.setDistance(currDistance);
					next.setPrevious(curr);
					queue.add(next);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see WeightedGraph01#printShortestPathTo(Vertex)
	 */
	@Override
	public void printShortestPathTo(Vertex target) {
		ArrayList<String> vertices = new ArrayList<>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.getPrevious()) {
			vertices.add(vertex.getName());
		}
		Collections.reverse(vertices);
		
		System.out.println(vertices + " -> " + target.getDistance());

	}

	public static void main(String args[]) {
		RandomGraph wg = new RandomGraph(10, 20);
		wg.printGraph();
		wg.distance(wg.getVertex("F"));
		wg.printShortestPathTo(wg.getVertex("D"));
	}
}