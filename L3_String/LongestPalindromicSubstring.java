package L3_String;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		//String A = "aaaabaaa";
		
		String A = "A:b:b";
		
		System.out.println(longestPalindrome(A));
	}
	
	private static String longestPalindrome(String A) {
    
		int n = A.length();
		
		if(n == 0 || n == 1)
			return A;
		
		int maxLen = 0;
		
		int start = 0;
		
		boolean dp[][] = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = false;
			}
		}
		
		//Substrings of length 1 are palindromes
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
	 
		maxLen = 1;
		
		//Substrings of len 2 
		for (int i = 0; i < n-1; i++) {
			
			if(A.charAt(i) == A.charAt(i+1)) {
				dp[i][i+1] = true;
				start = i;
				maxLen = 2;
			}
		}
		
		//Substrings of len greater than 2 till n
		for (int i = 3; i <= n; i++) {
			
			for (int j = 0; j < n - i + 1; j++) {
				
				int k = j + i -1;
				
				if(dp[j+1][k-1] && A.charAt(j) == A.charAt(k)) {
					
					dp[j][k] = true;
					
					if(i > maxLen) {
						start = j;
						maxLen = i;
					}
				}
				
			}
			
		}
		
		return A.substring(start, start + maxLen);
	}

}
