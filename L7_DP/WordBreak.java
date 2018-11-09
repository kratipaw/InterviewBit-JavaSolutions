package L7_DP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  
	Given a string s and a dictionary of words dict, determine if s can be segmented 
	into a space-separated sequence of one or more dictionary words.
	
	For example, given
	
	s = "myinterviewtrainer",
	dict = ["trainer", "my", "interview"].
	
	Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as
	"my interview trainer".
	
	Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 */

public class WordBreak {

	public static void main(String[] args) {

		ArrayList<String> wordDict = new ArrayList<>();
		wordDict.add("trainer");
		wordDict.add("my");
		wordDict.add("interview");
		
		String s = "myinterviewtrainer";
		
		System.out.println(new WordBreak().wordBreak(s, wordDict));
		
	}
	
	public int wordBreak(String A, ArrayList<String> B) {
		
		int n = A.length();
		
		if(n == 0)
			return 1;
		
		int dp[] = new int[n + 1];
		
		Arrays.fill(dp, 0);
		
		dp[0] = 1; //Here dp[i] is true if 's' can be broken into parts 0-i & i-1 and both the sub-strings present in dict 
		
		for (int i = 0; i < n; i++) {
			
			if(dp[i] == 0)
				continue;
			
			for(String word : B) {
				
				int len = word.length();
				
				int end = i + len;
				
				if(end > n)
					continue;
				
				if(dp[end] == 1)
					continue;
				
				if(A.substring(i, end).equals(word))
					dp[end] = 1;
			}
		}
		
		return dp[n];
	}
}
