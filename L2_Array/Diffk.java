package L2_Array;

import java.util.ArrayList;

public class Diffk {

	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(3);
		A.add(5);
		
		int B = 2;
		
		System.out.println(diffPossible(A, B));

	}

	private static int diffPossible(ArrayList<Integer> A, int B) {
    
		for (int i = 0; i < A.size()-1; i++) {
			for (int j = i+1; j < A.size(); j++) {
				if(Math.abs(A.get(i).intValue()-A.get(j).intValue()) == B)
					return 1;
			}
		}
	
		return 0;
	}
}
