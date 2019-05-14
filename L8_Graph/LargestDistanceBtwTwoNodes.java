package L8_Graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 *  Find largest distance
	Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is 
	to find largest distance between two nodes in A tree. Distance between two nodes is A number of edges on A path between 
	the nodes (there will be A unique path between any pair of nodes since it is A tree). The nodes will be 
	numbered 0 through N - 1.
	
	The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of 
	the i’s will have P[i] equal to -1, it will be root node.
	
	 Example:
	If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this: 
	          0
	       /  |  \
	      1   2   3
	               \
	                4  
	 One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that 
	 there are other paths with maximal distance. 

*/

public class LargestDistanceBtwTwoNodes {

	int n;
    
	ArrayList<ArrayList<Integer>> graph; 
	
	public static void main(String[] args) {

	}
	
	public int solve(ArrayList<Integer> A) {
        n = A.size();
        
        if (n == 1) {
            return 0;
        }
        
        graph = new ArrayList<ArrayList<Integer>>(n);
        
        //Initialized
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());    
        }
        
        for (int i = 0; i < n; i++) {
            int parent = A.get(i);
            if (parent == -1) {
                continue;
            }
            graph.get(i).add(parent);
            graph.get(parent).add(i);
        }
        
        int v = findFurthest(0)[0];
        
        return findFurthest(v)[1];
    }
    
    private int[] findFurthest(int start) {
        boolean[] visited = new boolean[n];
        
        Deque<Integer> level = new LinkedList<>();
        
        visited[start] = true;
        level.add(start);
        int dist = 0;
        
        while (true) {
            Deque<Integer> nextLevel = new LinkedList<>();
            
            for (int i : level) {
                for (int j : graph.get(i)) {
                    if (!visited[j]) {
                    	visited[j] = true;
                        nextLevel.add(j);
                    }
                }
            }
            
            if (nextLevel.isEmpty()) {
                return new int[] {level.getLast(), dist};
            } 
            
            level = nextLevel;
            
            dist++;
        }
    }

}
