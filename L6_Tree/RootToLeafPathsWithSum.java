import java.util.ArrayList;

public class RootToLeafPathsWithSum {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		int B = 22;
		
		ArrayList<ArrayList<Integer>> result = pathSum(root, B);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
		
	}

	private static ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
    
		ArrayList<Integer> path = new ArrayList<>();
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(A == null)
			return result;
		
		getPaths(A, B, result, path);
		
		return result;
	}
	
	private static void getPaths(TreeNode A, int B, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
		
		if(A == null)
			return;
		
		path.add(A.val);
		
		if(A.left == null && A.right == null && (B - A.val == 0))
			result.add(new ArrayList<Integer>(path));
		
		if(A.left != null)
			getPaths(A.left, B - A.val, result, path);
		
		if(A.right != null)
			getPaths(A.right, B - A.val, result, path);
		
		path.remove(path.size() - 1);
	}
}
