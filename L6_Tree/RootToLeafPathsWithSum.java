package L6_Tree;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(8);
		root.left.left = new Node(11);
		root.right.left = new Node(13);
		root.right.right = new Node(4);
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(2);
		root.right.right.left = new Node(5);
		root.right.right.right = new Node(1);
		
		int B = 22;
		
		ArrayList<ArrayList<Integer>> result = pathSum(root, B);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
		
	}

	private static ArrayList<ArrayList<Integer>> pathSum(Node A, int B) {
    
		ArrayList<Integer> path = new ArrayList<>();
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(A == null)
			return result;
		
		getPaths(A, B, result, path);
		
		return result;
	}
	
	private static void getPaths(Node A, int B, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
		
		if(A == null)
			return;
		
		path.add(A.data);
		
		if(A.left == null && A.right == null && (B - A.data == 0))
			result.add(new ArrayList<Integer>(path));
		
		if(A.left != null)
			getPaths(A.left, B - A.data, result, path);
		
		if(A.right != null)
			getPaths(A.right, B - A.data, result, path);
		
		path.remove(path.size() - 1);
	}
}
