public class InvertTheBinaryTree {

	public static void main(String[] args) {

		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		
		TreeNode res = invertTree(A);
		
	}
	
	private static TreeNode invertTree(TreeNode A) {
    
		if(A == null)
			return A;
		
		TreeNode left = invertTree(A.left);
		TreeNode right = invertTree(A.right);
		
		A.left = right;
		A.right = left;
	
		return A;
	}

}
