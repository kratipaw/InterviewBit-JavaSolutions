package hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example:
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestSubStringWORepeat {

	public static void main(String[] args) {

		String A = "bbbbbbb";
		
		System.out.println(lengthOfLongestSubstring(A));
		
		String B = "abbbbabb";
		
		System.out.println(lengthOfLongestSubstring(B));
	}

	private static int lengthOfLongestSubstring(String A) {
		
		if(A == null || A.isEmpty() || A.length() == 0)
			return 0;
		
		int n = A.length();
		
        Set<Character> set = new HashSet<>();
        
        int result = 0, i = 0, j = 0;
        
        while (i < n && j < n) {
        		
        		char ch = A.charAt(j);
        	
            if (!set.contains(ch)){
                set.add(ch);
                j++;
                result = Math.max(result, j - i);
            }
            else {
                set.remove(A.charAt(i++));
            }
        }
        
        return result;
	}
}
