public class RomanToInteger {

	public static void main(String[] args) {

		String A = "IV";
		
		System.out.println(romanToInt(A));
	}

	private static int romanToInt(String A) {
		
		char tok[] = A.toCharArray();
		
		int n = A.length();
		
		int result = 0;
		 
        for (int i=0; i<n; i++)
        {
            int ch1 = getValue(tok[i]);
  
            if (i+1 <n)
            {
                int ch2 = getValue(tok[i+1]);

                if (ch1 >= ch2)
                	result = result + ch1;
                else
                {
                	result = result + ch2 - ch1;
                    i++;                 
                }
            }
            else
            {
            	result = result + ch1;
                i++;
            }
        }
 
        return result;
	
	}
	
	private static int getValue(char ch)
    {
        if (ch == 'I')
            return 1;
        if (ch == 'V')
            return 5;
        if (ch == 'X')
            return 10;
        if (ch == 'L')
            return 50;
        if (ch == 'C')
            return 100;
        if (ch == 'D')
            return 500;
        if (ch == 'M')
            return 1000;
        return -1;
    }
}
