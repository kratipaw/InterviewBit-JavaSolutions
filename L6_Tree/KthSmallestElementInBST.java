package L6_Tree;

import java.util.Stack;

public class KthSmallestElementInBST {

	public static void main(String[] args) {

		Node A = new Node(8);
		A.left = new Node(7);
		A.right = new Node(10);
		A.left.left = new Node(6);
		A.right.left = new Node(9);
		
		int B = 2;
		
		System.out.println(kthsmallest(A, B));
		
	}

	private static int kthsmallest(Node A, int B) {
		
		if(A == null)
			return -1;
		
		int idx = 0;
		
		Stack<Node> st = new Stack<>();
		
		
		Node curr = A;
		
		while(curr != null || !st.isEmpty()) {
			
			while(curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			
			curr = st.pop();
			
			idx++;
			
			if(idx == B)
				return curr.data;
			
			curr = curr.right;
			
		}
		
		return -1;
		
    }
}
