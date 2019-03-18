package L6_Tree;

public class PathSum {

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(8);
		root.left.left = new Node(11);
		root.right.left = new Node(13);
		root.right.right = new Node(4);
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(2);
		root.right.right.right = new Node(1);
		
		int B = 21;
		
		System.out.println(hasPathSum(root, B));
		
	}
	
	private static int hasPathSum(Node A, int B) {
    
		if(A == null) {
			
			if(B == 0)
				return 1;
			
			else
				return 0;
		}
	
		else {
			
			int result = 0;

			int sum = B - A.data;
			
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
	
	private static int hasPathSum_2(Node A, int B) {
		
		boolean ans = has(A,B);
	    	
		if (ans == true)
	        	return 1;
	   	 return 0;
	}
	
	private static boolean has(Node A, int sum){
		
		if (A == null)
            		return false;
        	
		if (A.left == null && A.right == null && sum == A.val)
            		return true;
		
        	return has(A.left, sum-A.val)|| has(A.right,sum-A.val);
	}

}
