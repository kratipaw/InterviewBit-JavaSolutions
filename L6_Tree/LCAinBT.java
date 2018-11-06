package L6_Tree;

import java.util.ArrayList;

public class LCAinBT {

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(8);
		root.left.left = new Node(11);
		root.right.left = new Node(13);
		root.right.right = new Node(4);
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(2);
		root.right.right.left = new Node(5);
		root.right.right.right = new Node(1);
		
		int B = 2;
		
		int C = 7;
		
		System.out.println(lca(root, B, C));
		
	}
	
	private static int lca(Node A, int B, int C) {
		
		ArrayList<Integer> bb = new ArrayList<Integer>();
		
		ArrayList<Integer> cc = new ArrayList<Integer>();
		
		return lca_helper(A, B, C, bb, cc);
		
    }
	
	private static int lca_helper(Node A, int B, int C, ArrayList<Integer> bb, ArrayList<Integer> cc) {
		
		if(!findPath(A, B, bb) || !findPath(A, C, cc)) {
			return -1;
		}
		
		int i = 0;
		
		for (i = 0; i < bb.size() && i < cc.size(); i++) {
			
			if(!bb.get(i).equals(cc.get(i)))
				break;
		}
		
		return bb.get(i - 1);
	}
	
	private static boolean findPath(Node A, int n, ArrayList<Integer> nn) {
		
		if(A == null)
			return false;
		
		nn.add(A.data);
		
		if(A.data == n)
			return true;
		
		if(A.left != null && findPath(A.left, n, nn))
			return true;
		
		if(A.right != null && findPath(A.right, n, nn))
			return true;
			
		
		nn.remove(nn.size() - 1);
		
		return false;
		
	}

}
