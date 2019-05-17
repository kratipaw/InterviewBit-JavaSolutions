public class MinCharToMakePalin {

	public static void main(String[] args) {

		String A = "BANANA";
				
		System.out.println(solve(A));
		
		
		
	}

	private static int solve(String A) {
		
		int count = 0;
		
		//boolean flag = false;
		
		int n = A.length();
		int i = 0;
		while(i<n) {
			
			if(isPalindrome(A)) {
				//flag = true;
				break;
			}
			else 
			{
				count++;
				
				A = A.substring(0, n - (i+1));
			}
			
			i++;
		}
		/*
		if(flag)
			System.out.print(count);
		*/
		
		return count;
		
	}
	
	private static boolean isPalindrome(String str) {
		
		int l = str.length();
	    //int j = 0;
	     
	    for(int i = 0, j = l - 1; i <= j; i++, j--)
	    {
	        if(str.charAt(i) != str.charAt(j))
	            return false;
	    }
	    return true;
	}
}
