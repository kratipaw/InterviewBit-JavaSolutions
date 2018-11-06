package L2_Array;

import java.util.ArrayList;

public class SetMatrixZeros {

	public static void main(String[] args) {

		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row = new ArrayList<>();
		row.add(1);
		row.add(0);
		row.add(0);
		row.add(1);
		
		a.add(row);
		
		row = new ArrayList<Integer>();
		row.add(0);
		row.add(0);
		row.add(1);
		row.add(0);
		
		a.add(row);
		
		row = new ArrayList<Integer>();
		row.add(0);
		row.add(0);
		row.add(0);
		row.add(0);
		
		a.add(row);
		
		System.out.println("Original  : " );
		printMatrix(a);;
		
		setZeroes(a);
		
		System.out.println("Modified : ");
		printMatrix(a);
		
		
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
	
	private static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		
		if(a.size() == 0)
			return;
		
		int m = a.size();
		
		int n = a.get(0).size();
		
		boolean firstRow = false;
        boolean firstCol = false;
 
        for(int i=0; i<m; i++){
            if(a.get(i).get(0) == 0){
            	firstCol = true;
                break;
            }
        }
 
        for(int i=0; i<n; i++){
            if(a.get(0).get(i) == 0){
            	firstRow = true;
                break;
            }
        }
 
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
            	
                if(a.get(i).get(j) == 0){
                
                	a.get(i).set(0, 0);
                	a.get(0).set(j, 0);
                }
            }
        }
 
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                
            	if(a.get(i).get(0) == 0 || a.get(0).get(j) == 0){
                	
                   a.get(i).set(j, 0);
                }
            }
        }
 
        if(firstCol){
            for(int i=0; i<m; i++)
                a.get(i).set(0, 0);
        }
 
        if(firstRow){
            for(int i=0; i<n; i++)
                a.get(0).set(i, 0);
        }
		
    }

}
