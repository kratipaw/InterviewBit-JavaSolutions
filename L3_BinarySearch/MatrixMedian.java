import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MatrixMedian {

	public static void main(String[] args) {
		
		
		int arr[] = {2, 3, 5, 7, 9};
		
		System.out.println(Arrays.binarySearch(arr, 6));

		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row = new ArrayList<>();
		row.add(1);
		row.add(3);
		row.add(5);
		
		A.add(row);
		
		row = new ArrayList<>();
		row.add(2);
		row.add(6);
		row.add(9);
		
		A.add(row);
		
		row = new ArrayList<>();
		row.add(3);
		row.add(6);
		row.add(9);
		
		A.add(row);
		
		System.out.println(findMedian(A));
		
	}
	
	private static int findMedian(ArrayList<ArrayList<Integer>> A) {
		
		int rows = A.size();
		
		if(rows == 0)
			return -1;
		
		int cols = A.get(0).size();
		
		int max = Integer.MIN_VALUE; 
        int min = Integer.MAX_VALUE; 
        
        for(int i=0; i<rows ; i++) { 
        	
            if(A.get(i).get(0) < min) 
                min = A.get(i).get(0); 
              
            if(A.get(i).get(cols - 1) > max) 
                max = A.get(i).get(cols - 1); 
        } 
          
        int reqCount = (rows * cols + 1) / 2;
        
        while(min < max) 
        { 
            int mid = min + (max - min) / 2; 
            int countOfNumsLessThanMid = 0; 
            int idx = 0; 
              
            for(int i = 0; i < rows; ++i) 
            { 
            	idx = Collections.binarySearch(A.get(i),mid); 
                
                if(idx < 0) 
                	idx = Math.abs(idx) - 1; 
                  
                else
                { 
                    while(idx < A.get(i).size() && A.get(i).get(idx) == mid) 
                    	idx = idx + 1; 
                } 
                  
                countOfNumsLessThanMid = countOfNumsLessThanMid + idx; 
            } 
              
            if (countOfNumsLessThanMid < reqCount) 
                min = mid + 1; 
            else
                max = mid; 
        } 
        
        return min; 
	}

}
