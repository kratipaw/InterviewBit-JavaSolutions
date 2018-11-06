package L2_Math;

public class TrailingZerosInFactorial {

	public static void main(String[] args) {

		int A = 2147483647;
		
		System.out.println(trailingZeroes(A));
		
	}
	
	private static int trailingZeroes(int A) {
        
		int count = 0;
		
        for (int i = 5; A/i >= 1; i = i * 5) {
			
        	count = count + (A/i);
		}
        
        return count;
      
    }

}
