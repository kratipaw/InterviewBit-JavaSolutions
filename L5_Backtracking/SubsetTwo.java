import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 * 
 * Example :
 * If S = [1,2,2], the solution is:
 * 
 * [
 * [],
 * [1],
 * [1,2],
 * [1,2,2],
 * [2],
 * [2, 2]
 * ]
 * 
 */
public class SubsetTwo {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(2);
		
		ArrayList<ArrayList<Integer>> result = new SubsetTwo().subsetsWithDup(A);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
		
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> curr = new ArrayList<Integer>();
		
		result.add(curr);
		
        if(A == null || A.isEmpty() || A.size() == 0)
        	return result;
		
        Collections.sort(A);
		
		subsetsUtil(result, curr, A, 0);
		
		return result;
    }
	
	public void subsetsUtil(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curr, ArrayList<Integer> A, int start) {
		
		for (int i = start; i < A.size(); i++) {
			
			if(i != start && A.get(i) == A.get(i - 1))
				continue;
			
			curr.add(A.get(i));
			
			ArrayList<Integer> tmp = new ArrayList<Integer>(curr);
			
			result.add(tmp);
			
			subsetsUtil(result, curr, A, i + 1);
			
			curr.remove(curr.size() - 1);
			
		}
	}
}
