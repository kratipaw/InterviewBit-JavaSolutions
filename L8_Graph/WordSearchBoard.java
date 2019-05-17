import java.util.ArrayList;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.
	The same letter cell may be used more than once.
	
	Example :
	
	Given board =
	
	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	
	word = "ABCCED", -> returns 1,
	word = "SEE", -> returns 1,
	word = "ABCB", -> returns 1,
	word = "ABFSAB" -> returns 1
	word = "ABCD" -> returns 0
	
	Note that 1 corresponds to true, and 0 corresponds to false.
 */

public class WordSearchBoard {

	public static void main(String[] args) {

		ArrayList<String> A = new ArrayList<>();
		A.add("ABCE");
		A.add("SFCS");
		A.add("ADEE");
		
		//String B = "ABCCED";
		
		//String B = "ABCD";
		
		String B = "SEEES";
		
		System.out.println(new WordSearchBoard().exist(A, B));
	}

	public int exist(ArrayList<String> A, String B) {
        
        int n = B.length();
        
        int rows = A.size();
        
        if(rows < 1 || n < 1)
            return 0;
        
        int cols = A.get(0).length();
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(searchBoard(A, rows, cols, B, i, j, 0)){
                    return 1;
                }
            }
        }
        
        return 0;
    }
    
    public boolean searchBoard(ArrayList<String> A, int rows, int cols, String B, int row, int col, int idx){
           
        if(isValid(A, rows, cols, row, col, B.charAt(idx))) {
           
            if(idx == B.length() - 1)
                return true;
            
            else{
                
                if(searchBoard(A, rows, cols, B, row, col + 1, idx + 1) || 
                   searchBoard(A, rows, cols, B, row, col - 1, idx + 1) || 
                   searchBoard(A, rows, cols, B, row + 1, col, idx + 1) || 
                   searchBoard(A, rows, cols, B, row - 1, col, idx + 1)
                  )
                    return true;
            }
            
         }
      
         return false;
    }
    
    public boolean isValid(ArrayList<String> A, int rows, int cols, int row, int col, char ch){
        
         if(row < 0 || row >= rows || col < 0 || col >= cols || A.get(row).charAt(col) != ch) 
            return false;
        
        return true;
    }
}
