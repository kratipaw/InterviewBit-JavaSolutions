package L3_TwoPointers;

public class MaxContinuousSeriesOfOnes {
  
  
  public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        if(A == null || A.size() == 0)
            return result;
        
        int n = A.size();
        
        int left = 0, right = 0, max = 0, start = 0;
        
        for(right = 0; right < n; right++) {
            
            if(A.get(right) == 0)
                B--;
            
            if(B < 0) {
                
                if(A.get(left) == 0)
                    B++;
                
                left++;
            }
            
            if((right - left) > max) {
                max = right - left;
                start = left;
            }
        }
        
        int index = 0;
        
        while (index <= max) {
            result.add(start++);
            index++;
        }
        return result;
        
    }


}
