package L3_String;

/**

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer. 
For example, 
given strings "12", "10", your answer should be “120”.

NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ). 
We will retroactively disqualify such submissions and the submissions will incur penalties.

*/
public class MultiplyStrings {

	public static void main(String[] args) {
/*
		System.out.println(10/2);
		
		System.out.println(10%2);
		*/
		String A = "87";
		
		String B = "99";
		
		System.out.println(multiply(A, B));
		
	}

	private static boolean isValid(char c) {
		
		if(c >= '0' && c <= '9')
			return true;
		
		return false;
	}
	
	
	private static String multiply(String A, String B) {
    
		char a[] = A.toCharArray();
		
		char b[] = B.toCharArray();
		
		int lenA = a.length;
		
		int lenB = b.length;
		
		int res[] = new int[lenA + lenB];
		
		boolean flag = true;
		
		for (int i = lenA -1; i >= 0; i--) {
			for (int j = lenB-1; j >= 0; j--) {
				
				char iA = a[i];
				char jB = b[j];
				
				System.out.println("i : " + i);
				System.out.println("j : " + j);
				
				if(isValid(iA) && isValid(jB)) {

					int num = Character.getNumericValue(iA) * Character.getNumericValue(jB);
					
					System.out.println("num : " + num);
					
					res[i + j] = res[i + j] + (( res[i + j + 1] + num)/10);
					
					System.out.println("fir : " + printArray(res));
					
					res[i + j + 1] = (res[i + j + 1] + num)%10;
					
					System.out.println("sec : " + printArray(res));
				}
				else
				{
					flag = false;
					break;
				}
			}
			
			if(!flag)
				break;
		}
		
		if(!flag)
			return "";
		
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < res.length; i++) {
			sb.append(res[i]);
		}
	
		String result = sb.toString().replaceFirst("^0*", "");
		
		return result.isEmpty() ? "0" : result;
				
	}
	
	private static String printArray(int arr[]) {
		
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		
		return sb.toString();
	}
}
