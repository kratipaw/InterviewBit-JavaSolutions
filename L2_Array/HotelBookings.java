import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBookings {
	
	public static void main(String[] args){    
	
	}
	
	private static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		
		if(arrive == null || arrive.size() == 0|| depart == null || depart.size() == 0 || depart.size() != arrive.size() || K < 1)
                return false;
             
		Collections.sort(arrive);
		Collections.sort(depart);

		int n = arrive.size();

		int curr = 1;

		int max = 1;

		int i = 1, j = 0;

		while(i < n && j < n) {

		    if(arrive.get(i) < depart.get(j)) {

			curr++;

			max = Math.max(max, curr);

			i++;
		    }

		    else {

			curr--;

			j++;
		    }
		}

		return K >= max;
	}
}
