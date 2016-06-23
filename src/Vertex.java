
public class Vertex {	
	private String name;
	private Edge[] neighbours;
	private Vertex previous;
	private int distance;
	
	
	public Vertex(String name) {
		this.name = name;
		distance = 999999;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNeighbours(Edge[] edges) {
		this.neighbours = edges;
	}
	
	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public Edge[] getNeighbours() {
		return this.neighbours;
	}
	
	public Vertex getPrevious() {
		return this.previous;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDistance() {
		return this.distance;
	}
}
