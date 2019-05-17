import java.util.ArrayList;

public class LCAinBT {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		int B = 2;
		
		int C = 7;
		
		System.out.println(lca(root, B, C));
		
	}
	
	private static int lca(TreeNode A, int B, int C) {
		
		ArrayList<Integer> bb = new ArrayList<Integer>();
		
		ArrayList<Integer> cc = new ArrayList<Integer>();
		
		return lca_helper(A, B, C, bb, cc);
		
    }
	
	private static int lca_helper(TreeNode A, int B, int C, ArrayList<Integer> bb, ArrayList<Integer> cc) {
		
		if(!findPath(A, B, bb) || !findPath(A, C, cc)) {
			return -1;
		}
		
		int i = 0;
		
		for (i = 0; i < bb.size() && i < cc.size(); i++) {
			
			if(!bb.get(i).equals(cc.get(i)))
				break;
		}
		
		return bb.get(i - 1);
	}
	
	private static boolean findPath(TreeNode A, int n, ArrayList<Integer> nn) {
		
		if(A == null)
			return false;
		
		nn.add(A.val);
		
		if(A.val == n)
			return true;
		
		if(A.left != null && findPath(A.left, n, nn))
			return true;
		
		if(A.right != null && findPath(A.right, n, nn))
			return true;
			
		
		nn.remove(nn.size() - 1);
		
		return false;
		
	}

}
