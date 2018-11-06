package L2_Math;

public class PowerOfTwoIntegers {

	public static void main(String[] args) {

		int A = 1024000000;
		
		System.out.println(isPower(A));
	}
	
	private static int isPower(int A) {
    
		if(A == 1)
			return 1;
		
		for (int i = 2; i <= Math.sqrt(A); i++) {
			
			long num = i;
			
			while(num<=A) {
				
				num = num * i;
				
				if(num == A)
					return 1;
			}
		}
	
		return 0;
	}

}
