/**

Find if Given number is power of 2 or not. 
More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:

number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:

return 1 if the number is a power of 2 else return 0

Example:

Input : 128
Output : 1

*/
public class PowerOfTwo {

	public static void main(String[] args) {

		//String A = "147573952589676412928";
		String A = "128";
		
		System.out.println(power(A));
	}
	
	private static int power(String A) {
     
		/*try {
		
			long num = Long.parseLong(A);
			
			if(num<=1)
				return 0;
			
			while(num>2) {
				
				long right = num >> 1;
				long left = right << 1;
				
				if(num - left != 0)
					return 0;
				
				num = num >> 1;
				
			}
		}
		catch (NumberFormatException ex) {
			return 0;
		}
		catch (Exception ex) {
			
		}
		return 1;*/
		/*
		long n = Long.parseLong(A);
		
		return n>0 && (n&n-1)==0;*/
		
		java.math.BigInteger a = null;
		
		try {	
			a = new java.math.BigInteger(A);
	        
	        if(a.compareTo(java.math.BigInteger.ONE)==0 || a.compareTo(java.math.BigInteger.ZERO)==0)
	            return 0;
	        
	        for(int i=0;i<a.bitLength()-1;i++){
	            if(a.testBit(i))
	            	return 0;
	        }
	        
	        return a.testBit(a.bitLength()-1) ? 1 : 0;
			
		}
		catch (NumberFormatException ex) {
			return 0;
		}
		catch (Exception ex) {
			
		}
	
		return a.testBit(a.bitLength()-1) ? 1 : 0;
    }

}
