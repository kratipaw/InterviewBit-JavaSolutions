package graph;

/**
 * Given N * M field of O's and X's, where O=white, X=black
	Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
	
	Example:
	
	OOOXOOO
	OOXXOXO
	OXOOOXO
	
	answer is 3 shapes are  :
	(i)    X
	     X X
	(ii)
	      X
	 (iii)
	      X
	      X
	Note that we are looking for connected shapes here.
	
	For example,
	
	XXX
	XXX
	XXX
	is just one single connected black shape.
 */

import java.util.ArrayList;

public class BlackShapes {

	int rowNbr[] = new int[] {-1, 0, 0, 1 };
    int colNbr[] = new int[] { 0, -1, 1, 0 };
    
	public static void main(String[] args) {

	}

	public int black(ArrayList<String> A) {

		if (A == null || A.size() == 0)
			return -1;

		int n = A.size();

		int m = A.get(0).length();

		boolean visited[][] = new boolean[n][m];

		int result = 0;

		for (int i = 0; i < n; ++i)
			for (int j = 0; j < m; ++j)
				if (A.get(i).charAt(j) == 'X' && !visited[i][j]) {
					DFSUtil(A, i, j, visited, n, m);
					result++;
				}

		return result;

	}

	void DFSUtil(ArrayList<String> A, int row, int col, boolean visited[][], int n, int m) {
		visited[row][col] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 4; k++)
			if (isSafe(A, visited, row + rowNbr[k], col + colNbr[k], n, m))
				DFSUtil(A, row + rowNbr[k], col + colNbr[k], visited, n, m);
	}

	public boolean isSafe(ArrayList<String> A, boolean visited[][], int row, int col, int n, int m) {

		return (row > -1) && (row < n) && (col > -1) && (col < m) && (A.get(row).charAt(col) == 'X')
				&& !visited[row][col];
	}

}
