package L3_String;

public class PalindromeString {

	public static void main(String[] args) {

		String A = "A man, a plan, a canal: Panama";
		
		System.out.println("String A : " + A + " is palindorme : " + isPalindrome(A));
		
		String B = "race a car";
		
		System.out.println("String B : " + B + " is palindorme : " + isPalindrome(B));
		
	}
	
	public static int isPalindrome(String A) {
		
		if(A.length() == 0)
			return 1;
		
		A = A.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase();

		char temp[] = A.toCharArray();
		
		int i = 0;
		int j = temp.length-1;
		
		while(i<=j) {
			
			if(temp[i]!=temp[j])
				return 0;
			
			i++;
			j--;
		}
		
		return 1;
	}

}
