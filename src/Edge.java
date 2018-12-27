
public class Edge {
	private int weight;
	private Vertex target;
	
	public Edge(Vertex target, int weight) {
		this.weight = weight;
		this.target = target;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setTarget(Vertex target) {
		this.target = target;
	}

	public Vertex getTarget() {
		return this.target;
	}
}
