package L6_Tree;

public class InvertTheBinaryTree {

	public static void main(String[] args) {

		Node A = new Node(1);
		A.left = new Node(2);
		A.right = new Node(3);
		A.left.left = new Node(4);
		A.left.right = new Node(5);
		A.right.left = new Node(6);
		
		Node res = invertTree(A);
		
	}
	
	private static Node invertTree(Node A) {
    
		if(A == null)
			return A;
		
		Node left = invertTree(A.left);
		Node right = invertTree(A.right);
		
		A.left = right;
		A.right = left;
	
		return A;
	}

}
