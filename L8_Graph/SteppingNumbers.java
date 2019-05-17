import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Given N and M find all stepping numbers in range N to M

	The stepping number:
	
	A number is called as a stepping number if the adjacent digits have a difference of 1.
	e.g 123 is stepping number, but 358 is not a stepping number
	
	Example:
	
	N = 10, M = 20
	All stepping numbers are 10 , 12 
	
	Return the numbers in sorted order.
	
 */

public class SteppingNumbers {

	public static void main(String[] args) {

		int n = 0;
		
		int m = 21;
		
		displaySteppingNums(n, m);
		
		ArrayList<Integer> result = new SteppingNumbers().stepnum(n, m);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + "  ");
		}
		
		System.out.println();
		
		ArrayList<Integer> result_dfs = new SteppingNumbers().stepnum_dfs(n, m);
		
		for (int i = 0; i < result_dfs.size(); i++) {
			System.out.print(result_dfs.get(i) + "  ");
		}
	}

	//Brute Force
	private static void displaySteppingNums(int n, int m) {
		
		for (int i = n; i <= m; i++) {
			if(isStepping(i))
				System.out.print(i + "  ");
		}
		
		System.out.println();
	}
	
	private static boolean isStepping(int num) {
		
		int prev = -1;
		
		while(num > 0) {
			
			int curr = num % 10;
			
			if(prev != -1) {
				if(Math.abs(prev - curr) != 1)
					return false;
			}
			
			prev = curr;
			
			num = num / 10;
		}
		
		return true;
	}
	
	//Graph : BFS Traversal
	public ArrayList<Integer> stepnum(int A, int B) {
    
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 0; i <= 9; i++) {
			bfsUtil(A, B, i, result);
		}
		
		Collections.sort(result);
		return result;
	}
	
	private void bfsUtil(int A, int B, int i, ArrayList<Integer> result) {
		
		Queue<Integer> qu = new LinkedList<>();
		
		qu.add(i);
		
		while(!qu.isEmpty()) {
			
			int num = qu.poll();
			
			if(num >= A && num <= B)
				result.add(num);
			
			if(num == 0 || num > B)
				continue;
			
			int lastDigit = num % 10;
			
			int left = num * 10 + lastDigit - 1;
			
			int right = num * 10 + lastDigit + 1;
			
			if(lastDigit == 0)
				qu.add(right);
			
			else if(lastDigit == 9)
				qu.add(left);
			
			else {
				qu.add(left);
				qu.add(right);
			}
		}
	}
	
	public ArrayList<Integer> stepnum_dfs(int A, int B) {
	    
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 0; i <= 9; i++) {
			dfsUtil(A, B, i, result);
		}
		
		Collections.sort(result);
		
		return result;
	}
	
	private void dfsUtil(int A, int B, int i, ArrayList<Integer> result) {
		
		if(i >= A && i <= B)
			result.add(i);
		
		if(i == 0 || i > B)
			return;
		
		int lastDigit = i % 10;
		
		int left = i * 10 + lastDigit - 1;
		
		int right = i * 10 + lastDigit + 1;
		
		if(lastDigit == 0)
			dfsUtil(A, B, right, result);
		
		else if (lastDigit == 9)
			dfsUtil(A, B, left, result);
		
		else {
			dfsUtil(A, B, left, result);
			dfsUtil(A, B, right, result);
		}
	}
}
