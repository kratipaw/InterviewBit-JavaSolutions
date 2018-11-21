package L8_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
		
		LinkedList<Integer> adjList[] = new LinkedList[A.size()];
		
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		int root = 0;
		
		for(int i = 0 ; i < A.size() ; i++) {
			if(A.get(i) == -1) {
				root = i;
				break;
			}
			else {
				adjList[i].add(A.get(i));
				adjList[A.get(i)].add(i);
			}
		}
		
		int diameter[] = new int[A.size()];
		
		int init = bfs(A, root, diameter, adjList);
		
		int end = bfs(A, init - 1, diameter, adjList);
		
		return diameter[end - 1];
	}
	
	public int bfs(ArrayList<Integer> A, int start, int[] diameter, LinkedList<Integer> adjList[]) {
		
		Queue<Integer> qu = new LinkedList<>();
		
		qu.add(start);
		
		boolean visited[] = new boolean[A.size()];
		
		Arrays.fill(visited, false);
		Arrays.fill(diameter, 0);
		System.out.println("Start : " + start);
		visited[start] = true;
		
		while(!qu.isEmpty()){
			
			int tmp = qu.poll();
			
			Iterator<Integer> it = adjList[tmp].listIterator();
			
			while(it.hasNext()) {
				
				int next = it.next();
				
				if(!visited[next]) {
					
					visited[next] = true;
					
					diameter[next] += diameter[tmp] + 1;
					
					qu.add(next);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int i;
		for (i = 0; i < diameter.length; i++) {
			if(diameter[i] > max)
				max = diameter[i];
		}
		
		return i;
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

