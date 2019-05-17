import java.util.ArrayList;
import java.util.List;

public class RainWaterTrapped {

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<Integer>();
		
		A.add(0);
		A.add(1);
		A.add(0);
		A.add(2);
		A.add(1);
		A.add(0);
		A.add(1);
		A.add(3);
		A.add(2);
		A.add(1);
		A.add(2);
		A.add(1);
		
		System.out.println(trap(A));
	}
	
	private static int trap(final List<Integer> A) {
    
		int n = A.size();
		
		if(n < 2)
			return 0;
		
		int left[] = new int[n];
		
		int right[] = new int[n];
		
		left[0] = A.get(0);
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i-1], A.get(i));
		}
	
		right[n-1] = A.get(n-1);
		for (int i = n-2; i >= 0; i--) {
			right[i] = Math.max(right[i+1], A.get(i));
		}
		
		int waterTrapped = 0;
		
		for (int i = 0; i < n; i++) {
			waterTrapped = waterTrapped + (Math.min(left[i], right[i]) - A.get(i));
		}
		
		return waterTrapped;
	}

}
