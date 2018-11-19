package L8_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class point{
    int depth;
    int pos;
    point(){
        depth = 0;
        pos = 0;
    }
}

public class LargestDistanceBtwNodesOfTree {

	public static int maxCount;
	
	public static int x;
	
	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(-1);
		A.add(0);
		A.add(0);
		A.add(0);
		A.add(3);
		
		//System.out.println(new LargestDistanceBtwNodesOfTree().solve_gettingException(A));
		
		System.out.println(new LargestDistanceBtwNodesOfTree().solve(A));
	}
	
	public int solve(ArrayList<Integer> A) {
		
		int n = A.size();
        int result = 0;
        point[] arr = new point[n];
        for(int i=0; i<n; i++){
            arr[i] = new point();
        }
        for(int i=n-1; i>0; i--){
            int k = A.get(i);
            if(arr[k].depth<arr[k].pos) 
            arr[k].depth = Math.max(arr[k].depth,(Math.max(arr[i].depth,arr[i].pos)+1));
            else 
            arr[k].pos   = Math.max(arr[k].pos,(Math.max(arr[i].depth,arr[i].pos)+1));
            int y = arr[i].depth + (arr[i].pos);
            if(result<y) result=y;
        }
        int k = arr[0].depth+arr[0].pos;
        if(result<k) result=k;
        return result;
		
	}

	//Getting StackOverflow Exception
	public int solve_gettingException(ArrayList<Integer> A) {
    
		int n = A.size();
		
		if(n == 1 && A.get(0) > 0)
			return 1;
		
		int root = 0;
		
		Graph gfh = new Graph(n);
		
		for (int i = 0; i < n; i++) {
			int dest = A.get(i);
			
			if(dest != -1)
				gfh.addEdge(i, A.get(i), false);
			
			else
				root = i;
		}
	
		maxCount = 1;
		
		//find farthest node from any random node, we will take root. Say this node is x
		//This node would be one of the nodes with the largest distanced nodes.
		dfs(root, n, gfh.adjList);
		
		//now, find farthest node from x. This distance between x and its farthest node is
		// the largest distance between any nodes of tree.
		dfs(x, n, gfh.adjList);
		
		return maxCount - 1;
	}
	
	public void dfs(int node, int vertices, LinkedList<Integer> adjList[]) {
		
		boolean visited[] = new boolean[vertices + 1];
		
		Arrays.fill(visited, false);
		
		int count = 0;
		
		dfsUtil(node, count + 1, adjList, visited);
	}
	
	
	public void dfsUtil(int node, int count, LinkedList<Integer> adjList[], boolean visited[]) {
		
		visited[node] = true; 
	    
		count++; 
	          
        LinkedList<Integer> l = adjList[node]; 
        
        for(Integer i: l) { 
            
        	if(!visited[i]){ 
                if (count >= maxCount) { 
                    maxCount = count; 
                    x = i; 
                } 
                dfsUtil(i, count, adjList, visited); 
            } 
        } 
	}
}

