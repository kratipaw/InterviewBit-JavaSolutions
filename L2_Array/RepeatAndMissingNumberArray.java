package L2_Array;


public class RepeatAndMissingNumberArray {

  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        
        int[] result = new int[2];
        
        int[] tmp = A;
        
        int n = tmp.length;
        
        for(int i = 0; i < n; i++) {
            
            int val = Math.abs(tmp[i]);
            
            if(tmp[val - 1] > 0)
                tmp[val - 1] = -1 * tmp[val - 1];
            
            else {
                result[0] = val;
            }
        }
        
        for(int i = 0; i < n; i++) {
            
            if(tmp[i] > 0){
                result[1] = i + 1;
                break;
            }
                
        }
        
        return result;
        
    }

}
