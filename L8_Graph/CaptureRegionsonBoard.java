import java.util.ArrayList;

public class CaptureRegionsonBoard {

	public static void main(String[] args) {

	}

	public void solve(ArrayList<ArrayList<Character>> a) {
		
		if(a==null || a.size()==0)
	           return;
		
		int rows = a.size();
		
		int cols = a.get(0).size();
		
		for (int i = 0; i < rows; i++) 
            for (int j = 0; j < cols; j++) 
                if (a.get(i).get(j) == 'O') {
                	ArrayList<Character> tmp = a.get(i);
                	tmp.set(j, '-');
                	a.set(i, tmp);
                }
                	 
        for (int i = 0; i < rows; i++) // Left side 
            if (a.get(i).get(0) == '-') 
                floodFillUtil(a, i, 0, '-', 'O');
        
        for (int i = 0; i < rows; i++) // Right side 
            if (a.get(i).get(cols - 1) == '-') 
                floodFillUtil(a, i, cols - 1, '-', 'O');
        
        for (int i = 0; i < cols; i++) // Top side 
            if (a.get(0).get(i) == '-') 
                floodFillUtil(a, 0, i, '-', 'O');
        
        for (int i = 0; i < cols; i++) // Bottom side 
            if (a.get(rows - 1).get(i) == '-') 
                floodFillUtil(a, rows - 1, i, '-', 'O'); 

        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < cols; j++) 
                if (a.get(i).get(j) == '-') {
                	ArrayList<Character> tmp = a.get(i);
                	tmp.set(j, 'X');
                	a.set(i, tmp);
                } 
    }
	
	private void floodFillUtil(ArrayList<ArrayList<Character>> a, int x, int y, char prevV, char newV) {
        
		int rows = a.size();
		
		int cols = a.get(0).size();
        
        // Base cases 
        if (x < 0 || x >= rows || y < 0 || y >= cols) 
            return; 
              
        if (a.get(x).get(y) != prevV) 
            return; 
      
        // Replace the color at (x, y)
        ArrayList<Character> tmp = a.get(x);
        tmp.set(y, newV);
        a.set(x, tmp);
      
        floodFillUtil(a, x + 1, y, prevV, newV);
        
        floodFillUtil(a, x - 1, y, prevV, newV); 
        
        floodFillUtil(a, x, y + 1, prevV, newV);
        
        floodFillUtil(a, x, y - 1, prevV, newV); 
    }
}
