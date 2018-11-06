package L3_BinarySearch;

public class SquareRoot {

	public static void main(String[] args) {

		int n = 2147483647;
		
		System.out.println(sqrt(n));
	}

	private static int sqrt(int a) {
    
		if(a == 0 || a == 1)
			return a;
		int sign = 1;
		if(a<0)
			sign = -1;
		
		long result = 0;
		
		long start = 0, end = (long)a/2 * sign;
		
		while(start<=end) {
			
			long mid = start + (end - start)/2;
			
			if(mid*mid == (a*sign))
				return (int)mid;
			
			if(mid*mid<(a*sign)) {
				start = mid+1;
				result = mid;
			}
			else
				end = mid-1;
			
		}
		
		return (int)result*sign;
		
		
	}
}
