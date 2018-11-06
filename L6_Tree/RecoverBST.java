package L6_Tree;

import java.util.ArrayList;
import java.util.Collections;

public class RecoverBST {

	TreeNode prev = null;
	
	public static void main(String[] args) {

		RecoverBST rec = new RecoverBST();
		
		TreeNode root = new TreeNode(6);
		
        root.left = new TreeNode(10); 
        root.right = new TreeNode(2); 
        root.left.left = new TreeNode(1); 
        root.left.right = new TreeNode(3); 
        root.right.right = new TreeNode(12); 
        root.right.left = new TreeNode(7);
		
		ArrayList<Integer> result = rec.recoverTree(root);
		
		System.out.println(result.toString());
		
	}

	public ArrayList<Integer> recoverTree(TreeNode A) {
        
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		correctTree(A, result);
		
		Collections.sort(result);
		
		return result;
        
    }
	
	public void correctTree(TreeNode A, ArrayList<Integer> result) {
		
		if(A != null) {
			
			correctTree(A.left, result);
			
			if(prev != null && A.val < prev.val) {
				
				if(result.size() == 0) {
					
					result.add(prev.val);
					result.add(A.val);
				}
				
				else if (result.size() == 2) {
					
					result.set(1, A.val);
				}
			}
			
			prev = A;
			
			correctTree(A.right, result);
			
		}
		
	}
	
}

class TreeNode {
	
	int val;

	TreeNode left;
    
	TreeNode right;
    
    TreeNode(int x) {
    	val = x;
    	left=null;
    	right=null;
    }
	
}
