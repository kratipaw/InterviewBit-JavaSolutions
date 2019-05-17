import java.util.ArrayList;

public class LongestCommonPrefix {

	public static void main(String[] args) {

		ArrayList<String> A = new ArrayList<String>();
		
		A.add("abcde");
		A.add("abcbdcd");
		A.add("abcdsf");
		
		System.out.println(longestCommonPrefix(A));
	}
	
	private static String longestCommonPrefix(ArrayList<String> A) {
    
		int n = A.size();
		
		if(n == 0)
			return "";
		
		String first = A.get(0);
		int firstLen = first.length();
		
		boolean flag = true;
		String sub = "";
		for (int i = firstLen; i >=0; i--) {
			
			sub = first.substring(0, i);
			flag = true;
			for (int k = 1; k < n; k++) {
				
				if(!A.get(k).startsWith(sub)) {
					flag = false;
					break;
				}
				
			}
			
			if(flag)
				break;
		}
		
		return sub;
	}

}
