package L3_BitMani;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

	Examples : 
	Input 
	0 2 5 7 
	Output 
	2 (0 XOR 2) 
	Input 
	0 4 7 9 
	Output 
	3 (4 XOR 7)
	
	Constraints: 
	2 <= N <= 100 000 
	0 <= A[i] <= 1 000 000 000
	
 */
public class MinXORValue {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(0);
		A.add(2);
		A.add(5);
		A.add(7);
		
		System.out.println(new MinXORValue().findMinXor(A));
	}
	
	public int findMinXor(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        Collections.sort(A);
        for(int i = 0; i<A.size()-1;i++){
            int val = A.get(i) ^ A.get(i+1);
                if(val<min)
                    min = val;
            
        }
        return min;
    }
}
