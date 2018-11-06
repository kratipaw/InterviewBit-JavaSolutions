package L6_Tree;

import java.util.Stack;

public class TwoSumBST {

	public static void main(String[] args) {

		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		
		int B = 33;
		
		System.out.println(t2Sum(root, B));
		
	}
	
	private static int t2Sum(Node A, int B) {
		
		if(A == null)
			return 0;
		
		Stack<Node> inST = new Stack<Node>();
		
		Stack<Node> revInST = new Stack<Node>();
		
		Node inCurr = A;
		
		Node revInCur = A;
		
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
						inData = inCurr.data;
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
						revInData = revInCur.data;
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
