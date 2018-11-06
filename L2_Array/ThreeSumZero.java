package L2_Array;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumZero {

	public static void main(String[] args) {
	
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(-1);
		A.add(0);
		A.add(1);
		A.add(2);
		A.add(-1);
		A.add(-4);
		
		ArrayList<ArrayList<Integer>> result = threeSum(A);
		
		for (int i = 0; i < result.size(); i++) {
			
			ArrayList<Integer> sol = result.get(i);
			
			for (int j = 0; j < sol.size(); j++) {
				
				System.out.print(sol.get(j) + "  ");
			}
			System.out.println();
		}
		
	}
	
	private static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
    
ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        Collections.sort(A);
        
        int n = A.size();
        
        for(int i =0; i < n -2; i++){
            if(i == 0 || A.get(i) > A.get(i-1)){
                int fix = A.get(i);
                int start = i+1;
                int end = n -1;
                while(start < end){
                    if(A.get(start) + A.get(end) + fix == 0){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(A.get(i));
                        temp.add(A.get(start));
                        temp.add(A.get(end));
                        result.add(temp);
                        
                        start++;
                        end--;
                        
                        while(start < end && A.get(end) == A.get(end +1))
                            end--;
                        while(start < end && A.get(start) == A.get(start -1))
                            start++;                                                       
                    }
                    else if((A.get(start) + A.get(end)) + fix < 0){
                        start++;
                    }
                    else {
                        end--;
                    }
                }
            }
        }
        
        return result;
	}

}
