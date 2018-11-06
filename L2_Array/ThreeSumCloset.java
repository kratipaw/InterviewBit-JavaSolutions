package L2_Array;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumCloset {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(-1);
		A.add(2);
		A.add(1);
		A.add(-4);
		
		System.out.println(getClosestSum(A, 1));
	}
	
	private static int getClosestSum(ArrayList<Integer> A, int B) {
	
		Collections.sort(A);
		
		int n = A.size();
		
		int min = Integer.MAX_VALUE; 
		int result = 0;
		
		for (int i = 0; i < n-2; i++) {
			int j = i+1;
			int k = n-1;
			
			while(j<k) {
				
				int sum = A.get(i) + A.get(j) + A.get(k);
				
				int diff = Math.abs(sum - B);
				
				if(diff == 0)
					return sum;
				
				if(diff<min) {
					min = diff;
					result = sum;
				}
				
				if(sum<=B)
					j++;
				else
					k--;
			}
		}
		
		return result;
	}

}
