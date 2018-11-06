package L2_Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {

		ArrayList<Interval> intervals = new ArrayList<>();
		
		Interval i2 = new Interval(1, 56);
		intervals.add(i2);
		Interval i1 = new Interval(1, 3);
		intervals.add(i1);
		Interval i3 = new Interval(3, 5);
		intervals.add(i3);
		Interval i4 = new Interval(8, 10);
		intervals.add(i4);
		
		Interval i5 = new Interval(15, 24);
		intervals.add(i5);
		
		ArrayList<Interval> result = merge(intervals);
		
		printArrayList(result);
	}

	private static void printArrayList(ArrayList<Interval> A) {
		for (int i = 0; i < A.size(); i++) {
			System.out.print("(" + A.get(i).start + ", " + A.get(i).end + ")");
		}
        System.out.println();
	}
	
	private static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		/*int n = intervals.size();
		
		if(n<2)
			return intervals;
		
		Collections.sort(intervals, new Comparator<Interval>() {
				public int compare(Interval a, Interval b)
			    {
			        return b.start - a.start;
			    }
			}
		);
		
		ArrayList<Interval> result = new ArrayList<>();
		
		int indx = 0;
		
		for (int i = 0; i < n; i++) {
			
			if(indx!=0 && result.get(indx - 1).start <= intervals.get(i).end) {
				while (indx != 0 && result.get(indx - 1).start <= intervals.get(i).end)
	            {
					result.get(indx-1).end = Math.max(result.get(indx-1).end, intervals.get(i).end);
					result.get(indx-1).start = Math.min(result.get(indx-1).start, intervals.get(i).start);
					indx--;
	            }
			}
			else
				result.add(intervals.get(i));
			
			indx++;
		}
		
		Collections.sort(result, new Comparator<Interval>() {
			public int compare(Interval a, Interval b)
		    {
		        return a.start - b.start;
		    }
		
			}
		);
		
		return result;*/

		int n = intervals.size();
		
		if(n<2)
			return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {
				public int compare(Interval a, Interval b)
			    {
			        return a.start - b.start;
			    }
			}
        );
        
        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start <= end){
                end = Math.max(current.end, end);
            }else{
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
            
        }
        
        result.add(new Interval(start, end));
        
        return result;
		
    }
}
