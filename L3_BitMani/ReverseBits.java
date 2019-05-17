/**
 * Reverse bits of an 32 bit unsigned integer

	Example 1:
	
	x = 0,
	
	          00000000000000000000000000000000  
	=>        00000000000000000000000000000000
	return 0
	
	Example 2:
	
	x = 3,
	
	          00000000000000000000000000000011 
	=>        11000000000000000000000000000000
	return 3221225472
	
	Since java does not have unsigned int, use long
	
 */
public class ReverseBits {

	public static void main(String[] args) {

		long a = 3;
		
		System.out.println(new ReverseBits().reverse(a));
	}
	
	public long reverse(long a) {
        
        long rev = 0;
        int i = 31;
        while(a>0){
            long val = (long)((a%2)*Math.pow(2,i));
            rev = rev + val;
            i--;
            a = a/2;            
        }
        
        return rev;
        
    }
}
