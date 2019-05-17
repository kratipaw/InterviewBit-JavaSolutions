import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {

		int A = 4;
		int B = 2;
		
		ArrayList<ArrayList<Integer>> result = combine(A, B);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
	
	private static ArrayList<ArrayList<Integer>> combine(int A, int B) {
    
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(A <= 0 || A < B)
			return result;
	
		ArrayList<Integer> curr = new ArrayList<>();
		
		dfs(A, B, curr, 1, result);
		
		return result;
	}
	
	private static void dfs(int A, int B, ArrayList<Integer> curr, int start, ArrayList<ArrayList<Integer>> result) {
		
		if(curr.size() == B) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(curr);
			result.add(tmp);
			return;
		}
		
		for (int i = start; i <= A; i++) {
			
			curr.add(i);
			
			dfs(A, B, curr, i + 1, result);
			
			curr.remove(curr.size() - 1);
			
		}
		
	}

}
