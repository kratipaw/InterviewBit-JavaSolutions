import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(2);
		/*A.add(1);
		A.add(5);
		A.add(6);
		A.add(2);
		A.add(3);*/
		
		System.out.println(largestRectangleArea(A));
		
	}
	
	private static int largestRectangleArea(ArrayList<Integer> A) {
		
		int n = A.size();
		
		if(n == 0)
			return 0;
		
		Stack<Integer> st = new Stack<>();
		
		int max = 0;
		
		int i = 0;
		
		while(i < n) {
			
			if(st.isEmpty() || A.get(st.peek()) <= A.get(i))
			{
				st.push(i);
				i++;
			}
			
			else
			{
				int topIndx = st.pop();
				
				int indx = i;
				
				if(!st.isEmpty())
					indx = i - st.peek() - 1;
				
				int currArea = A.get(topIndx) * indx;
				
				if(currArea > max)
					max = currArea;
				
			}
			
		}
		
		while(!st.isEmpty()) {
			
			int topIndx = st.pop();
			
			int indx = i;
			
			if(!st.isEmpty())
				indx = i - st.peek() - 1;
			
			int currArea = A.get(topIndx) * indx;
			
			if(currArea > max)
				max = currArea;
			
		}
		
				
		return max;
    }

}
