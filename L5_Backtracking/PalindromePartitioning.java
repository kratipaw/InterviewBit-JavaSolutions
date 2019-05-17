import java.util.ArrayList;

public class PalindromePartitioning {

	public static void main(String[] args) {

		String a = "aab";
		
		ArrayList<ArrayList<String>> result = partition(a);
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + "  ");
			}
			System.out.println();
		}
		
	}

	private static ArrayList<ArrayList<String>> partition(String a) {
	
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> temp = new ArrayList<String>();
		
		result = addStrings(result, a, temp, 0);
	
		return result;
	}
	
	private static ArrayList<ArrayList<String>> addStrings(ArrayList<ArrayList<String>> res, String s, ArrayList<String> temp, int index) { 
		
		int n = s.length(); 
		
		String str = ""; 
		
		ArrayList<String> current = new ArrayList<>(temp); 
		
		if (index == 0) 
			temp.clear(); 
		
		for (int i = index; i < n; ++i) { 
			
			str = str + s.charAt(i); 
	
			if (checkPalindrome(str)) { 
				
				temp.add(str); 
				
				if (i + 1 < n) 
					res = addStrings(res, s, temp, i+1); 
				
				else
					res.add(temp); 
				
				temp = new ArrayList<>(current); 
			}
		}
		
		return res; 
	}
	
	private static boolean checkPalindrome(String str) { 
        
		int n = str.length() - 1; 
         
        int i = 0;
        
        while(i < n) {
        	
        	if (str.charAt(i) != str.charAt(n)) 
                return false;
        	
        	i++;
        	n--;
        }
        
        return true; 
    }
}
