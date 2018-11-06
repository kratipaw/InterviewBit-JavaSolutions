package L2_Math;

public class GridUniquePaths {

	public static void main(String[] args) {

		int A = 2;
		
		int B = 2;
		
		GridUniquePaths grd = new GridUniquePaths();
		
		System.out.println(grd.uniquePaths(A, B));
		
	}
	
	public int uniquePaths(int A, int B) {
        
		if(A == 0 || B == 0)
			return 1;
		
        int dp[][] = new int[A][B];
        
        for (int i = 0; i < A; i++) {
			dp[i][0] = 1;
		}
        
        for (int i = 0; i < B; i++) {
			dp[0][i] = 1;
		}
        
        for (int i = 1; i < A; i++) {
			for (int j = 1; j < B; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
        
        return dp[A -1][B - 1];
    }

}
