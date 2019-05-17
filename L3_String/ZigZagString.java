public class ZigZagString {

	public static void main(String[] args) {

		String A = "ABCDEFGH";
		
		int B = 8;
		
		System.out.println(convert(A, B));
		
	}

	private static String convert(String A, int B) {
    
		StringBuilder sb = new StringBuilder("");

		int n = A.length();
		
		if(B == 1 || A == null || A.isEmpty() || A == "" || n == 1)
			return A;
		
		int jump = B + B - 2;
		
		for (int i = 0; i < B; i++) {
			
			int curr = i;
			
			while(curr < n) {
				
				sb.append(A.charAt(curr));
				
				curr = curr + jump;
				
				if(i > 0 && i < B - 1 && (curr - (2 * i)) < n)
					sb.append(A.charAt(curr - (2 * i)));
			}
			
		}
		
		return sb.toString();
	}
}
