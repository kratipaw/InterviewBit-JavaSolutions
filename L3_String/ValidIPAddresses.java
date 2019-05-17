import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ValidIPAddresses {

	public static void main(String[] args) {

		String A = "25525511135";
		
		ArrayList<String> result = restoreIpAddresses(A);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	private static ArrayList<String> restoreIpAddresses(String A) {
    
		ArrayList<String> result = new ArrayList<>();
		
		int size = A.length();
		 
        String snew = A;
 
        for (int i = 1; i < size - 2; 
                               i++)
        {
            for (int j = i + 1; 
                 j < size - 1; j++) 
            {
                for (int k = j + 1; 
                     k < size; k++) 
                {
                    snew = snew.substring(0, k) +
                           "." + snew.substring(k);
                    snew = snew.substring(0, j) + 
                           "." + snew.substring(j);
                    snew = snew.substring(0, i) + 
                           "." + snew.substring(i); 
                            
                    if (isValid(snew))
                    {
                        result.add(snew);
                    }
                    snew = A;
                }
            }
        }
 
        Collections.sort(result, new Comparator<String>() 
        {
            public int compare(String o1, String o2)
            {
                String a1[] = o1.split("[.]");
                String a2[] = o2.split("[.]");
 
                int result = -1;
                for (int i = 0; i < 4 && 
                     result != 0; i++) 
                {
                    result = a1[i].compareTo(a2[i]);
                }
                return result;
            }
        });
        
		return result;
	
	}
	
	private static boolean isValid(String ip) 
    {
        String a[] = ip.split("[.]");
        for (String s : a) {
            int i = Integer.parseInt(s);
            if (s.length() > 3 || i < 0 || i > 255) 
            {
                return false;
            }
            if (s.length() > 1 && i == 0)
                return false;
            if (s.length() > 1 && i != 0 &&
                        s.charAt(0) == '0')
                return false;
        }
 
        return true;
    }

}
