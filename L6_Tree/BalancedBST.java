package L6_Tree;

public class BalancedBST {

	public static void main(String[] args) {

		
		Node A = new Node(1);
		A.left = new Node(2);
		A.right = new Node(3);
		A.left.left = new Node(4);
		A.right.left = new Node(5);
	
		System.out.println(isBalanced(A));
		
		System.out.println(isBalanced_efficient(A, 0));
	}

	private static int isBalanced(Node A) {
    
		if(A == null)
			return 1;
		
		int lH = height(A.left);
		
		int rH = height(A.right);
		
		if(Math.abs(lH-rH) <= 1 && isBalanced(A.left) == 1 && isBalanced(A.right) == 1)
			return 1;
		
		return 0;
	}
	
	private static int height(Node node) {
		
		if(node == null)
			return 0;
		
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	private static boolean isBalanced_efficient(Node A, int height) {
		
		if(A == null) {
			height = 0;
			return true;
		}
		
		int lH = 0, rH = 0;
		
		boolean lT = isBalanced_efficient(A.left, lH);
		
		boolean rT = isBalanced_efficient(A.right, rH);
		
		height = 1 + Math.max(lH, rH);
		
		if(Math.abs(lH - rH) > 1)
			return false;
		
		else
			return lT && rT;
	}
}
