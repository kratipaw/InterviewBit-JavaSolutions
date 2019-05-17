import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.


Input Format

1st argument given is an Integer x.
2nd argument given is an Integer y.
3rd argument given is an Integer N, number of circles.
4th argument given is an Integer R, radius of each circle.
5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
Constraints

0 <= x, y, R <= 100
1 <= N <= 1000
Center of each circle would lie within the grid
For Example

Input:
    x = 2
    y = 3
    N = 1
    R = 1
    A = [2]
    B = [3]
Output:
    NO
   
Explanation:
    There is NO valid path in this case
 * 
 */

public class ValidPath {

	class Point{
		int x = 0;
		
		int y = 0;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] x_moves = {1,1,1,-1,-1,-1,0,0};
    static int[] y_moves = {-1,1,0,-1,1,0,1,-1};
	
	public static void main(String[] args) {

		/*int A = 0;
		int B = 91;
		
		int C = 3, D = 5;
		
		ArrayList<Integer> E = new ArrayList<>();
		E.add(0);
		E.add(0);
		E.add(0);
		
		ArrayList<Integer> F = new ArrayList<>();
		F.add(21);
		F.add(20);
		F.add(43);
		
		String result = new ValidPath().solve(A, B, C, D, E, F);
		
		System.out.println(result);*/
		
		int A = 61;
		int B = 91;
		
		int C = 6, D = 2;
		
		ArrayList<Integer> E = new ArrayList<>();
		E.add(53);
		E.add(42);
		E.add(27);
		E.add(34);
		E.add(58);
		E.add(29);
		
		ArrayList<Integer> F = new ArrayList<>();
		F.add(16);
		F.add(54);
		F.add(33);
		F.add(40);
		F.add(30);
		F.add(23);
		
		String result = new ValidPath().solve(A, B, C, D, E, F);
		
		System.out.println(result);
	}

	public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
		
		int mat[][] = new int[A+1][B+1];
        
        //all cells from (0, 0) to (A, B) marked as unvisited (i.e. 0)
        for(int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                mat[i][j] = 0;
            }
        }
        
        //Cells inside the circles or touching the circle are blocked, mark them -1
        //Pythagoras problem
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int cir = 0; cir < C; cir++) {
                    if(Math.sqrt((Math.pow(E.get(cir) - i, 2)) + (Math.pow(F.get(cir) - j, 2))) <= D) {
                        mat[i][j] = -1;
                    }
                }
            }
        }
        
        if(mat[0][0] == -1 || mat[A][B] == -1)
            return "NO";
        
        Queue<Point> qu = new LinkedList<>();
        
        qu.add(new Point(0, 0));
        
        boolean visited[][] = new boolean[A + 1][B +1];
        
        visited[0][0] = true;
        
        while(!qu.isEmpty()) {
            
            Point pt = qu.poll();
            
            int x = pt.x;
            int y = pt.y;
            
            //System.out.println("x : " + x + ", y :" + y);
            //Check adjacent cells 
            
            
            for (int i = 0; i < 8; i++) {
					
	            	int ix = x + x_moves[i];
	            	int iy = y + y_moves[i];
	            	
	            	if(!(ix < 0 || iy <0 || ix >= A+1 || iy >= B+1) && !visited[ix][iy] && mat[ix][iy]!=-1)
	                {
	                    //System.out.println(ix+"valid"+iy);
	                    if(ix==A && iy==B)
	                    {
	                        return "YES";
	                    }
	                    
	                    qu.add(new Point(ix, iy));
	                    
	                    visited[ix][iy]=true;
	                }
	            	
			}
            
            /*
            //top-left
            if(x > 0 && y > 0 && mat[x - 1][y - 1] == 0) {
                mat[x-1][y-1] = 1;
                qu.add(new Point(x-1, y-1));
            }
            
            //top
            if(x > 0 && mat[x - 1][y] == 0) {
                mat[x-1][y] = 1;
                qu.add(new Point(x-1, y));
            }
            
            //top-right
            if(x > 0 && y < B - 1 && mat[x - 1][y + 1] == 0) {
                mat[x-1][y+1] = 1;
                qu.add(new Point(x-1, y+1));
            }
            
            //left
            if(y > 0 && mat[x][y - 1] == 0) {
                mat[x][y-1] = 1;
                qu.add(new Point(x, y-1));
            }
            
            //right
            if(y < B - 1 && mat[x][y + 1] == 0) {
                mat[x][y+1] = 1;
                qu.add(new Point(x, y+1));
            }
            
            //bottom-left
            if(x < A - 1 && y > 0 && mat[x + 1][y - 1] == 0) {
                mat[x+1][y-1] = 1;
                qu.add(new Point(x+1, y-1));
            }
            
            //bottom
            if(x < A - 1 && mat[x + 1][y] == 0) {
                mat[x+1][y] = 1;
                qu.add(new Point(x+1, y));
            }
            
            //bottom-right
            if(x < A - 1 && y < B - 1 && mat[x + 1][y + 1] == 0) {
                mat[x+1][y+1] = 1;
                qu.add(new Point(x+1, y+1));
            }*/
            
        }
        
       // return mat[A][B] == 1 ? "YES" : "NO";
        
        return "NO";
		
	}
}
