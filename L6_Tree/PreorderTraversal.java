import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

	public static void main(String[] args) {

		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(-1);
		A.left.right = new TreeNode(-1);
		A.right.left = new TreeNode(4);
		A.right.right = new TreeNode(-1);
		A.right.left.left = new TreeNode(-1);
		A.right.left.right = new TreeNode(5);
		
		ArrayList<Integer> result = preorderTraversal(A);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
	
	private static ArrayList<Integer> preorderTraversal(TreeNode A) {
     
		ArrayList<Integer> result = new ArrayList<>();
		
		if(A == null)
			return result;
		
		Stack<TreeNode> stack = new Stack<>();
		
		stack.add(A);
		
		while(!stack.isEmpty()) {
			
			TreeNode temp = stack.pop(); 
			
			result.add(temp.val);
			
			if(temp.right!=null && temp.right.val!=-1)
				stack.add(temp.right);
			
			if(temp.left!=null && temp.left.val!=-1)
				stack.add(temp.left);
			
		}
		
		return result;
    }

}
