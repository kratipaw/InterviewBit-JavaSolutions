package L3_BitMani;

public class DivideIntegers {

	public static void main(String[] args) {
		
		int A = -2147483648;
		int B = -10000000;
		
		System.out.println(divide_bit(A, B));
	}

	private static int divide(int A, int B) {
		
		long signA = 1;
		long signB = 1;
		Long C = (long) A , D = (long) B;
		if(A<0) {
			signA = -1;
			C = A * signA;
		}
		//System.out.println(C);
		if(B<0) {
			signB = -1;
			D = B * signB;
		}
		
		if(C<D)
			return 0;
		
		int count = 0;
		
		while(C>=D) {
			count++;
			C = C - D;
		}
		//System.out.println("count : " + count);
		return (int) (count*signA*signB);
	}
	
	private static long divide_bit(int A, int B) {
        
        if(B==0)
            return Integer.MAX_VALUE;
        
        if(B==-1 && A == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        
        long longA = Math.abs((long)A);
        long longB = Math.abs((long)B);
    
        int sign = ((A < 0) ^ (B < 0)) ? -1 : 1;
    
        long quotient = 0, temp = 0;
        
        for (int i = 31; i >= 0; --i) 
        {
            if (temp + (longB << i) <= longA) 
            {
            	System.out.println("i :: " + i);
            	
                temp = temp + (longB << i);
                
                System.out.println("temp :: " + temp);
                
                quotient = quotient | (1L << i);
                
            }
        }
        
        if (sign < 0) 
            quotient = -quotient;
        
        if(quotient >= Integer.MAX_VALUE || quotient <= Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        
        return  (int)quotient;
	}
}
