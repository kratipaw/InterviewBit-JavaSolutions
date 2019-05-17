import java.util.ArrayList;
import java.util.Collections;

public class TripletsWithSumBtwRange {

	public static void main(String[] args) {

		ArrayList<String> A = new ArrayList<String>();
		A.add("0.6");
		//A.add("0.7");
		A.add("1.2");
		A.add("0.4");
		//A.add("0.7");
		
		System.out.println(solve(A));
		
	}

	private static int solve(ArrayList<String> A) {
    
		ArrayList<Double> list = new ArrayList<Double>();
		
		for (int i = 0; i < A.size(); i++) {
			list.add(Double.parseDouble(A.get(i)));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size() - 2; i++) {
			
			Double fix = list.get(i);
			
			int start = i + 1;
			int end = list.size()-1;
			
			while(start<end) {
				
				if(1 <= list.get(start) + list.get(end) + fix && list.get(start) + list.get(end) + fix <= 2)
					return 1;
				else if(1 > list.get(start) + list.get(end) + fix)
					start = start + 1;
				else if(2 < list.get(start) + list.get(end) + fix)
					end = end - 1;
			}
		}
		
		return 0;
	}
}
