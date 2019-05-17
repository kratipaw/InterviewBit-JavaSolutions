import java.util.ArrayList;

public class SortedInsertPosition {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		/*A.add(1);
		A.add(3);
		A.add(5);
		A.add(6);
		*/
		int b = 0;
		
		System.out.println(searchInsert(A, b));
	}
	
	private static int searchInsert(ArrayList<Integer> a, int b) {
    
		if(a.size() == 0)
			return 0;
		
		int start = 0;
		
		int end = a.size()-1;
		
		if(a.get(end)<b)
			return end+1;
		else if(a.get(start)>b)
			return start;
			
		int result = 0;
		
		while(start<=end) {
			
			int mid = start + (end-start)/2;
			
			if(a.get(mid) == b)
				return mid;
			
			else if(a.get(mid)<b) {
				start = mid+1;
			}
			else {
				end = mid-1;
				result = mid;
			}
		}
		
		return result;
	}

}
