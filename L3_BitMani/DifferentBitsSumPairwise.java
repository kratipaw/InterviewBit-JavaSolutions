import java.util.ArrayList;

public class DifferentBitsSumPairwise {

	static long MOD = 1000000007;
	
	public static void main(String[] args) {

		System.out.println(2 & (1 << 1));
		
		ArrayList<Integer> A = new ArrayList<>();
		/*
		A.add(81);
		A.add(13);
		A.add(2);
		A.add(7);
		A.add(96);
		*/
		
		A.add(57);
		A.add(38);
		A.add(29);
		A.add(19);
		A.add(14);
		A.add(22);
		A.add(73);
		A.add(75);
		A.add(94);
		
		System.out.println(cntBits(A));
	}
	
	private static int cntBits(ArrayList<Integer> A) {
		
		int n = A.size();
		
		if(n == 0)
			return 0;
		
		long result = 0;
		  
        for (int i = 0; i < 32; i++) { 
              
            long count = 0; 
              
            for (int j = 0; j < n; j++) 
                if ((A.get(j).intValue() & (1 << i)) == 0) 
                    count++; 
  
            result = result + ((count * (long)(n - count) * 2)%MOD);
            
            if(result>=MOD)    
                result -= MOD;
            
        } 
          
        return (int)result; 
		
    }

}
