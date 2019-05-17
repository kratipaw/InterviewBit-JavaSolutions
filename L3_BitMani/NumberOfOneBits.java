/**
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.

	Example:
	
	The 32-bit integer 11 has binary representation
	
	00000000000000000000000000001011
	so the function should return 3.
	
	Note that since Java does not have unsigned int, use long for Java
	
 */
public class NumberOfOneBits {

	public static void main(String[] args) {

		long a = 11;
		
		System.out.println(new NumberOfOneBits().numSetBits(a));
	}

	public int numSetBits(long a) {
        int count = 0;
        long x = 1;
        while(a>0){
            
            if((a&x)==1){
                count++;
            }
            a = a >> 1; 
        }
        
        return count;
    }
}
