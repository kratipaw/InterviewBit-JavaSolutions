package L3_String;

public class Stringoholics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * public class Solution {
    private final static long base = (long) (1e9 + 7);
    
    public int solve(ArrayList<String> A) {
        int[] primeCnt = new int[300000];
        for (String a : A) {
            long c = minCycle(a);
            if (c <= 1) continue;
            int d = 2;
            do {
                int cnt = 0;
                while (c % d == 0) {
                    c /= d;
                    ++cnt;
                }
                if (cnt > 0 && cnt > primeCnt[d]) primeCnt[d] = cnt;
                ++d;
            } while (c > 1);
        }
        long res = 1L;
        for (int i = 2; i < primeCnt.length; ++i) {
            int cnt = primeCnt[i];
            if (cnt <= 0) continue;
            for (int j = 0; j < cnt; ++j)
                res = (res * i) % base;
        }
        return (int) (res);
    }
    
    private int minCycle(String a) {
        int l = a.length();
        boolean[] ok = foundPos(a);
        for (int t = 1; t <= 2 * l; ++t) {
            int r = (int) ((t * (t + 1L) / 2L) % l);
            if (ok[r]) return t;
        }
        return -1; // impossible
    }
    
    boolean [] foundPos(String a) {
        int l = a.length();
        boolean [] res = new boolean[l];
        res[0] = true;
        long aHash = rhash(a);
        long bHash = aHash;
        long pow = twoPow(l);
        for (int r = 1; r < l; ++r) {
            bHash = uphash(bHash, a.charAt(r - 1), pow);
            if (aHash == bHash &&
                a.substring(0, r).equals(a.substring(l - r, l)) &&
                a.substring(r, l).equals(a.substring(0, l - r)))
                res[r] = true;
        }
        return res;
    }
    
    long uphash(long hash, char a, long pow) {
        hash -= (a * pow) % base;
        if (hash < 0) hash += base;
        hash += a;
        return hash % base;
    }
    
    long twoPow(int pow) {
        long r = 1L;
        while (pow-- > 0)
            r = (r * 2L) % base;
        return r;
    }
    
    long rhash(String a) {
        long r = 0L;
        for (char c : a.toCharArray()) {
            r = ((r * 2L) + c) % base;
        }
        return r;
    }
}























































public class Solution {
    
    final int mod = (int) 1e9+7;
    
    public int solve(ArrayList<String> A) {
        
        ArrayList<Integer> lens = new ArrayList<>();
        
        for(String str: A){
            int n = str.length();
            int[] lps = new int[n];
            int max_len = get_longest_substring(str, n, lps);
            
            if(n%(n-max_len) == 0){
                n -= max_len;
            }
            
            long sum = 0;
            int j=1;
            do{
                sum+=j;
                j++;
            }
            while(sum%(1l*n)!=0L);
            
            lens.add(j-1);
        }
        
        long lcm = get_lcm(lens) % mod;
        
        return (int) lcm % mod;
        
        // return 1;
        
        
    }
    // Basically KMP
    public int get_longest_substring(String str, int n, int[] lps){
        lps[0] = 0;
        int i = 1;
        int len = 0;
        int max = 0;
        while(i<n){
            if(str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
                max = Math.max(len, max);
            }
            else{
                if(len==0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    len = lps[len-1];
                }
            }
        }
        return max;
    }
    
    public void update_dict(HashMap<Integer, Integer> fact, int num){
        int i = 2;
        while(i<=num && num>1){
            int cnt = 0;
            while(num%i==0){
                num/=i;
                cnt++;
            }
            
            if(cnt==0){
                i++;
                continue;
            }
            
            if(fact.containsKey(i)){
                int max = fact.get(i);
                if(max <= cnt){
                    fact.put(i, cnt);
                }
            }
            else{
                fact.put(i, cnt);
            }
            
            i++;
            
        }
    }
    
    
    public long pow(long a, long b){
        long ans=1l;
        while(b>0) {
            if(b%2L==1L){
                ans=(ans*a)%mod;
            }
            a=(a*a)%mod;
            b=b/2;
        }
        return ans;
    }
    
    public long get_lcm(ArrayList<Integer> arr){
        
        
        
        HashMap<Integer, Integer> fact = new HashMap<>();
        for(Integer num: arr){
            
            // System.out.print(num + " ");
            
            update_dict(fact, num);
        }
        
        long prod = 1;
        
        for (Map.Entry<Integer, Integer> item : fact.entrySet()) {
            int key = item.getKey();
            int value = item.getValue();
            
            long p = pow(key, value) % mod;
            
            // System.out.print(key + "^" + value + " = " + p + " ** ");
            
            prod = ( prod * (long)p  ) % mod;
            
        }
        
        return prod % mod;
        
    }
    
}






















































































public class Solution {
    
    final int mod = (int) 1e9+7;
    
    public int solve(ArrayList<String> A) {
        
        ArrayList<Integer> lens = new ArrayList<>();
        
        for(String str: A){
            int n = str.length();
            int[] lps = new int[n];
            int max_len = get_longest_substring(str, n, lps);
            
            if(n%(n-max_len) == 0){
                n -= max_len;
            }
            
            long sum = 0;
            int j=1;
            do{
                sum+=j;
                j++;
            }
            while(sum%(1l*n)!=0L);
            
            lens.add(j-1);
        }
        
        long lcm = get_lcm(lens) % mod;
        
        return (int) lcm % mod;
        
        // return 1;
        
        
    }
    // Basically KMP
    public int get_longest_substring(String str, int n, int[] lps){
        lps[0] = 0;
        int i = 1;
        int len = 0;
        int max = 0;
        while(i<n){
            if(str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
                max = Math.max(len, max);
            }
            else{
                if(len==0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    len = lps[len-1];
                }
            }
        }
        return max;
    }
    
    public void update_dict(HashMap<Integer, Integer> fact, int num){
        int i = 2;
        while(i<=num && num>1){
            int cnt = 0;
            while(num%i==0){
                num/=i;
                cnt++;
            }
            
            if(cnt==0){
                i++;
                continue;
            }
            
            if(fact.containsKey(i)){
                int max = fact.get(i);
                if(max <= cnt){
                    fact.put(i, cnt);
                }
            }
            else{
                fact.put(i, cnt);
            }
            
            i++;
            
        }
    }
    
    
    public long pow(long a, long b){
        long ans=1l;
        while(b>0) {
            if(b%2L==1L){
                ans=(ans*a)%mod;
            }
            a=(a*a)%mod;
            b=b/2;
        }
        return ans;
    }
    
    public long get_lcm(ArrayList<Integer> arr){
        
        
        
        HashMap<Integer, Integer> fact = new HashMap<>();
        for(Integer num: arr){
            
            // System.out.print(num + " ");
            
            update_dict(fact, num);
        }
        
        long prod = 1;
        
        for (Map.Entry<Integer, Integer> item : fact.entrySet()) {
            int key = item.getKey();
            int value = item.getValue();
            
            long p = pow(key, value) % mod;
            
            // System.out.print(key + "^" + value + " = " + p + " ** ");
            
            prod = ( prod * (long)p  ) % mod;
            
        }
        
        return prod % mod;
        
    }
    
}






















































































*/
