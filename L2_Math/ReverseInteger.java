package L2_Math;

public class ReverseInteger {

	public static void main(String[] args) {

		int A = -2147483647;
		
		System.out.println(reverse(A));
		
	}

	private static int reverse(int A) {
    
		int sign = 1;
		
		int result = 0;
		
		if(A<0) {
			A = -A;
			sign = -1;
		}
		
		int prev = 0;
		
		while(A!=0) {
			
			int digit = A%10;
			
			result = (result*10) + digit;
			
			if((result-digit)/10 != prev)
				return 0;
			
			prev = result;
			
			A = A/10;
		}
		
		if(sign==1)
			return result;
		else
			return result * sign;
	}
}
