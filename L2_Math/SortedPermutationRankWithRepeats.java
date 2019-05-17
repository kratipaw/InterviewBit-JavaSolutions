import java.util.Arrays;

public class SortedPermutationRankWithRepeats {

	public int MOD = 1000003;
	
	public static void main(String[] args) {
		
		SortedPermutationRankWithRepeats srt = new SortedPermutationRankWithRepeats();
		
		String A = "sadasdsasassasas";  //Res : 208526
		
		System.out.println(srt.findRank(A));

	}
	
	public int findRank(String A) {
		
		if(A == null || A.isEmpty() || A.length() == 0)
			return 1;
		
		int n = A.length();
		
		int rank = 1;
		
		for (int i = 0; i < n; i++) {
			
			int smaller = smallerInRight(A, i, n);
			
			int freq[] = countFrequency(A, i, n);
			
			int div = 1;
			
			for (int j = 0; j < freq.length; j++) {
				div = div * factorial(freq[j]);
			}
			
			rank = rank + (smaller * factorial(n - i - 1)/div);
			
		}
		
		return rank;
    }

	public int[] countFrequency(String A, int start, int end) {
		
		int freq[] = new int[52];
		Arrays.fill(freq, 0);
		
		for (int i = start; i < end; i++) {
			
			if (((A.charAt(i)) >= 'A') && (A.charAt(i)) <= 'Z') 
                freq[A.charAt(i) - 'A'] ++; 
            else
                freq[A.charAt(i) - 'a' + 26] += 1;
		}
		
		return freq;
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
    
    public long modExp(long xint, long yint) {
	    long res = 1;
	    long x = xint;
	    long y = yint;
	    //System.out.println("Exp " + x + " " + y + " " + res);
	    while (y > 0) {
	        if ((y & 1) == 1) {
	            res = (res * x) % MOD;
	        }
	        x = (x * x) % MOD;
	        y >>= 1;
	    //System.out.println("Exp " + x + " " + y + " " + res);
	    }
	    //return new Long(res).intValue();
	    return res;
	}
    
	
	/*
	public int findRank(String a) {
	    int n = a.length();
	    long[] facts = new long[n + 1];
	    long[] infacts = new long[n + 1];
	    facts[0] = infacts[0] = 1;
        for (int i = 1; i <= n; i++) {
            facts[i] = (facts[i - 1] * i) % MOD;
            infacts[i] = modExp(facts[i], MOD - 2);
            //System.out.println(i + " " + facts[i] + " " + infacts[i]);
        }
        
        int[] c = new int[52];
        for (char ch : a.toCharArray()) {
            c[o(ch)]++;
        }
        
        long rank = 0;
        int count = a.length();
        for (char ch : a.toCharArray()) {
            count--;
            for (int t = 0; t < o(ch); t++) {
                if (c[t] > 0) {
                    c[t]--;
                    long trank = facts[count];
                    //System.out.println("t" + trank);
                    for (int i = 0; i < 52; i++) {
                        if (c[i] > 0) {
                            trank = (trank * infacts[c[i]]) % MOD;
                            //System.out.println("t" + trank);
                        }
                    }
                    rank = (rank + trank) % MOD;
                    //System.out.println("r" + rank);
                    c[t]++;
                }
            }
            c[o(ch)]--;
        }
	    return new Long((rank + 1) % MOD).intValue();
	}
	
	public int smallerInRight(String A, int start, int end) {
        
        int count = 0;
        
        for (int i = start + 1; i < end; i++) {
            if((int)A.charAt(i) < (int)A.charAt(start))
                count++;
        }
        
        return count;
    }
	
	private int o(char ch) {
	    if (ch <= 'Z') return ch - 'A';
	    return ch - 'a' + 26;
	}
	
	public long modExp(long xint, long yint) {
	    long res = 1;
	    long x = xint;
	    long y = yint;
	    //System.out.println("Exp " + x + " " + y + " " + res);
	    while (y > 0) {
	        if ((y & 1) == 1) {
	            res = (res * x) % MOD;
	        }
	        x = (x * x) % MOD;
	        y >>= 1;
	    //System.out.println("Exp " + x + " " + y + " " + res);
	    }
	    //return new Long(res).intValue();
	    return res;
	}*/
}
