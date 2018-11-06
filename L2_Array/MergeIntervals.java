package L2_Array;

import java.util.ArrayList;

public class MergeIntervals {

	public static void main(String[] args) {

		ArrayList<Interval> intervals = new ArrayList<>();
		
		Interval i2 = new Interval(1, 3);
		intervals.add(i2);
		Interval i1 = new Interval(6, 9);
		intervals.add(i1);
		/*Interval i3 = new Interval(3, 5);
		intervals.add(i3);
		Interval i4 = new Interval(8, 10);
		intervals.add(i4);
		
		Interval i5 = new Interval(15, 24);
		intervals.add(i5);
		*/
		Interval newIntnerval = new Interval(4, 12);
		
		ArrayList<Interval> result = insert(intervals, newIntnerval);
		
		printArrayList(result);
	}
	
	private static void printArrayList(ArrayList<Interval> A) {
		for (int i = 0; i < A.size(); i++) {
			System.out.print("(" + A.get(i).start + ", " + A.get(i).end + ")");
		}
        System.out.println();
	}

	private static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		ArrayList<Interval> result = new ArrayList<>();
		
		int n = intervals.size();
		
		for (int i = 0; i < n; i++) {
			Interval curr = intervals.get(i);
			
			//if curr is less than newInterval,(i.e.curr comes before newInterval in sorted order)
			//add curr to result
			if(curr.end< newInterval.start) {
				result.add(curr);
			}
			//if curr is greater than newInterval,(i.e. newInterval after curr in sorted order)
			//then simpley add newInterval and then complete list from curr to end in result.
			else if(curr.start> newInterval.end) {
				
				result.add(newInterval);
				result.addAll(intervals.subList(i, n));
				return result;
			}
			//if newInterval is overlapping, then first merge it and again compare with next element
			else {
				int start = Math.min(curr.start, newInterval.start);
				int end = Math.max(curr.end, newInterval.end);
				newInterval.start = start;
				newInterval.end = end;
			}
		}
		
		result.add(newInterval);
		
        return result;
    }
}
