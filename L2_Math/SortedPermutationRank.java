public class SortedPermutationRank {

	public int MOD = 1000003;
	
	public static void main(String[] args) {

		SortedPermutationRank rk = new SortedPermutationRank();
		
		String A = "DTNGJPURFHYEW";
		
		String B = "ZCSFLVHXRYJQKWABGT";
		
		System.out.println("A : " + rk.findRank(A));
		
		System.out.println("B : " + rk.findRank(B));
		
	}

	public int findRank(String A) {
		
		if(A == null || A.isEmpty() || A.length() == 0)
			return 1;
		
		int n = A.length();
		
		int fact = factorial(n);
        
        int rank = 0;
        
        for (int i = 0; i < n; i++) {
            
            fact = factorial(n-i-1);
            
            int smaller = smallerInRight(A, i, n);
            
            rank = rank + (smaller * fact);
            
            rank = rank % MOD;
            
        }
        
        return rank + 1;
    }
    
    public int smallerInRight(String A, int start, int end) {
        
        int count = 0;
        
        for (int i = start + 1; i < end; i++) {
            if((int)A.charAt(i) < (int)A.charAt(start))
                count++;
        }
        
        return count;
    }
    
    public int factorial(int n) {
        
    	if(n <= 1)
    		return 1;
    	
        return (n * factorial(n - 1)) % MOD;
        
    }
}
