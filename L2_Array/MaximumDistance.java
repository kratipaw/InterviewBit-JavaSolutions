import java.util.ArrayList;
import java.util.List;

public class MaximumDistance {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(3);
		A.add(5);
		A.add(4);
		A.add(2);
		
		System.out.println(maximumGap(A));
		
		System.out.println(maximumGap_efficient(A));
		
	}

	private static int maximumGap(final List<Integer> A) {
    
		int n = A.size();
		
		if(n < 1)
			return -1;
		
		int result = 0;
		
		for (int i = 0; i < n -1; i++) {
			
			for (int j = i + 1; j < n; j++) {
				
				if(A.get(i) <= A.get(j))
					result = Math.max(result, j-i);
				
			}
		}
	
		return result;
	}
	
	private static int maximumGap_efficient(final List<Integer> A) {
	    
		int n = A.size();
		
		if(n < 1)
			return -1;
		
		int min[] = new int[n];
		
		int max[] = new int[n];
		
		min[0] = A.get(0);
		for (int i = 1; i < n; i++) {
			min[i] = Math.min(A.get(i), min[i-1]);
		}
		
		max[n-1] = A.get(n-1);
		for (int i = n-2; i >= 0; i--) {
			max[i] = Math.max(A.get(i), max[i+1]);
		}
		
		int result = 0;
		
		int i = 0;
		int j = i+1;
		
		while(i < n && j < n) {

			if(min[i] <= max[j]){
				result = Math.max(result, j-i);
				j++;
			}
			else
				i++;
			
		}
		
		return result;
	}
}
