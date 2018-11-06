package L2_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBookings {
	
	public static void main(String[] args){
        
        ArrayList<Integer> arrive = new ArrayList<Integer>();
        ArrayList<Integer> depart = new ArrayList<Integer>();
        arrive.add(1);
        arrive.add(2);
        arrive.add(3);
        arrive.add(4);
        
        depart.add(10);
        depart.add(2);
        depart.add(6);
        depart.add(14);
        
        if(!hotel(arrive,depart, 4))
        	System.out.print("Cannot be ");
        System.out.println("Accomodated");
    }
	
	private static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		if(arrive == null || arrive.size() == 0|| depart == null || depart.size() == 0 || depart.size() != arrive.size() || K < 1)
	            return false;
	         
	         Collections.sort(arrive);
	         Collections.sort(depart);
	         System.out.println("Arrive : " + arrive);
	         System.out.println("Depart : " + depart);
	         int aIndex = 0;
	         int dIndex = 0;
	         
	         int currentRooms = 0;
	         int max =0;
	         while(aIndex < arrive.size()){
	             if(arrive.get(aIndex) < depart.get(dIndex)) {
	                 aIndex++;
	                 currentRooms++;
	                 max = Math.max(max, currentRooms);
	             }
	             else {
	                 dIndex++;
	                 currentRooms--;
	             }
	         }
	         System.out.println("max : " + max);
	         return max <= K;

	}
	
	private static boolean hotel_effi(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        if(arrive == null || arrive.size() == 0|| depart == null || depart.size() == 0 || depart.size() != arrive.size() || K < 1)
            return false;
        HotelInterval[] intervals = new HotelInterval[arrive.size()];
        for(int i = 0; i < arrive.size(); i++){
            intervals[i] = new HotelInterval(arrive.get(i), depart.get(i));            
        }
        
        Arrays.sort(intervals);
        
        int rooms = K;
        rooms--;
        for(int i = 1; i < intervals.length; i++){
            if(rooms > 0){
                rooms--;
                continue;
            }
            else if(intervals[i].a < intervals[i-1].d){
                return false;
            }
            
        }
        
        return true;
    }
	
}

class HotelInterval{

	int a;
    int d;
    public HotelInterval(int a, int d){
        this.a = a;
        this.d = d;            
    }
    
    public int compareTo(HotelInterval that){
        return this.a - that.a;
    }
}
