package L3_BinarySearch;

public class RotatedSortedArraySearch {

    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
        
        if(a == null || a.size() == 0)
            return -1;
        
        int n = a.size();
        
        int left = 0, right = n - 1;
        
        while(left <= right){
            
            int mid = left + (right - left)/2;
            
            if(a.get(mid) == b)
                return mid;
            
            else if(a.get(mid) >= a.get(left)){ //correct order from left to mid
                if(b >= a.get(left) && b < a.get(mid))
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            
            else{
                if(b > a.get(mid) && b <= a.get(right))
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        
        return -1;
        
    }

}
