package L2_Math;

public class GreatestCommonDivisor {

    public int gcd(int A, int B) {
        
        if(A > B)
            return gcdUtil(A, B);
        
        return gcdUtil(B, A);
    }
    
    public int gcdUtil(int a, int b){
        
        if (a == 0) 
          return b; 
        if (b == 0) 
          return a; 
       
        if (a == b) 
            return a; 
       
        if (a > b) 
            return gcd(a-b, b); 
        return gcd(a, b-a); 
        
    }


}
