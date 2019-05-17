import java.util.ArrayList;

public class ConstructTreeFromInorderAndPreorder {

	private static int preIndex = 0;
	
	public static void main(String[] args) {

		int in[] = { 4, 2, 5, 1, 6, 3 }; 
        int pre[] = { 1, 2, 4, 5, 3, 6 }; 
        
        //TreeNode root = constructTree(in, pre, 0, in.length - 1);
        
        //printInoder(root);
        
        ArrayList<Integer> A = new ArrayList<Integer>();
        
        A.add(1);
        A.add(2);
        A.add(4);
        A.add(5);
        A.add(3);
        A.add(6);
        
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        B.add(4);
        B.add(2);
        B.add(5);
        B.add(1);
        B.add(6);
        B.add(3);
        
        TreeNode result = buildTree(A, B);
        
        printInoder(result);
	}
	
	private static void printInoder(TreeNode node) {
		
		if(node == null)
			return;
		
		printInoder(node.left);
		
		System.out.print(node.val + "\t");
		
		printInoder(node.right);
		
	}
	
	
	private static TreeNode constructTree(int in[], int pre[], int inStart, int inEnd) {
		
		if(inStart > inEnd)
			return null;
		
		TreeNode node = new TreeNode(pre[preIndex]);
		
		preIndex++;
		
		if(inStart == inEnd)
			return node;
		
		int inIndex = searchInOrder(in, inStart, inEnd, node.val);

		node.left = constructTree(in, pre, inStart, inIndex-1);
		
		node.right = constructTree(in, pre, inIndex + 1, inEnd);
		
		return node;
		
	}
	
	private static int searchInOrder(int in[], int start, int end, int item) {
		
		for (int i = start; i <= end; i++) {
			if(in[i] == item)
				return i;
		}
		
		return -1;
	}
	
	public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        
		if(A == null || B == null || A.size() != B.size())
			return null;
		
		preIndex = 0;
		
        return buildTreeUtil(A, B, 0, B.size() - 1);
        
    }
	
	public static TreeNode buildTreeUtil(ArrayList<Integer> A, ArrayList<Integer> B, int inStart, int inEnd) {
		
		System.out.println("inStart : " + inStart);
		
		System.out.println("inEnd : " + inEnd);
		
		if(inStart > inEnd)
			return null;
		
		System.out.println(preIndex);
		
		TreeNode node = new TreeNode(A.get(preIndex));
		
		preIndex++;
		
		if(inStart == inEnd)
			return node;
		
		int inIndex = search(B, inStart, inEnd, node.val);
		
		System.out.println("inIndex : " + inIndex);
		
		node.left = buildTreeUtil(A, B, inStart, inIndex -1);
		
		node.right = buildTreeUtil(A, B, inIndex + 1, inEnd);
		
		return node;
	}
	
	public static int search(ArrayList<Integer> in, int start, int end, int item) {
		
		int i = 0;
		
		for (i = start; i <= end; i++) {
			if(in.get(i) == item)
				break;
		}
		
		return i;
	}

}
