package L6_Tree;

import java.util.ArrayList;

public class ConstructTreeFromInorderAndPostorder {

	static int postIndx = 0;
	
	public static void main(String[] args) {

		
		int in[]   = {4, 8, 2, 5, 1, 6, 3, 7};
		
		int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
		
		postIndx = in.length - 1;
		
		Node node = constructTree(in, post, 0, postIndx);
		
		printInoder(node);
	}
	
	private static void printInoder(Node node) {
		
		if(node == null)
			return;
		
		printInoder(node.left);
		
		System.out.print(node.data + "\t");
		
		printInoder(node.right);
		
	}
	
	private static Node constructTree(int in[], int post[], int inStart, int inEnd) {
		
		if(inStart > inEnd) {
			return null;
		}
		
		Node node = new Node(post[postIndx]);
		
		postIndx--;
		
		if(inStart == inEnd)
			return node;
		
		int inIndex = searchInorder(in, inStart, inEnd, node.data);
		
		node.right = constructTree(in, post, inIndex + 1, inEnd);
		
		node.left = constructTree(in, post, inStart, inIndex - 1);
		
		
		
		return node;
	}
	
	private static int searchInorder(int in[], int start, int end, int item) {
		
		for (int i = start; i <= end; i++) {
			if(in[i] == item)
				return i;
		}
		
		return -1;
		
	}
	
	private static Node buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		if(A == null || B == null || A.size() != B.size())
			return null;
		
		postIndx = B.size() - 1;
		
        return buildTreeUtil(A, B, 0, B.size() - 1);
		
    }
	
	private static Node buildTreeUtil(ArrayList<Integer> A, ArrayList<Integer> B, int inStart, int inEnd) {
		
		if(inStart > inEnd)
			return null;
		
		Node node = new Node(B.get(postIndx));
		
		postIndx--;
		
		int idx = search(A, inStart, inEnd, node.data);
		
		node.right = buildTreeUtil(A, B, idx + 1, inEnd);
		
		node.left = buildTreeUtil(A, B, inStart, idx - 1);
		
		return node;
		
	}
	
	private static int search(ArrayList<Integer> in, int start, int end, int item) {
		
		int i = 0;
		
		for (i = start; i <= end; i++) {
			if(in.get(i) == item)
				break;
		}
		
		return i;
		
	}
	
}
