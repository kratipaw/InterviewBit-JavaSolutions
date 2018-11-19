package L3_BitMani;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

	Note: Your algorithm should have a linear runtime complexity. 
	Could you implement it without using extra memory?
	
	Example :
	
	Input : [1 2 2 3 1]
	Output : 3
	
 */
public class SingleNumber {

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(2);
		A.add(3);
		A.add(1);
		
		System.out.println(new SingleNumber().singleNumber(A));
	}

	 // DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int singleNumber(final List<Integer> A) {
        int result = A.get(0);
        
        for(int i = 1; i<A.size(); i++){
            result = result ^ A.get(i);
        }
        
        return result;
    }
}
