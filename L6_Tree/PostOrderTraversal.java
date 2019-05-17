import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {

		
		BinaryTree tree = new BinaryTree();
		  
        // Let us create trees shown in above diagram
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
  
        ArrayList<Integer> result = postorderTraversal(tree.root);
        
        for (int i = 0; i < result.size(); i++) {
			
        	System.out.print(result.get(i) + "  ");
		}
        
        System.out.println();
	}
	
	private static ArrayList<Integer> postorderTraversal(TreeNode A) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Stack<TreeNode> S = new Stack<TreeNode>();
         
        if (A == null)
            return list;
        S.push(A);
        TreeNode prev = null;
        while (!S.isEmpty()) 
        {
            TreeNode current = S.peek();
  
            if (prev == null || prev.left == current || prev.right == current) 
            {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.val);
                }
  
            } 
            else if (current.left == prev) 
            {
                if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.val);
                }
                  
               
            } 
            else if (current.right == prev) 
            {
                S.pop();
                list.add(current.val);
            }
  
            prev = current;
        }
  
        return list;
    }

}
