import java.util.ArrayList;
import java.util.Collections;

public class RotateMatrix {


	public static void main(String[] args) {

		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(1);
		row1.add(2);
		//row1.add(3);
		
		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(4);
		row2.add(5);
		//row2.add(6);
		
		/*ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(7);
		row3.add(8);
		row3.add(9);*/
		/*
		ArrayList<Integer> row4 = new ArrayList<>();
		row4.add(10);
		row4.add(11);
		row4.add(12);*/
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(row1);
		a.add(row2);
		//a.add(row3);
		//a.add(row4);
		
		displayMatrix(a);
		
		System.out.println("Rotated matrix by 90` clockwise : ");
		
		rotate(a);
		displayMatrix(a);
 	}
	
	private static void displayMatrix(ArrayList<ArrayList<Integer>> a) {
		
		int row = a.size();
		int col = a.get(0).size();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(a.get(i).get(j) + "\t");
			}
			
			System.out.println();
		}
	}

	private static void rotate(ArrayList<ArrayList<Integer>> a) {
		int n = a.size() -1;
		
		for (int i = 0; i <= n/2; i++) {
			for (int j = i; j < n-i; j++) {
				
				int top = a.get(i).get(j);
				System.out.println("top :: " + top);
				int right = a.get(j).get(n-i);
				
				int bottom = a.get(n-i).get(n-j);
				
				int left = a.get(n-j).get(i);
				
				a.get(j).set(n-i, top);
				
				a.get(n-i).set(n-j, right);
				
				a.get(n-j).set(i, bottom);
				
				a.get(i).set(j, left);
				
				System.out.println(a.get(i).get(j));
				
				
				
				
				
			}
		}
	}
	
	/*
	private static void rotate(ArrayList<ArrayList<Integer>> a) {
		
		
		transpose(a);
		System.out.println("after transpose :: ");
		displayMatrix(a);
		System.out.println("after reverse :: ");
		reverseRow(a);
		
	}*/
	
	private static void transpose(ArrayList<ArrayList<Integer>> a) {
		
		int row = a.size();
		
		int col = a.get(0).size();
		
		for (int i = 0; i < row; i++)
            for (int j = i; j < col; j++)
            {  
                int temp = a.get(j).get(i);
                a.get(j).set(i, a.get(i).get(j));
                a.get(i).set(j, temp);
            }
		
	}
	
	private static void reverseRow(ArrayList<ArrayList<Integer>> a) {
		
		int row = a.size();

		for (int i = 0; i < row; i++) {
			Collections.reverse(a.get(i));
		}
	}
}
