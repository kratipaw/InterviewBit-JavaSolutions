package L7_Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class AssignMiceToHoles {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(4);
		A.add(-4);
		A.add(2);
		
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(4);
		B.add(0);
		B.add(5);
		
		System.out.println(mice(A, B));
		
	}

	private static int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		int max = 0;
		
		Collections.sort(A);
		
		Collections.sort(B);
		
		int n = A.size();
		
		for (int i = 0; i < n; i++) {
			
			int tmp = Math.abs(A.get(i) - B.get(i));
			
			if(max < tmp)
				max = tmp;
			
		}
		
		return Math.abs(max);
    }
}
