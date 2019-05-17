import java.util.ArrayList;
import java.util.List;

public class Array3Pointers {

	public static void main(String[] args) {

		List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(4);
        a.add(10);
        
        List<Integer> b = new ArrayList<Integer>();
        b.add(2);
        b.add(15);
        b.add(20);
        
        List<Integer> c = new ArrayList<Integer>();
        c.add(10);
        c.add(20);
        
        System.out.println(minimize(a,b,c));
	}
	
	private static int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

		/*int result = Integer.MAX_VALUE;
      
		for(int i = 0; i< A.size(); i++){
			for(int j = 0; j < B.size(); j++){
				for(int k = 0; k < C.size(); k++){
					int max1 = Math.max(Math.abs(A.get(i) - B.get(j)),Math.abs(B.get(j) - C.get(k)));
					
					int max2 = Math.max(max1, Math.abs(C.get(k) - A.get(i)));
					
					if(max2 < result)                
						result = max2;
				}
			}
	    }
		
		return result;*/
		
		int diff = Integer.MAX_VALUE;
        
		int min = Integer.MAX_VALUE;
        
		int max = Integer.MIN_VALUE;
        
		int i = 0, j = 0, k = 0;
        
		while(i < A.size() && j < B.size() && k < C.size()){
        
        	min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            
        	max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            
        	diff = Math.min(diff, max - min);
            
        	if(diff == 0)
                break;
            
        	if(A.get(i) == min)
                i++;
            
        	else if(B.get(j) == min)
                j++;
            
        	else
                k++;
        }
        
        return diff;
		
	}
	
	
}
