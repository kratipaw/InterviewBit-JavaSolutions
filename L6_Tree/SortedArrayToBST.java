import java.util.ArrayList;
import java.util.List;

public class SortedArrayToBST {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>();
        
        A.add(1);
        A.add(2);
        A.add(3);
        
        TreeNode result = sortedArrayToBST(A);
        
        printInoder(result);
	}

	private static void printInoder(TreeNode node) {
		
		if(node == null)
			return;
		
		printInoder(node.left);
		
		System.out.print(node.val + "\t");
		
		printInoder(node.right);
		
	}
	
	
	private static TreeNode sortedArrayToBST(final List<Integer> a) {
    
		if(a == null || a.size() == 0)
			return null;
		
		return convertToBST(a, 0, a.size() - 1);
	
	}
	
	private static TreeNode convertToBST(List<Integer> a, int start, int end) {
		
		if(start > end)
			return null;
		
		int mid = (start + end)/2;
		
		TreeNode node = new TreeNode(a.get(mid));
		
		node.left = convertToBST(a, start, mid-1);
		
		node.right = convertToBST(a, mid+1, end);
		
		return node;
		
	}
	
}
