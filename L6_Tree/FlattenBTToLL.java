import java.util.Stack;

public class FlattenBTToLL {

	public static void main(String[] args) {

		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(5);
		A.left.left = new TreeNode(3);
		A.left.right = new TreeNode(4);
		A.right.right = new TreeNode(6);
		
		TreeNode result = flatten(A);
		
		printList(result);
		
	}

	private static TreeNode flatten(TreeNode a) {
		
		/*if(a == null || (a.left == null && a.right == null))
			return a;
		
		if(a.left != null) {
			
			flatten(a.left);
			
			TreeNode temp = a.right;
			
			a.right = a.left;
			
			a.left = null;
			
			TreeNode node = a.right;
			
			while(node.right != null) {
				node = node.right;
			}
			
			node.right = temp;
			
		}
		
		flatten(a.right);
		
		return a;
		*/
		
		Stack<TreeNode> st = new Stack<>();
		
		TreeNode temp = a;
		
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
	
	private static void printList(TreeNode head) {
		
		TreeNode temp = head;
		
		while(temp!=null) {
			System.out.print(temp.val + " ");
			temp = temp.right;
		}
		
		System.out.println();
	}
}
