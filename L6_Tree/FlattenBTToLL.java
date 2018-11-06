package L6_Tree;

import java.util.Stack;

public class FlattenBTToLL {

	public static void main(String[] args) {

		Node A = new Node(1);
		A.left = new Node(2);
		A.right = new Node(5);
		A.left.left = new Node(3);
		A.left.right = new Node(4);
		A.right.right = new Node(6);
		
		Node result = flatten(A);
		
		printList(result);
		
	}

	private static Node flatten(Node a) {
		
		/*if(a == null || (a.left == null && a.right == null))
			return a;
		
		if(a.left != null) {
			
			flatten(a.left);
			
			Node temp = a.right;
			
			a.right = a.left;
			
			a.left = null;
			
			Node node = a.right;
			
			while(node.right != null) {
				node = node.right;
			}
			
			node.right = temp;
			
		}
		
		flatten(a.right);
		
		return a;
		*/
		
		Stack<Node> st = new Stack<>();
		
		Node temp = a;
		
		while(a != null || !st.isEmpty()) {
			
			if(a.right != null)
				st.push(a.right);
			
			a.right = a.left;
			a.left = null;
			
			if(a.right == null && !st.isEmpty()) {
				a.right = st.pop();
			}
			
			a = a.right;
			
		}
		
		return temp;
		
    }
	
	private static void printList(Node head) {
		
		Node temp = head;
		
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.right;
		}
		
		System.out.println();
	}
}
