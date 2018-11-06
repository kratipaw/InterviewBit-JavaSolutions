package L5_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationalSum {

	public static void main(String[] args) {

		int arr[] = {2 , 4, 6, 8};
		
		int sum = 8;
		
		ArrayList<ArrayList<Integer>> result = combosSum(arr, sum);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	private static ArrayList<ArrayList<Integer>> combosSum(int arr[], int sum){
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		int n = arr.length;
		
		if(n == 0)
			return result;
		
		Arrays.sort(arr);
		
		//Remove Dups
		int j = 0;
		
		arr[j] = arr[0];
		
		for (int i = 1; i < n; i++) {
			if(arr[i] != arr[i - 1]) {
				j++;
				arr[j] = arr[i];
			}
		}
		
		ArrayList<Integer> sub = new ArrayList<Integer>();
		
		findCombos(arr, sum, result, sub, 0);
		
		return result;
	}
	
	private static void findCombos(int arr[], int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> sub, int start) {
		
		/*if(sum < 0)
			return;
		
		if(sum == 0) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(sub);
			result.add(tmp);
			return;
		}
		
		while(start < arr.length && sum - arr[start] >= 0) {
			
			sub.add(arr[start]);
			
			findCombos(arr, sum - arr[start], result, sub, start);
			
			start++;
			
			sub.remove(sub.size() - 1);
			
		}*/
		
		if(sum == 0) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(sub);
			result.add(tmp);
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			
			if(sum < arr[i])
				return;
			
			sub.add(arr[i]);
			
			findCombos(arr, sum - arr[i], result, sub, i);
			
			sub.remove(sub.size() - 1);
		}
		
	}
}
