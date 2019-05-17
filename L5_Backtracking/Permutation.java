import java.util.ArrayList;

public class Permutation{

  public static void main(String args[]){
	  
    
    
  }

  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(A == null || A.size() == 0)
            return result;
        
        int n = A.size();
        
        util(A, n, n, result);
        
        return result;
    }
    
    public void util(ArrayList<Integer> A, int curr_size, int size, ArrayList<ArrayList<Integer>> result){
        
        if(curr_size == 1){
            ArrayList<Integer> tmp = new ArrayList<Integer>(A);
            result.add(tmp);
            return;
        }
        
        for(int i = 0; i < curr_size; i++){
            
            util(A, curr_size - 1, size, result);
            
            if(curr_size % 2 == 1){
                int swap = A.get(0);
                A.set(0, A.get(curr_size - 1));
                A.set(curr_size - 1, swap);
            }
            
            else{
                
                int swap = A.get(i);
                A.set(i, A.get(curr_size - 1));
                A.set(curr_size - 1, swap);
            }
            
        }
        
    }
    
    /*public void util_2(ArrayList<Integer> A, int idx, ArrayList<ArrayList<Integer>> result){
       
       if (idx >= A.size() - 1) {
            result.add(new ArrayList<>(A));
            return;
        }

        for (int i = idx; i < A.size(); i++) {
            java.util.Collections.swap(A, idx, i);
            combine(A, idx + 1, result);
            java.util.Collections.swap(A, idx, i);
        }
        
    }*/
}
