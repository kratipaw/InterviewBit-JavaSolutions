package L2_Array;

import java.util.ArrayList;

public class MaximizeAbsoluteDifference {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(1);
		A.add(3);
		A.add(-1);
		
		System.out.println(maxArr(A));
	}

	private static int maxArr(ArrayList<Integer> A) {
    
		int max = 0;
		
		for (int i = 0; i < A.size()-1; i++) {
			for (int j = i+1; j < A.size(); j++) {
				int solve = Math.abs(A.get(i).intValue() - A.get(j).intValue()) + Math.abs(i-j);
				
				if(solve>max)
					max = solve;
			}
		}
		
		return max;
	}
	
	private static int maxArr_efficient(ArrayList<Integer> A) {
	    
		int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
		
        for (int i = 0; i < A.size(); i++)
        {
            max1 = Math.max(max1, A.get(i).intValue() + i);
            min1 = Math.min(min1, A.get(i).intValue() + i);
            max2 = Math.max(max2, A.get(i).intValue() - i);
            min2 = Math.min(min2, A.get(i).intValue() - i);
        }
 
        return Math.max(max1 - min1, max2 - min2);
	}
}
