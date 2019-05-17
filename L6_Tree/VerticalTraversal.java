import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalTraversal {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(9);
		
		ArrayList<ArrayList<Integer>> result = verticalOrderTraversal(root);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	}

	private static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
	
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(A == null)
            return result;
        
        int minHD = 0;
        int maxHD = 0;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        Queue<TreeNode> qu = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        
        qu.add(A);
        level.add(0);
        
        while(!qu.isEmpty()) {
            
            TreeNode temp = qu.poll();
            int lev = level.poll();
            
            minHD = Math.min(minHD, lev);
            maxHD = Math.max(maxHD, lev);
            
            if(map.containsKey(lev))
                map.get(lev).add(temp.val);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.val);
                map.put(lev, list);
            }
            
            if(temp.left!=null) {
                qu.add(temp.left);
                level.add(lev-1);
            }
            
            if(temp.right!=null) {
                qu.add(temp.right);
                level.add(lev+1);
            }
            
        }
        
        for (int i = minHD; i <= maxHD; i++) {
            if(map.containsKey(i))
                result.add(map.get(i));
        }
        
        return result;
	}
}
