import java.util.ArrayList;

public class JumpGameArray {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(2);
		A.add(3);
		A.add(1);
		A.add(1);
		A.add(4);
		
		/*A.add(3);
		A.add(2);
		A.add(1);
		A.add(0);
		A.add(4);*/
		
		System.out.println(canJump(A));
		
	}

	private static int canJump(ArrayList<Integer> A) {
    
		/*int n = A.size();
		
		if(n == 0) 
			return 1;
		
		if(n > 1 && A.get(0) == 0)
			return 0;
		
		int jumps[] = new int[n];
		
		jumps[0] = 0;
		
		for (int i = 1; i < n; i++) {
			
			jumps[i] = Integer.MAX_VALUE;
			
			for (int j = 0; j < i; j++) {
				
				if(i <= j + A.get(j) && jumps[j] != Integer.MAX_VALUE)
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
				
			}
			
		}
		
		if(jumps[n-1] != Integer.MAX_VALUE)
			return 1;
		
		return 0;*/
		
		
		int n = A.size();
		
		if(n == 0 || n == 1) 
			return 1;
		
		if(A.get(0) == 0)
			return 0;
		
		int maxReach = A.get(0);
		
		int step = A.get(0);
		
		int jump = 1;
		
		for (int i = 1; i < n; i++) {
			
			if(i == n-1 && jump >0)
				return 1;
			
			maxReach = Math.max(maxReach, i+A.get(i));
			
			step--;
			
			if(step == 0) {
				
				jump++;
				
				if(i>=maxReach) {
					return 0;
				}
				step = maxReach - i;
				
			}
			
		}
		
		return 0;
		
		
	}
}
