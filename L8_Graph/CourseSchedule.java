import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *  There are a total of N courses you have to take, labeled from 1 to N. 
 *  Some courses may have prerequisites, for example 
 *  to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 *   
	Given the total number of courses and a list of prerequisite pairs, 
	is it possible for you to finish all courses. return 1/0 if it is possible/not possible.
	
	The list of prerequisite pair are given in two integer arrays B and C 
	where B[i] is a prerequisite for C[i].

 	Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], 
 	then you can finish courses in the following order: 1, 2 and 3. 
 	But if N = 2 and the prerequisite pairs are [1,2] and [2,1], 
 	then it is not possible for you to finish all the courses. 
 */
public class CourseSchedule {

	public static void main(String[] args) {

	}
	
public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        
        if(B == null || C == null || B.size() == 0 || C.size() == 0 || A == 0){
            return 1;
        }
        
        int n = B.size();
        
        // use the map to store what courses depend on a course 
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int i = 0; i < C.size(); i++){
            if(map.containsKey(C.get(i) - 1)){
                map.get(C.get(i) - 1).add(B.get(i) - 1);
            }else{
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(B.get(i) - 1);
                map.put(C.get(i) - 1, l);
            }
        }
        
        boolean[] visited = new boolean[A]; 
        boolean[] recStack = new boolean[A];
        
        Arrays.fill(visited, false);
        Arrays.fill(recStack, false);
        
        for (int i = 0; i < A; i++) 
            if (!canFinishDFS(map, visited, recStack, i)) 
                return 0; 
  
        return 1; 
    }
    
    private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, boolean[] visited, boolean[] recStack, int i){
        
        if (recStack[i]) 
            return false; 
  
        if (visited[i]) 
            return true; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        
        List<Integer> list = map.get(i); 
        
        if(list != null){
            for (int c: list) 
                if (!canFinishDFS(map, visited, recStack, c)) 
                    return false; 
        }
        
        recStack[i] = false; 
  
        return true; 
    }
	
}
