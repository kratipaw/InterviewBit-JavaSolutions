package L8_Graph;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Given three prime number(p1, p2, p3) and an integer k. Find the first(smallest) k integers which have only p1, p2, p3 
   or a combination of them as their prime factors.

	Example:
	
	Input : 
	Prime numbers : [2,3,5] 
	k : 5
	
	If primes are given as p1=2, p2=3 and p3=5 and k is given as 5, then the sequence of first 5 integers will be: 
	
	Output: 
	{2,3,4,5,6}
	
	Explanation : 
	4 = p1 * p1 ( 2 * 2 )
	6 = p1 * p2 ( 2 * 3 )
	
	Note: The sequence should be sorted in ascending order
 */

public class SmallestSeqWithGivenPrimeNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> solve(int A, int B, int C, int D) {
		
		ArrayList<Integer> result = new ArrayList<>() ;
        
        TreeSet<Integer> set = new TreeSet<>() ;
        set.add(A);
        set.add(B);
        set.add(C);
        
        for(int i = 0; i < D; i++) {
            int temp = set.first();
            set.remove(temp);
            result.add(temp);
            
            set.add(temp*A);
            set.add(temp*B);
            set.add(temp*C);
            
        }
        return result;
		
	}
}
