import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 

	Given a binary tree, return the level order traversal of its nodes’ values.
	(i.e, from left to right, level by level).
	
	Example :
	Given binary tree
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	
	return its level order traversal as:
	
	[
	  [3],
	  [9,20],
	  [15,7]
	]
	
	Also think about a version of the question where you are asked to do a level order traversal
	 of the tree when depth of the tree is much greater than number of nodes on a level.

 * 
 */

public class LevelOrder {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
    
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(A == null)
			return result;
		
		Queue<TreeNode> qu = new LinkedList<>();
		
		qu.add(A);
		
		while(!qu.isEmpty()) {
			
			int nodeCount = qu.size();

			if(nodeCount == 0)
				break;
			
			ArrayList<Integer> tmp = new ArrayList<>();
			
			while(nodeCount > 0) {
				
				TreeNode node = qu.poll();
				tmp.add(node.val);
				
				if(node.left != null)
					qu.add(node.left);
				
				if(node.right != null)
					qu.add(node.right);
				
				nodeCount--;
			}
			result.add(tmp);
		}
		
		return result;
	}
}
