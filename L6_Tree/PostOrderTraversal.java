package L6_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {

		
		BinaryTree tree = new BinaryTree();
		  
        // Let us create trees shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
  
        ArrayList<Integer> result = postorderTraversal(tree.root);
        
        for (int i = 0; i < result.size(); i++) {
			
        	System.out.print(result.get(i) + "  ");
		}
        
        System.out.println();
	}
	
	private static ArrayList<Integer> postorderTraversal(Node A) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Stack<Node> S = new Stack<Node>();
         
        if (A == null)
            return list;
        S.push(A);
        Node prev = null;
        while (!S.isEmpty()) 
        {
            Node current = S.peek();
  
            if (prev == null || prev.left == current || prev.right == current) 
            {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.data);
                }
  
            } 
            else if (current.left == prev) 
            {
                if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.data);
                }
                  
               
            } 
            else if (current.right == prev) 
            {
                S.pop();
                list.add(current.data);
            }
  
            prev = current;
        }
  
        return list;
    }

}
