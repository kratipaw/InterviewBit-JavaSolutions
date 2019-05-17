import java.util.Arrays;
import java.util.List;

public class LongestIncreasingsubsequence {

	public static void main(String[] args) {
		

	}
	
	public int lis(final List<Integer> A) {
        
        int n = A.size();
        
        int LIS[] = new int[n];
        
        Arrays.fill(LIS, 1);
        
        int maxLen = 0;
        
        for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(A.get(i) > A.get(j) && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}
        
        for (int i = 0; i < LIS.length; i++) {
			if(LIS[i]>maxLen)
				maxLen = LIS[i];
		}
        
        return maxLen;
    }

}
