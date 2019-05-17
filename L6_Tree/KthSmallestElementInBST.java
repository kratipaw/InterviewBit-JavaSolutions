import java.util.Stack;

public class KthSmallestElementInBST {

	public static void main(String[] args) {

		TreeNode A = new TreeNode(8);
		A.left = new TreeNode(7);
		A.right = new TreeNode(10);
		A.left.left = new TreeNode(6);
		A.right.left = new TreeNode(9);
		
		int B = 2;
		
		System.out.println(kthsmallest(A, B));
		
	}

	private static int kthsmallest(TreeNode A, int B) {
		
		if(A == null)
			return -1;
		
		int idx = 0;
		
		Stack<TreeNode> st = new Stack<>();
		
		
		TreeNode curr = A;
		
		while(curr != null || !st.isEmpty()) {
			
			while(curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			
			curr = st.pop();
			
			idx++;
			
			if(idx == B)
				return curr.val;
			
			curr = curr.right;
			
		}
		
		return -1;
		
    }
}
