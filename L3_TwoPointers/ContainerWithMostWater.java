package L3_TwoPointers;

import java.util.ArrayList;

public class ContainerWithMostWater {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		
		System.out.println(maxArea(A));
		
	}
	
	private static int maxArea(ArrayList<Integer> A) {
		
		int n = A.size() - 1;
		
		if(n < 0)
			return 0;
		
		int s = 0;
		
		int area = 0;
		
		while(s < n) {
			
			int tempArea = Math.min(A.get(s).intValue(), A.get(n).intValue()) * (n-s);
			
			area = Math.max(area, tempArea);
			
			if(A.get(s)<A.get(n))
				s++;
			else
				n--;
			
		}
		
		return area;
		
    }

}
