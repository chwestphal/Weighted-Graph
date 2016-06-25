
public interface WeightedGraph {
	
	void addVertex(String name);
	
	void addEdge(String start, String target, int weight);

	void printGraph();

	Vertex getVertex(String name);

	void distance(Vertex start);

	void printShortestPathTo(Vertex target);

}