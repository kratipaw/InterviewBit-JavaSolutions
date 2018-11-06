package L2_Array;

import java.util.ArrayList;
import java.util.Collections;

public class SpiralOrderMatrixTwo {

	public static void main(String[] args) {

		
		int A = 3;
		
		ArrayList<ArrayList<Integer>> result = generateMatrix(A);
		
		printMatrix(result);
		
	}
	
	private static void printMatrix(ArrayList<ArrayList<Integer>> a) {
		
		int m = a.size();
		
		int n = a.get(0).size();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a.get(i).get(j) + "\t");
			}
			System.out.println();
		}
		
	}

	private static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < A; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(Collections.nCopies(A, 0));
			matrix.add(temp);
		}
		
		
		int top = 0;
		int bottom = A - 1;
		int left = 0;
		int right = A - 1;
		
		int k = 1;
		
		while(k <= A * A) {
			
			for(int i=left; i<=right; i++){
				
				matrix.get(top).set(i, k);
	            k++;
	        }    
	        top++;
	        
	        for(int i=top; i<=bottom; i++){
	        	
	        	matrix.get(i).set(right, k);
	            
	            k++;
	        }
	        right--;
	 
	        for(int i=right; i>=left; i--){
	        	
	        	matrix.get(bottom).set(i, k);
	            k++;
	        }
	        bottom--;
	 
	        for(int i=bottom; i>=top; i--){
	            matrix.get(i).set(left, k);
	            k++;
	        }
	        left++;
			
		}
		
		return matrix;
    }
	
}
