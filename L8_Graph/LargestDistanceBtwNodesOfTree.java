package L8_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
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
		
		Stack<Integer> stck= new Stack<Integer>();
        
        Deque<Integer> deque = new LinkedList<>();
        
        deque.addFirst(root);
        
        while(!deque.isEmpty())
        {
            int val = deque.removeFirst();
            stck.push(val);
            for(int j=0;j<gfh.adjList[val].size();j++)
            {
                deque.addLast(gfh.adjList[val].get(j));
            }
        }
        
        int[] d = new int[A.size()];
        
        int finalans=0;
        int sz=stck.size();
        for(int i=0;i<sz;i++)
        {
            int maxi=0,maxi2=0;
            int node = stck.pop();
            for(int j=0;j<gfh.adjList[node].size();j++)
            {
                int val = d[gfh.adjList[node].get(j)];
                if(val>=maxi)
                {
                    maxi2=maxi;
                    maxi=val;
                }
                else
                if(val<maxi && val>=maxi2)
                {
                    maxi2=val;
                }
            }
            
            d[node]=1+maxi;
            
            finalans=Math.max(finalans,maxi+maxi2);
            //System.out.println(node + " "+ d[node] + " "+ finalans);
            
        }
        
        return finalans;
		
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

class Graph{
	
	int V;
	
	LinkedList<Integer> adjList[];
	
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
	
	public void printGraph() {
		
		for (int i = 0; i < V; i++) {
			
			System.out.print(i + "\t");
			
			for (int j = 0; j < adjList[i].size(); j++) {
				int n = adjList[i].get(j);
				System.out.print(n + "\t");
			}
			
			System.out.println();
		}
	}
	
}
