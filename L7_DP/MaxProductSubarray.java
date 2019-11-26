package L7_DP;

/*

Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible.

Example :

Input : [2, 3, -2, 4]
Return : 6 

Possible with [2, 3]

*/

public class MaxProductSubarray {

// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> A) {
        
        int result = A.get(0);
        
        int min = A.get(0);
        
        int max = A.get(0);
        
        int n = A.size();
        
        for(int i = 1; i < n; i++) {
            
            if(A.get(i) < 0) {
                int tmp = max;
                max = min ;
                min = tmp;
            }
            
            max = Math.max(A.get(i), max * A.get(i));
            min = Math.min(A.get(i), min * A.get(i));
            
            result = Math.max(result, max);
        }
        
        return result;
        
    }

}
