package L7_DP;

public class EditDistance {

	public static void main(String[] args) {

		String A = "a";
		
		String B = "b";
		
		System.out.println(minDistance(A, B));
		
	}
	
	private static int minDistance(String A, String B) {
    
		int m = A.trim().length();
		
		int n = B.trim().length();
		
		int tab[][] = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			
			for (int j = 0; j <= n; j++) {
				
				if(i == 0)
					tab[i][j] = j;
				
				else if(j == 0)
					tab[i][j] = i;
				
				else if(A.charAt(i-1) == B.charAt(j-1))
					tab[i][j] = tab[i-1][j-1];
				
				else
					tab[i][j] = 1 + Math.min(tab[i][j-1], Math.min(tab[i-1][j-1], tab[i-1][j]));
			}
			
		}
		
		return tab[m][n];
		
	
	}

}
