package L6_Tree;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		System.out.println(sumNumbers(root));
		
	}
	
	private static int sumNumbers(Node A) {
    
		if(A == null)
			return 0;
		
		int sum = 0;
		
		sum = sumNumbers_recur(A, sum);
		
		return sum % 1003;
	}
	
	private static int sumNumbers_recur(Node A, int sum) {
		
		if(A == null)
			return 0;
		
		if(A.left == null && A.right == null)
			return (sum * 10 + A.data) % 1003;
		
		sum = sum * 10 + A.data;
		sum = sum % 1003;
		
		int add = sumNumbers_recur(A.left, sum) + sumNumbers_recur(A.right, sum);
		
		return add % 1003;
			
	}
	
}
