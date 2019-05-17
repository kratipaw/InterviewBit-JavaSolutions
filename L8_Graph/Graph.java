import java.util.LinkedList;

public class Graph {

	int V;
	
	LinkedList<Integer> adjList[];
	
	@SuppressWarnings("unchecked")
	public Graph(int v) {
	
		V = v;
		
		adjList = new LinkedList[V];
		
		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dest, boolean directed) {
		
		adjList[src].add(dest);
		
		if(!directed)
			adjList[dest].add(src);
	}
	
}
