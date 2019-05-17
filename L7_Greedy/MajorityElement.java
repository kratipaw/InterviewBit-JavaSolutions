import java.util.ArrayList;
import java.util.List;

/**
 *  Given an array of size n, find the majority element. The majority element is the element that
 *  appears more than floor(n/2) times.
 *  
 *  You may assume that the array is non-empty and the majority element always exist in the array.
 *  	
 *  Example :
 *  
 *  Input : [2, 1, 2]
 *  Return  : 2 which occurs 2 times which is greater than 3/2. 
 */

public class MajorityElement {

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<Integer>();
		A.add(2);
		A.add(1);
		A.add(2);
		
		System.out.println(new MajorityElement().majorityElement(A));
		
	}

	public int majorityElement(final List<Integer> A) {
        
        int n = A.size();
        
        if(n < 1)
            return -1;
        
        //Moore's Voting Algo
        int cadet = A.get(0);
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            
            if(cadet == A.get(i))
                count++;
            
            else 
                count--;
            
            if(count == 0) {
                cadet = A.get(i);
                count = 1;
            }
        }
        
        return cadet;
        
    }
	
}
