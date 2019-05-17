import java.util.ArrayList;
import java.util.List;

public class SearchForRange {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		
		a.add(5);
		a.add(7);
		a.add(7);
		a.add(8);
		a.add(8);
		a.add(10);
		
		int b = 5;
		
		ArrayList<Integer> res = searchRange(a, b);
		
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + "  ");
		}
	}
	
	private static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		
		ArrayList<Integer> result = new ArrayList<>();
		
		int upper = helper(a, b, true);
		int lower = helper(a, b, false);
		
		result.add(lower);
		result.add(upper);
		
		return result;
	}
	
	private static int helper(final List<Integer> a, int b, boolean flag) {
		
		int left = 0;
		
		int right = a.size()-1;
		
		int res = -1;
		
		while(left<=right) {
			
			int mid = left + (right-left)/2;
			
			if(a.get(mid).intValue() == b) {
				res = mid;
				
				if(flag)
					left = mid+1;
				else
					right = mid-1;
					
					
			}
			else if (a.get(mid).intValue()< b)
				left = mid+1;
			else
				right = mid-1;
			
		}
		
		return res;
		
	}

}
