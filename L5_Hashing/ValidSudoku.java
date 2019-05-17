import java.util.HashSet;
import java.util.List;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isValidSudoku(final List<String> A) {
    	
    	for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(0).length(); j++) {
				
				if(!isSafe(A, i, j))
					return 0;
			}
		}
    
    	return 1;
    }
    
    public boolean isSafe(List<String> A , int row, int col) {
        
        HashSet<Character> set = new HashSet<Character>();
        
        //row clash
        for(int i = 0 ; i < A.get(0).length() ; i++) {
            
            if(set.contains(A.get(row).charAt(i)))
                return false;
            
            if(A.get(row).charAt(i) != '.')
                set.add(A.get(row).charAt(i));
        }
        
        set.clear();
        
        //col clash
        for(int i = 0 ; i < A.size() ; i++) {
            
            if(set.contains(A.get(i).charAt(col)))
                return false;
            
            if(A.get(i).charAt(col) != '.')
                set.add(A.get(i).charAt(col));
        }

        set.clear();
        
        //box clash
        int sqrt = (int) Math.sqrt(A.size());
        int boxRow = row - (row % sqrt);
        int boxCol = col - (col % sqrt);

        for (int i = boxRow; i < boxRow + sqrt; i++)  { 
            for (int j = boxCol; j < boxCol + sqrt; j++) { 
                
                if(set.contains(A.get(i).charAt(j)))
                return false;
                
                if(A.get(i).charAt(j) != '.')  
                    set.add(A.get(i).charAt(j)); 
            }
        }
        
        return true;
    }
}
