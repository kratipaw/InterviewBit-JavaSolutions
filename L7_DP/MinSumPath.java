import java.util.ArrayList;

public class MinSumPath {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row = new ArrayList<>();
		
		/*row.add(1);
		row.add(3);
		row.add(2);*/
		
		row.add(71);
 		
		A.add(row);
		
		row = new ArrayList<Integer>();
		/*row.add(4);
		row.add(3);
		row.add(1);
		*/
		
		row.add(8);
		A.add(row);
		
		row = new ArrayList<Integer>();
		/*row.add(5);
		row.add(6);
		row.add(1);
		*/
		
		row.add(70);
		A.add(row);
		
		row = new ArrayList<Integer>();
		row.add(61);
		A.add(row);
		
		MinSumPath min = new MinSumPath();
		
		System.out.println(min.minPathSum(A));
		
	}

	public int minPathSum(ArrayList<ArrayList<Integer>> A) {
    
		int row = A.size();
		
		if(row == 0)
			return 0;
		
		int col = A.get(0).size();
		
		if(col == 0)
			return 0;
		
		int dp[][] = new int[row][col];
	
		dp[0][0] = A.get(0).get(0);
		
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i-1][0] + A.get(i).get(0);
		}
		
		for (int i = 1; i < col ; i++) {
			dp[0][i] = dp[0][i-1] + A.get(0).get(i);
		}
		
		for (int i = 1; i < row; i++) {
			
			for (int j = 1; j < col; j++) {
				
				dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + A.get(i).get(j);
					
			}
		}
		
		return dp[row -1][col - 1];
	}
}
