package L2_Array;

import java.util.ArrayList;

public class PascalsTriangle {

	public static void main(String[] args) {

		int A = 9;
		/*
		ArrayList<ArrayList<Integer>> result = solve(A);
		
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> row = result.get(i);
			int n = row.size();
			
			for (int j = 0; j < n; j++) {
				System.out.print(row.get(j) + "  ");
			}
			
			System.out.println();
		}*/
		
		
		ArrayList<Integer> row = getRow(A);
		
		for (int i = 0; i < row.size(); i++) {
			System.out.print(row.get(i) + "  ");
		}
		
	}

	private static  ArrayList<ArrayList<Integer>> solve(int A) {
    
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(A==0)
			return result;
		
		ArrayList<Integer> row = new ArrayList<>();
		row.add(1);
		result.add(row);
		
		for (int i = 1; i < A; i++) {
			
			row = new ArrayList<Integer>();
			row.add(1);
			
			for (int j = 1; j < i; j++) {
				
				int num = result.get(i-1).get(j-1)+ result.get(i-1).get(j);
				row.add(num);
			}
			row.add(1);
			result.add(row);
		}
		
		return result;
	}
	
	private static ArrayList<Integer> getRow(int A) {
    
		ArrayList<Integer> row = new ArrayList<>();
		
		row.add(1);
		
		ArrayList<Integer> prev = new ArrayList<>();
		prev = row;
		
		if(A==0)
			return row;
		
		for (int i = 1; i <= A; i++) {
			
			row = new ArrayList<>();
			row.add(1);
			for (int j = 1; j < i; j++) {
				int num = prev.get(j-1) + prev.get(j);
				row.add(num);
			}
			row.add(1);
			prev = new ArrayList<>();
			prev = row;
		}
		
		return row;
	}
}
