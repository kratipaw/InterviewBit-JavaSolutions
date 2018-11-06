package L6_Tree;

public class SymmetricBinaryTree {

	public static void main(String[] args) {

		Node A = new Node(1);
		A.left = new Node(2);
		A.right = new Node(3);
		A.left.left = new Node(4);
		A.right.left = new Node(4);
		
		System.out.println(isSymmetric(A));
	}
	
	private static int isSymmetric(Node A) {
		
		return isMirror(A, A);
		
    }

	private static int isMirror(Node A, Node B) {
		
		if(A == null && B == null)
			return 1;
		
		if(A == null || B == null)
			return 0;
		
		if(A.data == B.data && isMirror(A.left, B.right) == 1 && isMirror(A.right, B.left) == 1)
			return 1;
		else
			return 0;
		
	}
}
