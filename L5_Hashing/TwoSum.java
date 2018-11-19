package L5_Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		/*
		A.add(7);
		A.add(2);
		A.add(11);
		A.add(15);
		*/
		
		
		A.add(7);
		A.add(2);
		A.add(2);
		A.add(2);
		A.add(3);
		A.add(-5);
		A.add(-3);
		
		int B = -3;
		
		
		ArrayList<Integer> result = twoSum(A, B);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + "  ");
		}
		System.out.println();
	}

	private static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
    
		ArrayList<Integer> result = new ArrayList<>();
		
		int n = A.size();
		
		if(n < 2)
			return result;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		
		for (int i = n - 1; i >= 0; i--) {
			
			int num = A.get(i);
			int diff = B - num;
			
			if(map.containsKey(diff)) {
				int idx = map.get(diff);
				pairs.add(new Pair(i + 1, idx));
			}
			
			map.put(num, i + 1);
			
		}
		
		 for (Map.Entry<Integer,Integer> entry : map.entrySet())  
	            System.out.println("Key = " + entry.getKey() + 
	                             ", Value = " + entry.getValue());
		
		
		
		if(pairs.size() > 0) {
			Collections.sort(pairs);
			
			for (int i = 0; i < pairs.size(); i++) {
				System.out.println(pairs.get(i).toString());
			}
			
			result.add(pairs.get(0).x);
			result.add(pairs.get(0).y);
		}
		
		return result;
	}
	
}

class Pair implements Comparable<Pair>{
	
	int x;
	int y;
	
	public Pair(int x, int y) {

		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.y < o.y)
            return -1;
        if (this.y > o.y)
            return 1;
            
        return Integer.compare(this.x, o.y);
	}
	
	@Override
	public String toString() {
		return "[ " + x + ", " + y + " ]";
	}
	
}
