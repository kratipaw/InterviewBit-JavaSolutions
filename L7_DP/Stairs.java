package L7_DP;

public class Stairs {

	public static void main(String[] args) {

		System.out.println(climbStairs(4));
		
	}

	private static int climbStairs(int A) {
    
		if(A == 0 || A == 1)
			return 1;
		
		int dp[] = new int[A+1];
		
		dp[0] = 1;
		
		dp[1] = 1;
		
		dp[2] = 2;
		
		for (int i = 3; i <= A ; i++) 
			dp[i] = dp[i - 1] + dp[i - 2];
	
		return dp[A];
	}
}
