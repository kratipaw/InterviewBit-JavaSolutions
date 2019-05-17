public class Atoi {

	public static void main(String[] args) {

		
		String A = "-54332872018247709407 4 54";
		
		System.out.println(atoi(A));
		
	}

	private static int atoi(final String A) {
    
		int n = A.length();
		
		if(A == null || A.isEmpty() || A == "" || n == 0)
			return 0;
		
		String str = A.trim();
		n = str.length();
		
		double result = 0;
		
		int sign = 1;
		
		int i = 0;
		
		if(str.charAt(0) == '-') {
			sign = -1;
			i++;
		}
		
		if(str.charAt(0) == '+') 
			i++;
		
		
		
		for (; i < n; i++) {
			
			char ch = str.charAt(i);
			
			if(!isNum(ch)) {
				break;
			}
			result = result * 10 + (ch - '0');
			
		}
		
		if(sign == -1)
			result = sign * result;

		if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
		if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
		
		return (int)result;
		
	}
	
	private static boolean isNum(char ch) {
		
		if(ch >= '0' && ch <= '9')
			return true;
		
		return false;
		
	}
	
}
