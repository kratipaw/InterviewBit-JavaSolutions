public class PathSum {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
		
		int B = 21;
		
		System.out.println(hasPathSum(root, B));
		
	}
	
	private static int hasPathSum(TreeNode A, int B) {
    
		if(A == null) {
			
			if(B == 0)
				return 1;
			
			else
				return 0;
		}
	
		else {
			
			int result = 0;

			int sum = B - A.val;
			
			if (sum == 0 && A.left == null && A.right == null)
				return 1;
			
			if(A.left != null) {
				
				if((result == 1) || (hasPathSum(A.left, sum) == 1))
					result = 1;
				
			}
			
			if(A.right != null) {
				
				if((result == 1) || hasPathSum(A.right, sum)== 1)
					result = 1;
			} 
			
			return result;
		}
	}
	
	private static int hasPathSum_2(TreeNode A, int B) {
		
		boolean ans = has(A,B);
	    	
		if (ans == true)
	        	return 1;
	   	 return 0;
	}
	
	private static boolean has(TreeNode A, int sum){
		
		if (A == null)
            		return false;
        	
		if (A.left == null && A.right == null && sum == A.val)
            		return true;
		
        	return has(A.left, sum-A.val)|| has(A.right,sum-A.val);
	}

}
