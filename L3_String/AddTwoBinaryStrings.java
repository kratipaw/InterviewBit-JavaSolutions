package L3_String;

public class AddTwoBinaryStrings {

	public static void main(String[] args) {

		String a = "1101"; // 13
		String b="100";  // 4
        
        System.out.print(add(a, b));
	}
	
	private static String add(String a, String b) {
		
		String result = ""; 
         
        int s = 0;         
 
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            
            s += ((j >= 0)? b.charAt(j) - '0': 0);
            
            result = (char)(s % 2 + '0') + result;
            
            s = s/2;
 
            i--; j--;
        }
         
    return result;
	}

}
