package L3_String;

import java.util.ArrayList;

public class JustifiedText {

	public static void main(String[] args) {

		ArrayList<String> A = new ArrayList<>();
		
		A.add("This");
        A.add("is");
        A.add("an");
        A.add("example");        
        A.add("of");
        A.add("text");
        A.add("justification.");
        
        int B = 16;
        
        ArrayList<String> result = fullJustify(A, B);
	
        System.out.println(result.size());
        System.out.println(result.toString());
	}
	
/*
	private static ArrayList<String> fullJustify(ArrayList<String> A, int B) {
    
		ArrayList<String> result = new ArrayList<>();
		
		int n = A.size();
		
		if(A == null || n == 0)
			return result;
		
		int i = 0;

		int len = 0;
		
		String tmp = "";
		
		while(i < n) {
			
			String curr = A.get(i);
			
			len = len + curr.length() + 1;
			
			if(len > B + 1) {

				result.add(tmp);
				
				tmp = "";
				
				len = 0;
				
				i--;
				
			}
			else {
				tmp = tmp + A.get(i) + " ";
			}
			
			i++;
		}
		
		if(!tmp.equals(""))
			result.add(tmp);
		
		for (int j = 0; j < result.size() - 1; j++) {

			tmp = result.get(j);
			
			String tmpArr[] = tmp.split(" ");
			
			int totLen = 0;
			
			for (int k = 0; k < tmpArr.length; k++) {
				totLen = totLen + tmpArr[k].length();
			}
			
			int spCount[] = getSpaces(B - totLen, tmpArr.length);
			
			tmp = "";
            
            for(int t = 0; t < tmpArr.length; t++){
            	
            	tmp = tmp + tmpArr[t];
                
            	for(int k = 0; k < spCount[t]; k++)
                	tmp = tmp  + " ";
            }
            result.set(j, tmp);
		}
		
		tmp = result.get(result.size() - 1);
        
		if(tmp.length() < B){
        
			while(tmp.length() < B)
            	tmp = tmp + " ";
        }
        else if(tmp.length() > B)
        	tmp = tmp.substring(0, B);
        
		result.set(result.size() - 1, tmp);
			
		return result;
	}
	
	private static int[] getSpaces(int freeSp, int numOfStrings) {
		
		int size = numOfStrings - 1;
		
		int result[] = new int[size + 1];
		
		if(size == 0)
			result[0] = freeSp;
		
		else {
			for(int i =0; i < result.length; i++) {
                
				if(size != 0){
                   
                	result[i] = freeSp % size == 0 ? freeSp/size : freeSp/(size + 1);
                }
                
                freeSp = freeSp - result[i];
                
                size--;
            }
		}
		
		return result;
	}*/
	
	public static ArrayList<String> fullJustify(ArrayList<String> A, int B) {
		
		ArrayList<String> result = new ArrayList<>();
		
		int n = A.size();
		
		if(A == null || A.isEmpty() || n == 0)
			return result;
		
        int index = 0;
        
        while (index < A.size()) {
            
        	int len = A.get(index).length();
            
        	int last = index + 1;
            
        	while (last < A.size()) {
            
        		if (A.get(last).length() + len + 1 > B) 
        			break;
                
        		len = len + A.get(last).length() + 1;
                
        		last++;
            }

            StringBuilder builder = new StringBuilder("");
            
            int diff = last - index - 1;
            
            if (last == A.size() || diff == 0) {
                
            	for (int i = index; i < last; i++) {
                
            		builder.append(A.get(i)).append(" ");
            	}

            	builder.deleteCharAt(builder.length() - 1);
                
            	for (int i = builder.length(); i < B; i++) {
                 
            		builder.append(" ");
                }
            }
            else {
                
            	int spaces = (B - len) / diff;
                
            	int r = (B - len) % diff;
                
            	for (int i = index; i < last; i++) {
                
            		builder.append(A.get(i));
                    
            		if (i < last - 1) {
                        
            			int idx = i - index < r ? 1 : 0;
            			
            			for (int j = 0; j <= spaces + idx; j++) {
                        
            				builder.append(" ");
                        }
                    }
                }
            }
            
            result.add(builder.toString());
            
            index = last;
        }
        return result;
    }
}
