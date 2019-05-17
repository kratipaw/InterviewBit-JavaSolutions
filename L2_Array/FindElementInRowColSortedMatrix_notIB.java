public class FindElementInRowColSortedMatrix_notIB {

	public static void main(String[] args) {

		int mat[][] = { {10, 20, 30, 40}, 
                {15, 25, 35, 45}, 
                {27, 29, 37, 48}, 
                {32, 33, 39, 50} };
		
		System.out.println(search(mat, 4, 4, 27));
	}
	
	private static boolean search(int matrix[][], int rows, int cols, int x) {
		
		int i = 0;
		
		int j = cols - 1;
		
		while(i < rows && j >= 0) {
			
			if(matrix[i][j] == x) {
				System.out.println("Position is : [" + i + ", " + j + "]");
				return true;
			}
			
			else if (x > matrix[i][j])
				i++;
			
			else
				j--;
		}
		
		return false;
	}

}
