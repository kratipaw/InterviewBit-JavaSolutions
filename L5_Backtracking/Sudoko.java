import java.util.ArrayList;
import java.util.HashSet;

public class Sudoko {

	public static void main(String[] args) {

	}
	
	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solveSudokuUtil(a);
    }
    
    public boolean solveSudokuUtil(ArrayList<ArrayList<Character>> a) {
        
        int N = a.size();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                
                if(a.get(i).get(j) != '.')
                    continue;
                
                for (int k = 1; k <= N; k++) {
                    
                    char ch = (char) (k + '0');
                    a.get(i).set(j, ch);

                    if(isSafe(a, i, j, ch) && solveSudokuUtil(a)) {
                        return true;
                    }
                    
                    a.get(i).set(j, '.');
                }
                
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isSafe(ArrayList<ArrayList<Character>> a, int row, int col, char ch) {
        
        HashSet<Character> set = new HashSet<Character>();
        
        //row clash
        for(int i = 0 ; i < a.get(0).size() ; i++) {
            
            if(set.contains(a.get(row).get(i)))
                return false;
            
            if(a.get(row).get(i) != '.')
                set.add(a.get(row).get(i));
        }
        
        set.clear();
        
        //col clash
        for(int i = 0 ; i < a.size() ; i++) {
            
            if(set.contains(a.get(i).get(col)))
                return false;
            
            if(a.get(i).get(col) != '.')
                set.add(a.get(i).get(col));
        }

        set.clear();
        
        //box clash
        int sqrt = (int) Math.sqrt(a.size());
        int boxRow = row - (row % sqrt);
        int boxCol = col - (col % sqrt);

        for (int i = boxRow; i < boxRow + sqrt; i++)  { 
            for (int j = boxCol; j < boxCol + sqrt; j++) { 
                
                if(set.contains(a.get(i).get(j)))
                return false;
                
                if(a.get(i).get(j) != '.')  
                    set.add(a.get(i).get(j)); 
            }
        }
        
        return true;
    }
}
