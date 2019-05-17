import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

	public static void main(String[] args) {

		 ArrayList<Integer> A = new ArrayList<Integer>();
		 
		 A.add(3);
		 A.add(2);
		 A.add(1);
		 /*A.add(10);
		 A.add(8);*/
		 
		 ArrayList<Integer> result = prevSmaller(A);
		 
		 for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + "  ");
		 }
		 
		 System.out.println();

	}
	
	private static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
    
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int n = A.size();
		
		if(n==0)
			return result;
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			
			while(!stack.isEmpty() && stack.peek()>=A.get(i).intValue()) 
				stack.pop();
			
			
			if(stack.isEmpty())
				result.add(-1);
			else {
				int num = stack.peek();
				result.add(num);
			}
			
			stack.push(A.get(i).intValue());
		}	
		
		return result;
	}

}
