package L2_Math;

public class ExcelColumnTitle {

	public static void main(String[] args) {

		
		int A = 51;
		
		System.out.println(convertToTitle(A));
	}

	private static String convertToTitle(int A) {
    
		StringBuilder colName = new StringBuilder();
		
		while(A > 0) {
			
			int rem = A % 26;
			
			if(rem == 0) 
			{
				colName.append('Z');
				A = (A / 26) - 1;
			}
			else
			{
				colName.append((char) ((rem - 1) + 'A'));
				
				A = A / 26;
			}
			
		}
		
		return colName.reverse().toString();
	
	}
	
}
