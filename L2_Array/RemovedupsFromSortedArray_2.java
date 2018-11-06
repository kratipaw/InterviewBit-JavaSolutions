package L2_Array;

import java.util.ArrayList;

public class RemovedupsFromSortedArray_2 {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		
		a.add(5000);
		a.add(5000);
		a.add(5000);
		a.add(2);
		a.add(2);
		a.add(2);
		
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + "  ");
		}
		System.out.println();
		System.out.println(removeDuplicates(a));
	}

	private static int removeDuplicates(ArrayList<Integer> a) {
    
		boolean flag = false;
		int j = 0;
		int i = 0;
		for (i = 0; i < a.size()-1; i++) {
			
			if(a.get(i).intValue() != a.get(i+1).intValue()) {
				flag = false;
				a.set(j, a.get(i));
				j++;
			}
			else if(a.get(i).intValue() == a.get(i+1).intValue() && !flag) {
				flag = true;
				a.set(j, a.get(i));
				j++;
			}
			else if (a.get(i).intValue() == a.get(i+1).intValue() && flag)
				continue;
			
		}
		if(a.size()>2) {
		if(a.get(i-1).intValue() == a.get(a.size()-1).intValue() && !flag) {
			a.set(j, a.get(a.size()-1));
			j++;
		}
		}
		
		a.subList(j, a.size()-1).clear();
				
		return a.size();
		
	}
}
