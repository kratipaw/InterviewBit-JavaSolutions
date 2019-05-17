import java.util.ArrayList;
import java.util.List;

/**
 * 
	There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
	
	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to 
	its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
	
	Return the minimum starting gas station’s index if you can travel around the circuit once, 
	otherwise return -1.
	
	You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
	Completing the circuit means starting at i and ending up at i again.
	
	Example :
	
	Input :
	      Gas :   [1, 2]
	      Cost :  [2, 1]
	
	Output : 1 
	
	- If you start from index 0, you can fill in gas[0] = 1 amount of gas. Now your tank has 1 unit of gas.
	  But you need cost[0] = 2 gas to travel to station 1. 
	- If you start from index 1, you can fill in gas[1] = 2 amount of gas. Now your tank has 2 units of gas.
	  You need cost[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in gas[0] = 1 unit of additional gas, making your current gas = 2. It costs you cost[0] = 2 to get to station 1, which you do and complete the circuit. 

 */

public class GasStation {

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		
		List<Integer> B = new ArrayList<>();
		B.add(2);
		B.add(1);
		
		System.out.println(new GasStation().canCompleteCircuit(A, B));
		
	}

	//Technique used is 'Sliding Window Maximum' : We enque the gas station till we complete the tour of the 
	// the gas becomes negative. If becomes negative then deque the gas stations till it becomes positive. 
	// Here enqueing and dequeing is done via start and end index.
	//TC = O(n) & SC = O(1)
	public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
    
		int n = A.size();
		
		if(n ==1 && A.get(0) >= B.get(0))
			return 0;
		
		int start = 0;
		int end = 1;
		
		int curr_gas = A.get(0) - B.get(0);
		
		while(curr_gas < 0 || start != end) {
			
			while(curr_gas < 0 && start != end) {
				
				curr_gas -= (A.get(start) - B.get(start));
				
				start = (start + 1) % n;
				
				if(start == 0)
					return -1;
			}
			
			curr_gas += A.get(end) - B.get(end);
			
			end = (end + 1) % n;
		}
		
		return start;
	}
}
