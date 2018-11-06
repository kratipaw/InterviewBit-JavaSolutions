package L8_Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CommutableIslands {

	private static int find(Subset subsets[], int vertex) {
		
		if(subsets[vertex].parent != vertex)
			subsets[vertex].parent = find(subsets, subsets[vertex].parent);
		
		return subsets[vertex].parent;
		
	}
	
	private static void union(Subset subsets[], int x, int y) {
		
		int xParent = find(subsets, x);
		
		int yParent = find(subsets, y);
		
		if(subsets[xParent].rank < subsets[yParent].rank)
			subsets[xParent].parent = yParent;
		
		else if(subsets[xParent].rank > subsets[yParent].rank)
			subsets[yParent].parent = xParent;
		
		else {
			
			subsets[yParent].parent = xParent;
			subsets[xParent].rank++;
		}
		
	}
	
	public static void main(String[] args) {

		int A = 4;
		
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row = new ArrayList<>();
		row.add(1);
		row.add(2);
		row.add(1);
		
		B.add(row);
		
		row = new ArrayList<>();
		row.add(2);
		row.add(3);
		row.add(4);
		
		B.add(row);
		
		row = new ArrayList<>();
		row.add(1);
		row.add(4);
		row.add(3);
		
		B.add(row);
		
		row = new ArrayList<>();
		row.add(4);
		row.add(3);
		row.add(2);
		
		B.add(row);
		
		row = new ArrayList<>();
		row.add(1);
		row.add(3);
		row.add(10);
		
		B.add(row);
		
		System.out.println(solve(A, B));
		
	}
	
	private static int solve(int A, ArrayList<ArrayList<Integer>> B) {
    
		int rows = B.size();
		
		if(rows < 1)
			return -1;
		
		//1. Sort the edges by weight
		Collections.sort(B, new Comparator<ArrayList<Integer>>() {

			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(o1.size() - 1) - o2.get(o2.size() - 1);
			}
			
		});
		
		//2. Create subsets for all vertices and initialize it(Disjoint Union algo to detect cycle in graph)
		Subset subsets[] = new Subset[A];
		for (int i = 0; i < A; i++) {
			subsets[i] = new Subset(i);
		}
		
		//3. Add the edge with min weight one by one and check for its root parent in subsets, if root parents 
		// not same then the edge's vertices not in same subset, add it MST

		int result = 0;
		for (int i = 0; i < rows; i++) {
			
			ArrayList<Integer> edge = B.get(i);
			
			int src = find(subsets, edge.get(0) - 1);
			int dest = find(subsets, edge.get(1) - 1);
			
			if(src != dest) {
				result += edge.get(2);
				union(subsets, src, dest);
			}
		}
		
		return result;
	}
}

class Subset{
	
	int parent;
	int rank;
	
	public Subset(int p) {
		parent = p;
		rank = 0;
	}
}




