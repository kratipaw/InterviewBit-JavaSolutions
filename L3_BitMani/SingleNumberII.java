package L3_BitMani;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberII {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		
		/*list.add(901);
		list.add(417);
		list.add(901);
		list.add(252);
		list.add(417);
		list.add(897);
		list.add(901);
		list.add(897);
		list.add(417);
		list.add(897);*/
		
		list.add(3000);
		list.add(252);
		list.add(3000);
		list.add(3000);
		
		System.out.println(singleNumber(list));
		
	}
	
	 private static int singleNumber(final List<Integer> A) {
	        
		 int result = 0;
	        int x, sum;
	        
	        for(int i=0; i<Integer.SIZE; i++)
	        {
	            sum = 0;
	            x = (1 << i);
	            for(int j=0; j<A.size(); j++)
	            {
	                if((A.get(j).intValue() & x) == 0)
	                	sum++;
	            }
	            
	            if ((sum % 3) == 0)
	            result = result | x;
	        }
	        return result;
	    }

}
