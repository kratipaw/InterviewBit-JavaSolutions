public class IdenticalBinaryTrees {

	public static void main(String[] args) {

		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.right.left = new TreeNode(4);
		
	}
	
	private static int isSameTree(TreeNode A, TreeNode B) {
    
		if(A == null && B == null)
			return 1;
	
		if(A == null || B == null)
			return 0;
	
		if(A.val == B.val && isSameTree(A.left, B.left) == 1 && isSameTree(A.right, B.right) == 1)
			return 1;
		else
			return 0;
	
	}

}
