package L7_DP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
	You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.
	
	Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).
	
	Example :
	
	Input : 
		S = [1, 2, 3] 
		N = 4
	
	Return : 4
	
	Explanation : The 4 possible ways are
	{1, 1, 1, 1}
	{1, 1, 2}
	{2, 2}
	{1, 3}	
	
	Note that the answer can overflow. So, give us the answer % 1000007

 * 
 */
public class CoinSumInfinite {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(3);
		
		int B = 4;
		
		System.out.println(new CoinSumInfinite().coinchange2(A, B));
	}

	public int coinchange2(ArrayList<Integer> A, int B) {
    
		if(A == null || A.size() == 0)
            return 0;
        
        if(B == 0)
            return 1;
        
        int n = A.size();
        
        int[] dp = new int[B + 1]; //dp[i] stores num of ways to get sum i.
        Arrays.fill(dp, 0);
        
        dp[0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = A.get(i); j <= B ; j++) {
                dp[j] = (dp[j] + dp[j - A.get(i)]) % 1000007;
            }
        }
        
        return dp[B];
	}
	
}
