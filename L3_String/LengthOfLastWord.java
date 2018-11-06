package L3_String;

public class LengthOfLastWord {

	public static void main(String[] args) {

		String string = "     ";
		
		System.out.println(getLastWordLength(string));
	}

	private static int getLastWordLength(String A) {
		
		if(A.trim().length()==0)
			return 0;
		
		String tok[] = A.trim().split("\\s+");
		
		int n = tok.length;
		
		return tok[n-1].length();
		
	}
}
