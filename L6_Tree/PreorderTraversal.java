package L6_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

	public static void main(String[] args) {

		Node A = new Node(1);
		A.left = new Node(2);
		A.right = new Node(3);
		A.left.left = new Node(-1);
		A.left.right = new Node(-1);
		A.right.left = new Node(4);
		A.right.right = new Node(-1);
		A.right.left.left = new Node(-1);
		A.right.left.right = new Node(5);
		
		ArrayList<Integer> result = preorderTraversal(A);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
	
	private static ArrayList<Integer> preorderTraversal(Node A) {
     
		ArrayList<Integer> result = new ArrayList<>();
		
		if(A == null)
			return result;
		
		Stack<Node> stack = new Stack<>();
		
		stack.add(A);
		
		while(!stack.isEmpty()) {
			
			Node temp = stack.pop(); 
			
			result.add(temp.data);
			
			if(temp.right!=null && temp.right.data!=-1)
				stack.add(temp.right);
			
			if(temp.left!=null && temp.left.data!=-1)
				stack.add(temp.left);
			
		}
		
		return result;
    }

}
