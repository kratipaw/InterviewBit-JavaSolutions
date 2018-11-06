package L3_String;

public class ImplementStrStr {

	public static void main(String[] args) {

		String A = "";
		String B = "";
		
		System.out.println(strStr(A, B));
	}
	
	private static int strStr(final String A, final String B) {
    
		if(A==null || B==null) 
			return -1; 
	      
		int ALen=A.length();
		
	    int BLen=B.length(); 
	    
	    if(ALen<BLen) 
	    	return -1; 
	      
	    if(BLen==0) 
	    	  return -1;
	    
	    for(int i=0; i<=ALen-BLen; i++)
	    {
		   if(A.charAt(i)==B.charAt(0))
		   {
			   int j=0; 
			   for(; j<BLen; j++)
			   {
				   if(A.charAt(i+j)!=B.charAt(j))
					   break; 
		       }
		       if(j==BLen) 
		    	   return i ; 
		   }  
		}
		return -1; 
	}

}
