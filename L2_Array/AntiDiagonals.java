package L2_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AntiDiagonals {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(1);
		row.add(2);
		row.add(3);
		
		A.add(row);
		
		row = new ArrayList<Integer>();
		row.add(4);
		row.add(5);
		row.add(6);
		
		A.add(row);
		
		row = new ArrayList<Integer>();
		row.add(7);
		row.add(8);
		row.add(9);
		
		A.add(row);
		
		ArrayList<ArrayList<Integer>> result = diagonal(A);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	}
	
	private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
    
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		int rows = A.size();
		
		if(rows == 0)
			return result;
		
		int cols = A.get(0).size();
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i=0; i<rows; i++) {
            
        	for (int j=0; j<cols; j++) {
                
        		ArrayList<Integer> temp;
                
        		if (map.containsKey(i+j)) {
                    temp = map.get(i+j);
                }
                else {
                    temp = new ArrayList<Integer>();
                }

                temp.add(A.get(i).get(j));
                
                map.put(i+j, temp);
            }
        }

        for (int key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
	
	
	}

}
