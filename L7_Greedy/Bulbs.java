package L7_Greedy;

import java.util.ArrayList;

/**
 * 

	N light bulbs are connected by a wire. Each bulb has a switch associated with it, however 
	due to faulty wiring, a switch also changes the state of all the bulbs to the right of 
	current bulb. Given an initial state of all bulbs, find the minimum number of switches 
	you have to press to turn on all the bulbs. You can press the same switch multiple times.
	
	Note : 0 represents the bulb is off and 1 represents the bulb is on.
	
	Example:
	
	Input : [0 1 0 1]
	Return : 4
	
	Explanation :
		press switch 0 : [1 0 1 0]
		press switch 1 : [1 1 0 1]
		press switch 2 : [1 1 1 0]
		press switch 3 : [1 1 1 1]


 */
public class Bulbs {

	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>();
		A.add(0);
		A.add(1);
		A.add(0);
		A.add(1);
		
		System.out.println(new Bulbs().bulbs(A));
	}

	//TLE
	public int bulbs_GaveTLE(ArrayList<Integer> A) {
		
		int count = 0;
		
		for (int i = 0; i < A.size(); i++) {
				
			if(A.get(i) == 0) {
				count++;
				for (int j = i; j < A.size(); j++) {
					if(A.get(j) == 0)
						A.set(j, 1);
					else
						A.set(j, 0);
				}
			}
		}
		
		return count;
    }
	
	public int bulbs(ArrayList<Integer> A) {
        
        if(A.size()==0) 
            return 0;

        int count = 0;
        
        if(A.get(0) == 0) 
            count = 1;
        
        for(int i=0; i< A.size()-1; i++){
            if(A.get(i+1) != A.get(i)) 
                count++;
        }
        
        return count;
    }
}
