import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find the length of longest subsequence which is 
 * first increasing then decreasing.
 *
 **Example: **
 *
 *	For the given array [1 11 2 10 4 5 2 1]
 *
 *	Longest subsequence is [1 2 10 4 2 1]
 *
 *	Return value 6
 */

public class LengthOfLongestSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        
        if(A == null || A.size() == 0)
            return 0;
            
        int n = A.size();
        
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(A.get(i) > A.get(j) && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }
        
        //Longest Decreasing Subsequence
        int lds[] = new int[n];
        Arrays.fill(lds, 1);
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if(A.get(i) > A.get(j) && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(lis[i] + lds[i] - 1 > max)
                max = lis[i] + lds[i] - 1;
        }
        return max;
    }
}
