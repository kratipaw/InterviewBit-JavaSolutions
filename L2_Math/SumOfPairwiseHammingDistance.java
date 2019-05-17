import java.util.ArrayList;
import java.util.List;

public class SumOfPairwiseHammingDistance {

	private static long MOD = 1000000007;
	
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		/*
		A.add(81);
		A.add(13);
		A.add(2);
		A.add(7);
		A.add(96);
		*/
		
		A.add(57);
		A.add(38);
		A.add(29);
		A.add(19);
		A.add(14);
		A.add(22);
		A.add(73);
		A.add(75);
		A.add(94);
		
		System.out.println(hammingDistance(A));

	}
	
	 // DO NOT MODIFY THE LIST. IT IS READ ONLY
    private static int hammingDistance(final List<Integer> A) {
        
        int n = A.size();
        
        if(n == 0)
        	return 0;
        
        long result = 0;
        
        for (int i = 0; i < 32; i++) {
			
        	long count = 0;
        	
        	for (int j = 0; j < n; j++) {
				
        		if((A.get(j).intValue() & (1 << i)) == 0)
        			count++;
        		
			}
        	
        	result += (count * (n - count) * 2) % MOD;
        	
        	if(result >= MOD)
        		result -= MOD;
        	
		}
        
        return (int)result;
    }

}
