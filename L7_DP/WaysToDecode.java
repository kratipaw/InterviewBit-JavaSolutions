package L7_DP;

public class WaysToDecode {

	public static void main(String[] args) {

		String A = "0";
		
		System.out.println(numDecodings(A));
		
	}

	private static int numDecodings(String A) {
    
		int n = A.length();
		
		if(n == 0)
			return 0;
		
		if(n == 1 && A.charAt(0) == '0')
			return 0;
		
		if(n == 1)
			return 1;
		
		int count[] = new int[n + 1];
		
		count[0] = 1;
		count[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			
			if(A.charAt(i - 1) > '0' && A.charAt(i - 1) <= '9')
				count[i] = count[i-1];
			
			if(A.charAt(i-2) == '1' || (A.charAt(i-2) == '2' && A.charAt(i-1) < '7'))
				count[i] = count[i] + count[i-2];
			
		}
		
		return count[n];
	
	}
}
