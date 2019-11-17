import java.util.ArrayList;

public class MatrixSearch {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(1);
		row.add(3);
		row.add(5);
		row.add(7);
		a.add(row);
		
		row = new ArrayList<Integer>();
		row.add(10);
		row.add(11);
		row.add(16);
		row.add(20);
		a.add(row);
		
		row = new ArrayList<Integer>();
		row.add(23);
		row.add(30);
		row.add(34);
		row.add(50);
		a.add(row);
		
		int b = 55;
		
		System.out.println(searchMatrix(a, b));
		
	}

	private static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
    
		
		int rows = a.size();
		
		if(rows == 0)
			return 0;
		
		int cols = a.get(0).size();
		
		for (int i = 0; i < rows ; i++) {
			
			ArrayList<Integer> arr = a.get(i);
			
			if(arr.get(0)<= b && b<=arr.get(cols-1)) {
			
				int start = 0;
				int end = cols - 1;
				
				while(start<=end) {
					
					int mid = start + (end-start)/2;
					
					if(arr.get(mid) == b)
						return 1;
					else if(arr.get(mid)<b)
						start = mid+1;
					else
						end = mid-1;
					
				}
			}
		}
		
		return 0;
	}
	
	public int searchMatrix_better(ArrayList<ArrayList<Integer>> a, int b) {
		
		int rows = a.size();

		int cols = a.get(0).size();

		int row = rows - 1;

		int col = 0;

		while(row >= 0 && col < cols) {

		    if(a.get(row).get(col) > b)
			row--;

		    else if(a.get(row).get(col) < b)
			col++;

		    else if(a.get(row).get(col) == b)
			return 1;

		}

		return 0;
    }
}
