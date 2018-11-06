package L5_Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationsTwo {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		
		a.add(10);
		a.add(1);
		a.add(2);
		a.add(7);
		a.add(6);
		a.add(1);
		a.add(5);
		
		int b = 8;
		
		ArrayList<ArrayList<Integer>> result = combinationSum(a, b);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
		
	}
	
	private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
    
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		int n = a.size();
		
		if(n == 0)
			return result;
		
		Collections.sort(a);
		
		ArrayList<Integer> curr = new ArrayList<>();
		
		dfs(a, b, 0, curr, result);
		
		return result;
	}

	private static void dfs(ArrayList<Integer> a, int b, int start, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result) {
		
		if(b == 0) {
			ArrayList<Integer> tmp = new ArrayList<>(curr);
			result.add(tmp);
			return;
		}
		
		if(b < 0)
			return;
		
		int prev = -1;
		for (int i = start; i < a.size(); i++) {
			if(prev!=a.get(i)){ // each time start from different element
	            curr.add(a.get(i));
	            dfs(a, b - a.get(i), i + 1, curr, result);
	            curr.remove(curr.size()-1);
	            prev=a.get(i);
	        }
		}
		
	}
}
