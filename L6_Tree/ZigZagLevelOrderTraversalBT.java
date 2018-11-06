package L6_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(8);
		root.right.right.left = new Node(9);
		root.left.right.right.left = new Node(10);
		root.left.right.right.right = new Node(11);
		
		ArrayList<ArrayList<Integer>> result = zigzagLevelOrder(root);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	private static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node A) {
    
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	
		if(A == null)
			return result;
		
		Stack<Node> st1 = new Stack<>();
		
		Stack<Node> st2 = new Stack<>();
		
		st1.add(A);
		
		ArrayList<Integer> row = new ArrayList<>();
		
		while(!st1.isEmpty() || !st2.isEmpty()) {
			
			while(!st1.isEmpty()) {
				Node temp = st1.pop();
				row.add(temp.data);
				
				if(temp.left!= null)
					st2.add(temp.left);
				
				if(temp.right!= null)
					st2.add(temp.right);
				
			}
			
			if(row.size()>0)
				result.add(row);
			row = new ArrayList<>();
			
			while(!st2.isEmpty()) {
				
				Node temp = st2.pop();
				row.add(temp.data);
				
				if(temp.right!= null)
					st1.add(temp.right);
				
				if(temp.left!= null)
					st1.add(temp.left);
			}
			
			if(row.size()>0)
				result.add(row);
			row = new ArrayList<>();
		}
		
		return result;
	}
}
