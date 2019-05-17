import java.util.ArrayList;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 * Sample Input :
 * Ratings : [1 2]
 * 
 * Sample Output : 
 * 3
 * The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor.
 * So rating 2 candidate gets 2 candies. In total, 2+1 = 3 candies need to be given out.
 */
public class DistributeCandy {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		
		System.out.println(candy(A));
	}
	
	private static int candy(ArrayList<Integer> A) {
		
		if(A == null || A.size() == 0)
			return 0;
		
		int N = A.size();
		
		//candies[i] = number of candies given to ith child
		int candies[] = new int[N];
		
		candies[0] = 1;
		
		//From left to right
		for (int i = 1; i < N; i++) {
			if(A.get(i) > A.get(i - 1))
				candies[i] = candies[i-1] + 1;
			else
				candies[i] = 1;
		}
		
		int result = candies[N - 1];
		
		//right to left
		for (int i = N - 2; i >= 0; i--) {
			int cur = 1;
			
			if(A.get(i) > A.get(i+1))
				cur = candies[i+1] + 1;
			
			result += Math.max(cur, candies[i]);
			candies[i] = cur;
		}
		
		return result;
    }

}
