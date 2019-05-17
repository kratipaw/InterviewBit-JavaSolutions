public class ValidNumber {

	public static void main(String[] args) {

		//String A = " 0.1";
		
		//String A = "0.1e10";
		
		String A = "-01.1e-10";
		
		//String A = "3e0.1";
		
		System.out.println(isNumber(A));
	}
	
	private static int isNumber(final String A) {
		
		if(A == null)
			return 0;
		
		String tmp = A.trim();
		
		int n = tmp.length();
		
		if(n == 0 || tmp.charAt(n-1) == '.')
			return 0;
		
		int dot = 0;
		
		int e = 0;
		
		int i = 0;

		int num = 0;
		
		if(tmp.charAt(0) == '+' || tmp.charAt(0) == '-' || tmp.charAt(0) == '.')
			i++;
		
		
		while(i < n) {
		
			char c = tmp.charAt(i);
			//System.out.println("c : " + c);
			
			if(c >= '0' && c <= '9')
				num++;
			
			else if(c == '+' || c == '-')
			{
				
			}
			
			else if(c == '.' && i < n-1 && tmp.charAt(i+1) >= '0' && tmp.charAt(i+1) <= '9') {
				//System.out.println("e : " + e);
				if(e > 0)
					return 0;
				else
					dot++;
				
			}
			
			else if(c == 'e') {
				e++;
			}
			else
				return 0;
			
			i++;
		}
		
		if(num < 1 || dot > 1 || e > 1)
			return 0;
		
		
		return 1;
    }

}
