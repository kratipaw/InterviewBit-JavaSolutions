import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		root.left.right.right.left = new TreeNode(10);
		root.left.right.right.right = new TreeNode(11);
		
		ArrayList<ArrayList<Integer>> result = zigzagLevelOrder(root);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	private static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
    
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	
		if(A == null)
			return result;
		
		Stack<TreeNode> st1 = new Stack<>();
		
		Stack<TreeNode> st2 = new Stack<>();
		
		st1.add(A);
		
		ArrayList<Integer> row = new ArrayList<>();
		
		while(!st1.isEmpty() || !st2.isEmpty()) {
			
			while(!st1.isEmpty()) {
				TreeNode temp = st1.pop();
				row.add(temp.val);
				
				if(temp.left!= null)
					st2.add(temp.left);
				
				if(temp.right!= null)
					st2.add(temp.right);
				
			}
			
			if(row.size()>0)
				result.add(row);
			row = new ArrayList<>();
			
			while(!st2.isEmpty()) {
				
				TreeNode temp = st2.pop();
				row.add(temp.val);
				
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
