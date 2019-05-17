import java.util.Stack;

public class TwoSumBST {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);
		
		int B = 33;
		
		System.out.println(t2Sum(root, B));
		
	}
	
	private static int t2Sum(TreeNode A, int B) {
		
		if(A == null)
			return 0;
		
		Stack<TreeNode> inST = new Stack<TreeNode>();
		
		Stack<TreeNode> revInST = new Stack<TreeNode>();
		
		TreeNode inCurr = A;
		
		TreeNode revInCur = A;
		
		boolean inFlag = false, revInFlag = false;
		
		int inData = 0, revInData = 0;
		
		while(true) {
			
			while(!inFlag) {
				
				if(inCurr != null) {
					inST.push(inCurr);
					inCurr = inCurr.left;
				}
				
				else {
					
					if(inST.isEmpty())
						inFlag = true;
					
					else{
						inCurr = inST.pop();
						inData = inCurr.val;
						inCurr = inCurr.right;
						inFlag = true;
					}
				}
				
			}
			
			while(!revInFlag) {
				
				if(revInCur != null) {
					revInST.push(revInCur);
					revInCur = revInCur.right;
				}
				
				else {
					
					if(revInST.isEmpty())
						revInFlag = true;
					
					else {
						
						revInCur = revInST.pop();
						revInData = revInCur.val;
						revInCur = revInCur.left;
						revInFlag = true;
					}
				}
			}
			
			System.out.println("indata : " + inData);
			System.out.println("revIndata : " + revInData);
			
			if(inData != revInData && inData + revInData == B)
				return 1;
			
			else if(inData + revInData < B)
				inFlag = false;
			
			else if(inData + revInData > B)
				revInFlag = false;
			
			if(inData >= revInData)
				return 0;
			
		}
    }

}
