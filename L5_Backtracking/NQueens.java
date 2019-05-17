import java.util.ArrayList;

public class NQueens {

	public static void main(String[] args) {

		ArrayList<ArrayList<String>> result = new NQueens().solveNQueens(4);
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.println(result.get(i).get(j));
			}
			
			System.out.println();
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
        
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		int board[][] = new int[a][a];
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				board[i][j] = 0;
			}
		}
        
		if(!solveUtil(result, a, board, 0))
			System.out.println("No solution");
		
		return result;
    }
	
	public boolean solveUtil(ArrayList<ArrayList<String>> result, int a, int board[][], int col) {
		
		if(col == a) {
			ArrayList<String> tmp = new ArrayList<>();
			for (int i = 0; i < a; i++) {
				String str = "";
				for (int j = 0; j < a; j++) {
					if(board[i][j] == 0)
						str = str + ".";
					
					else
						str = str + "Q";
				}
				
				tmp.add(str);
			}
			
			result.add(tmp);
			return true;
		}
		
		boolean res = false;
		
		for (int i = 0; i < a; i++) {
			
			if(isSafe(board, i, col, a)) {
				
				board[i][col] = 1;
				
				res = solveUtil(result, a, board, col + 1) || res;
				
				board[i][col] = 0;
			}
		}
		
		return res;
	} 

	public boolean isSafe(int board[][], int row, int col, int a) {
		
		//left side
		for (int i = 0; i < col; i++) {
			if(board[row][i] == 1)
				return false;
		}
		
		//upper left diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		//lower left diagonal
		for (int i = row, j = col; i < a && j >=0 ; i++, j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}
}
