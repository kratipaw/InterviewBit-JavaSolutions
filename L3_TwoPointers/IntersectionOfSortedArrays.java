package L3_TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<>();
		A.add(1);
		
	}

	private static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
		
		int i = 0;
		int j = 0;
		
		ArrayList<Integer> result = new ArrayList<>();
		
		while(i<A.size() && j<B.size()) {
			
			if(A.get(i).intValue() == B.get(j).intValue()) {
				result.add(A.get(i));
				i++;
				j++;
			}
			else if(A.get(i).intValue()>B.get(j).intValue()) {
				j++;
			}
			else
				i++;
		}
		
		return result;
	
	}
}
