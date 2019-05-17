public class SumRootToLeafNumbers {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		System.out.println(sumNumbers(root));
		
	}
	
	private static int sumNumbers(TreeNode A) {
    
		if(A == null)
			return 0;
		
		int sum = 0;
		
		sum = sumNumbers_recur(A, sum);
		
		return sum % 1003;
	}
	
	private static int sumNumbers_recur(TreeNode A, int sum) {
		
		if(A == null)
			return 0;
		
		if(A.left == null && A.right == null)
			return (sum * 10 + A.val) % 1003;
		
		sum = sum * 10 + A.val;
		sum = sum % 1003;
		
		int add = sumNumbers_recur(A.left, sum) + sumNumbers_recur(A.right, sum);
		
		return add % 1003;
			
	}
	
}
