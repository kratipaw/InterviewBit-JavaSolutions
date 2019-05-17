public class CountAndSay {

	public static void main(String[] args) {

		int n = 4;
		
		System.out.println(countAndSay(n));
	}
	
	private static String countAndSay(int A) {
    
		if(A == 1)
			return "1";
		if(A == 2)
			return "11";
		
		String prev = "11";
		String result = "";
		for (int i = 3; i <= A; i++) {
			
			prev = prev + '#';
			
			char temp[] = prev.toCharArray();
			
			int n = temp.length;
			
			int j = 1;
			int count = 1;
			result = "";
			while(j<n) {
				
				if(temp[j]!=temp[j-1]) {
					result = result + count + temp[j-1];
					count = 1;
				}
				else
					count++;
				j++;
			}
			
			prev = result;
		}
		return result;
	}

}
