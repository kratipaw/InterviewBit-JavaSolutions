import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MAxSumContiguousSubarray {

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<Integer>();
		
		A.add(-2);
		A.add(-1);
		/*A.add(-3);
		A.add(4);
		A.add(-1);
		A.add(2);
		A.add(1);
		A.add(-5);
		A.add(4);*/
		
		System.out.println(maxSubArray(A));
	}
	
	private static int maxSubArray(final List<Integer> A) {
    
		int n = A.size();
		
		if(n==0)
			return 0;
		
		int j = 0;
        
		while(j<n){
            if(A.get(j).intValue()>=0)
                break;
            j++;
        }
        
        if(j==n)
            return Collections.max(A);
		
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			
			sum = sum + A.get(i).intValue();
			
			if(sum<0)
				sum = 0;
			else if(max<sum)
				max = sum;
		}
		
		return max;
	}

}
