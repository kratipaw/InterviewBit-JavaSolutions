public class SymmetricBinaryTree {

	public static void main(String[] args) {

		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.right.left = new TreeNode(4);
		
		System.out.println(isSymmetric(A));
	}
	
	private static int isSymmetric(TreeNode A) {
		
		return isMirror(A, A);
		
    }

	private static int isMirror(TreeNode A, TreeNode B) {
		
		if(A == null && B == null)
			return 1;
		
		if(A == null || B == null)
			return 0;
		
		if(A.val == B.val && isMirror(A.left, B.right) == 1 && isMirror(A.right, B.left) == 1)
			return 1;
		else
			return 0;
		
	}
}
