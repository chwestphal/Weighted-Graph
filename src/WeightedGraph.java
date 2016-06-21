public class WeightedGraph {
	private int [][] graph;
	
	public void weightedGraph ( int nodes){
		
	graph = new int[nodes][nodes];	
	for(int y = 0; y < nodes; y++) {
		for(int x = 0; x < nodes; x++) {
		connectNodes(x, y, 0);
		}
	}
}
   public void addEdge(int i, int j) {
        graph[i][j] = 1;
    }
   public void removeEdge(int i, int j) {
        graph[i][j] = 0;
    }
   public int hasEdge(int i, int j) {
        return graph[i][j];
    }
   
   private void connectNodes(int x, int y, int i) {
	   if(x == y) {
			connectNodes(x, y, 1);
		} else {
			connectNodes(x, y, 0);
		}
			
	}

}