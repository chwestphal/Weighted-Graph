import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{	
	private String name;
	private int id;
	private ArrayList<Edge> neighbours;
	private Vertex previous;
	private int distance;
	
	
	public Vertex(String name, int id) {
		this.name = name;
		this.distance = Integer.MAX_VALUE;
		this.id = id;
		neighbours = new ArrayList<>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addNeighbour(Edge edge) {
		this.neighbours.add(edge);
	}
	
	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public ArrayList<Edge> getNeighbours() {
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
	
	public int getId() {
		return this.id;
	}
	
	public String neighboursToString(boolean weighted) {
		String edges = "";
		for(Edge e : neighbours) {
			Vertex temp = e.getTarget();
			edges += temp.getName() + "";
			if (weighted) {
				edges += "["+e.getWeight()+"]";
			}
			else {
				edges += ", ";
			}
		}
		return edges;
	}

	@Override
	public int compareTo(Vertex vertex) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
