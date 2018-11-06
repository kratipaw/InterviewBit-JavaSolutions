package L6_Tree;

public class IdenticalBinaryTrees {

	public static void main(String[] args) {

		Node A = new Node(1);
		A.left = new Node(2);
		A.right = new Node(3);
		A.left.left = new Node(4);
		A.right.left = new Node(4);
		
	}
	
	private static int isSameTree(Node A, Node B) {
    
		if(A == null && B == null)
			return 1;
	
		if(A == null || B == null)
			return 0;
	
		if(A.data == B.data && isSameTree(A.left, B.left) == 1 && isSameTree(A.right, B.right) == 1)
			return 1;
		else
			return 0;
	
	}

}
