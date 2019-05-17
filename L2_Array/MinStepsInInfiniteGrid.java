import java.util.ArrayList;

public class MinStepsInInfiniteGrid {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(4);
		A.add(1);
		A.add(4);
		A.add(10);
		
		ArrayList<Integer> B = new ArrayList<>();
		
		B.add(6);
		B.add(2);
		B.add(5);
		B.add(12);
		
		System.out.println(coverPoints(A, B));
		
	}
	
	private static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
    
		int a = A.size();
		
		int b = A.size();
		
		if(a != b)
			return -1;
		
		int min = 0;
		
		for (int i = 0; i < a - 1; i++) {
			
			int x = Math.abs(A.get(i) - A.get(i + 1));
			
			int y = Math.abs(B.get(i) - B.get(i + 1));
			
			int path = Math.max(x, y);
			
			min = min + path;
			
		}
		
		return min;
	
	}

}
