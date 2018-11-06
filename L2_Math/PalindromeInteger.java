package L2_Math;

public class PalindromeInteger {

	public static void main(String[] args) {

		int A = 2147483647;
		
		System.out.println(isPalindrome(A));
	}

	private static int isPalindrome(int A) {
    
		if(A<0)
			return 0;
		
		/*int divisor = 1;
		
		while(A/10>=10) {
			divisor = divisor * 10; 
		}
		System.out.println(divisor);
		while(A!=0) {

			int start = A/divisor;
			
			int end = A%10;
			
			if(start!=end)
				return 0;
			
			A = (A%divisor)/10;
			
			divisor = divisor/100;
		}
		
		return 1;*/
		int tmp =A;
		int digit = 0;
		while(tmp > 0) {
            digit++;
            tmp /= 10; 
        }
        
        int leftMostDigit = digit - 1;
        while(A > 0) {
            int mask = (int)Math.pow((double)10, (double)leftMostDigit);
            int leftVal = A / mask;
            int rightVal = A % 10;
            
            if(leftVal != rightVal) {
                return 0;
            }
            A -= mask * leftVal;
            A /= 10;
            leftMostDigit -= 2;
        }
		return 1;
	}
}
