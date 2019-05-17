import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(2);
		A.add(1);
		A.add(4);
		A.add(3);
		//A.add(5);
		
		ArrayList<Integer> res = wave(A);
		
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + "  ");
		}
	}
	
	private static ArrayList<Integer> wave(ArrayList<Integer> A) {
    
		ArrayList<Integer> result = new ArrayList<>();
		
		Collections.sort(A);
		
		for (int i = 0; i < A.size()-1; i=i+2) {
			int temp = A.get(i);
			result.add(A.get(i+1));
			result.add(temp);
		}
		
		if(A.size()%2!=0)
			result.add(A.get(A.size()-1));
		
		return result;
	}

}
