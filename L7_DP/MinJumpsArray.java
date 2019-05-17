import java.util.ArrayList;

public class MinJumpsArray {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>();
		
		A.add(2);
		A.add(3);
		A.add(1);
		A.add(1);
		A.add(4);
		
		System.out.println(jump(A));
 		
	}

	//TIME LIMIT EXCEEDED
	/*private static int jump(ArrayList<Integer> A) {
		
		int n = A.size();
        
        if(n == 0 || (n == 1 && A.get(0) == 0))
            return 0;
        
        if( A.get(0) == 0)
            return -1;
		
		int jump[] = new int[n];
		
		jump[0] = 0;
		
		for (int i = 1; i < n; i++) {
			
			jump[i] = Integer.MAX_VALUE;
			
			for (int j = 0; j < i; j++) {
				
				if(i<=j + A.get(j).intValue() && jump[j]!=Integer.MAX_VALUE) {
					jump[i] = Math.min(jump[j] + 1, jump[i]);
					break;
				}
			}
		}
		
		
		return jump[n-1];
    }
	*/
	
	private static int jump(ArrayList<Integer> A) {
		
		int n = A.size();
        
        if(n == 0 || (n == 1 && A.get(0) == 0))
            return 0;
        
        if( A.get(0) == 0)
            return -1;
        
        int maxReach = A.get(0).intValue();
        
        int step = A.get(0).intValue();
        
        int jump = 1;
        
        for (int i = 1; i < n; i++) {
			
        	if(i == n-1)
        		return jump;
        	
        	
        	maxReach = Math.max(maxReach, i+A.get(i).intValue());
        	
        	step--;
        	
        	if(step == 0) {
        		
        		jump++;
        			
        		if(i>=maxReach)
        			return -1;
        		
        		step = maxReach - i;
        		
        	}
		}
		return -1;
	}
	
}
