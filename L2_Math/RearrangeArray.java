package L2_Math;

import java.util.ArrayList;

public class RearrangeArray {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		
		a.add(1);
		a.add(0);
		a.add(3);
		a.add(2);
		
		arrange(a);
	
		System.out.println(a.toString());
		
	}
	

	private static void arrange(ArrayList<Integer> a) {
		
		int n = a.size();
		
		if(n == 0 || n == 1)
			return;
		
		for (int i = 0; i < n; i++) {
			
			int num = a.get(i);
			
			int temp = a.get(num) % n;
			
			int newValue = num + temp * n;
			
			a.set(i, newValue);
		}

		
		for (int i = 0; i < n; i++) {
			a.set(i, a.get(i)/n);
		}
		
    }
}
