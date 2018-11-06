package L2_Array;

import java.util.ArrayList;

public class SortByColor {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(0);
		
		sortColors(a);
		
		
		
	}
	
	public static void sortColors(ArrayList<Integer> a) {
		
		int low = 0;
        int high = a.size() - 1;
        int mid = 0,temp=0;
        while (mid <= high)
        {
            switch (a.get(mid))
            {
	            case 0:
	            {
	                temp   =  a.get(low);
	                a.set(low,a.get(mid));
	                a.set(mid, temp);
	                low++;
	                mid++;
	                break;
	            }
	            case 1:
	                mid++;
	                break;
	            case 2:
	            {
	                temp = a.get(mid);
	                a.set(mid, a.get(high));
	                a.set(high, temp);
	                high--;
	                break;
	            }
            }
        }
        
        for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + "  ");
		}
    }

}
