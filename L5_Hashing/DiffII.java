import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 

	Given an array A of integers and another non negative integer k, 
	find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
	
	Example :
	
	Input :
	
	A : [1 5 3]
	k : 2
	
	Output :
	1
	as 3 - 1 = 2

    Return 0 / 1 for this problem.


 */
public class DiffII {

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(3);
		A.add(5);
		
		int B = 2;
		
		System.out.println(new DiffII().diffPossible(A, B));
	}
	
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
    	
    	if(A == null || A.size() <= 1 || B < 0)
    		return 0;
    	
    	HashSet<Integer> set = new HashSet<>();
    	
    	for(int num : A) {
    		if(set.contains(num + B) || set.contains(num - B))
    			return 1;
    		
    		set.add(num);
    	}
    	
    	return 0;
    }

}
