package L3_String;

public class IntegerToRoman {

	public static void main(String[] args) {

		int A = 3549;
		
		System.out.println(intToRoman(A));
		
	}
	
	private static String intToRoman(int A) {
    
		String M[] = {"", "M", "MM", "MMM"}; 
		
		String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
		
		String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; 
		
		String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};  
	
		String th = M[A / 1000];
		
		A = A % 1000;
		String hund = C[A / 100];
		
		A = A % 100;
		String tens = X[A / 10];
		
		A = A % 10;
		String ones = I[A];
		
		String result = th + hund + tens + ones;
		
		return result;
	}

}
