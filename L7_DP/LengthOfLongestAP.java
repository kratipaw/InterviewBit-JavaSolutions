import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Find longest Arithmetic Progression in an integer array and return its length. More formally, find longest sequence of indeces, 0 < i1 < i2 < … < ik < ArraySize(0-indexed) such that sequence A[i1], A[i2], …, A[ik] is an Arithmetic Progression. Arithmetic Progression is a sequence in which all the differences between consecutive pairs are the same, i.e sequence B[0], B[1], B[2], …, B[m - 1] of length m is an Arithmetic Progression if and only if B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2].
Examples
1) 1, 2, 3(All differences are equal to 1)
2) 7, 7, 7(All differences are equal to 0)
3) 8, 5, 2(Yes, difference can be negative too)

Samples
1) Input: 3, 6, 9, 12
Output: 4

2) Input: 9, 4, 7, 2, 10
Output: 3(If we choose elements in positions 1, 2 and 4(0-indexed))

 * 
 */
public class LengthOfLongestAP {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>();
		A.add(100);
		A.add(10);
		A.add(8);
		A.add(300);
		A.add(6);
		A.add(1);
		A.add(4);
		A.add(2);
		
		System.out.println(new LengthOfLongestAP().solve(A));

	}

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        
        if(A == null)
            return 0;
        
        int n = A.size();
        
        if(n <= 2)
            return n;
        
        ArrayList<Integer> tmp = new ArrayList<Integer>(A);
        Collections.sort(tmp);
        
        //dp[i][j] is length of longest AP with arr[i] & arr[j] 
        //as first two elements of AP and j > i
        int dp[][] = new int[n][n];
        
        int len = 2;
        
        //AP with last element of arr as second element in AP will have length of 2.
        for (int i = 0; i < n; i++) {
            dp[i][n - 1] = 2;
        }
        
        //j is middle element of AP
        for (int j = n - 2; j > 0; j--) {
            
            int i = j - 1; //i smaller than j
            int k = j + 1; // k greater than j
            
            while(i >= 0 && k < n) {
                
                if(tmp.get(i) + tmp.get(k) < 2 * tmp.get(j))
                    k++;
                else if(tmp.get(i) + tmp.get(k) > 2 * tmp.get(j))
                    dp[i--][j] = 2;
                else
                {
                    dp[i][j] = dp[j][k] + 1;
                    
                    len = Math.max(len, dp[i][j]);
                    
                    i--;
                    k++;
                }
            }
            
            while(i >= 0) {
                dp[i][j] = 2;
                i--;
            }
        }
        
        return len;
    }
}
