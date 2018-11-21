package L3_TwoPointers;

import java.util.ArrayList;

public class MergeTwoSortedList_2 {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(5);
		a.add(8);
		
		ArrayList<Integer> b = new ArrayList<>();
		b.add(6);
		b.add(9);
		
		merge(a, b);
		
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + "  ");
		}
	}

	private static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
    
		int i = 0;
		int j = 0;
		
		while(j<b.size()) {
			
			if(i == a.size() || a.get(i).intValue()>b.get(j).intValue()) {
				a.add(i, b.get(j));
				j++;
			}
			
			i++;
		}
		
	}
}
