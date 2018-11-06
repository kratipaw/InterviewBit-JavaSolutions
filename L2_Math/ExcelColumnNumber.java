package L2_Math;

public class ExcelColumnNumber {

	public static void main(String[] args) {

		String A = "D";
		
		System.out.println(titleToNumber(A));
		
	}
	
	private static int titleToNumber(String A) {
    
		int result = 0;
		
		char arr[] = A.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			
			result = result * 26;
			
			result = result + (arr[i] - 'A') + 1;
		}
		return result;
	}

}
