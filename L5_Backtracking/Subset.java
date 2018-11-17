package L5_Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

	public static void main(String[] args) {

		int arr[] = {1, 2, 3};
		
		System.out.println("Iterative - All subsets");
		subsets_iterative(arr);
		
		System.out.println("Backtracking - All subsets");
		subsets_bt(arr);
		
	}
	
	//TC = O(n * 2^n)
	private static void subsets_iterative(int arr[]) {
		
		int n = arr.length;
		
		if(n == 0)
			return;
		
		int subsetsSize = (int) Math.pow(2, n);
		
		for (int i = 0; i < subsetsSize; i++) {
			
			for (int j = 0; j < n; j++) {
				
				int mask = 1 << j;
				
				if((i & mask) != 0)
					System.out.print(arr[j] + "  ");
				
			}
			
			System.out.println();
		}
		
	}
	
	//TC = O(2^n)
	private static void subsets_bt(int arr[]) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> subset = new ArrayList<Integer>();
		
		result.add(subset);		
		
		subsetsUtil(arr, result, subset, 0);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
		
	}
	
	private static void subsetsUtil(int arr[], ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int start) {
		//System.out.println("call start : " + start);
		for (int i = start; i < arr.length; i++) {
			//System.out.println("call start :: " + start + "////////// i          ::" + i);
			subset.add(arr[i]);
			ArrayList<Integer> tmp = new ArrayList<Integer>(subset);
			//System.out.println("tmp -------------------------------------------- " + tmp.toString());
			result.add(tmp);
			
			subsetsUtil(arr, result, subset, i + 1);
			
			//backtracking
			subset.remove(subset.size() - 1);
			
		}
		
	}
	
	private static ArrayList<ArrayList<Integer>> subsets_bt_IB(ArrayList<Integer> A) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> subset = new ArrayList<Integer>();
		
		result.add(subset);	
		
		if(A == null || A.isEmpty() || A.size() == 0)
        	return result;
		
        Collections.sort(A);
        
		subsetsUtil_IB(A, result, subset, 0);
		
		return result;
	}
	
	private static void subsetsUtil_IB(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int start) {

		for (int i = start; i < A.size(); i++) {

			subset.add(A.get(i));
			
			ArrayList<Integer> tmp = new ArrayList<Integer>(subset);

			result.add(tmp);
			
			//recursion
			subsetsUtil_IB(A, result, subset, i + 1);
			
			//backtracking
			subset.remove(subset.size() - 1);
			
		}
		
	}

}
