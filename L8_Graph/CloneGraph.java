package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class CloneGraph {

	public static void main(String[] args) {

	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
     
		Queue<UndirectedGraphNode> qu = new LinkedList<UndirectedGraphNode>();
		qu.add(node);
		
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		
		map.put(node, new UndirectedGraphNode(node.label));
		
		while(!qu.isEmpty()) {
			
			UndirectedGraphNode origN = qu.poll();
			
			UndirectedGraphNode cloneN = map.get(origN);
			
			if(origN.neighbors != null) {
				
				List<UndirectedGraphNode> origNegbr = origN.neighbors;
				
				for(UndirectedGraphNode graphN : origNegbr) {
					
					UndirectedGraphNode cloneNegbr = map.get(graphN);
					
					if(cloneNegbr == null) {
						
						qu.add(graphN);
						
						cloneNegbr = new UndirectedGraphNode(graphN.label);
						
						map.put(graphN, cloneNegbr);
					}
					
					cloneN.neighbors.add(cloneNegbr);
					
				}
			}
			
		}
		
		return map.get(node);
    }
}
