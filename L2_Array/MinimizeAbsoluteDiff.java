package L2_Array;

import java.util.ArrayList;

public class MinimizeAbsoluteDiff {

	public static void main(String[] args) {

		
	}

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
    
		int i = A.size() - 1;
		int j = B.size() - 1;
		int k = C.size() - 1;
		
		int min_diff = Math.abs(Math.max(A.get(i).intValue(), Math.max(B.get(j).intValue(), C.get(k).intValue()))
				- Math.min(A.get(i).intValue(), Math.min(B.get(j).intValue(), C.get(k).intValue())));
		
		int curr_diff = 0;
		
		while(i>=0 && j>=0 && k>=0) {
			
			curr_diff = Math.abs(Math.max(A.get(i).intValue(), Math.max(B.get(j).intValue(), C.get(k).intValue()))
					- Math.min(A.get(i).intValue(), Math.min(B.get(j).intValue(), C.get(k).intValue())));
			
			if(curr_diff<min_diff)
				min_diff = curr_diff;
			
			int max = Math.max(A.get(i).intValue(), Math.max(B.get(j).intValue(), C.get(k).intValue()));
			
			if(A.get(i).intValue() == max)
				i = i -1;
			else if(B.get(j).intValue() == max)
				j = j -1;
			else 
				k = k -1;
		}
		
		return min_diff;
	}
}
