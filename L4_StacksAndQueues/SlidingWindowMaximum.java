import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		A.add(6);
		A.add(7);
		A.add(8);
		A.add(9);
		A.add(10);
		
		int B = 3;
		
		/*ArrayList<Integer> res = slidingMaximum(A, B);
		
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}*/
		
		System.out.println();
		
		//int arr[]={10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int arr[]={12, 1, 78, 90, 57, 89, 56};
        int k=3;
        
        sliding(arr, k);
	}
	
	private static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
    
		Deque<Integer> deque = new LinkedList<Integer>();

		ArrayList<Integer> result = new ArrayList<>();
        
		int i;
        
		for(i = 0; i < B; ++i)
        {
            
            while(!deque.isEmpty() && A.get(i) >= A.get(deque.peekLast()))
            	deque.removeLast();   
             
            deque.addLast(i);
        }
        
        int n = A.size();
        
        for( ;i < n; ++i)
        {
            result.add(A.get(deque.peek()));
             
         // Remove the elements which are out of this window
            while((!deque.isEmpty()) && deque.peek() <= i-B)
            	deque.removeFirst();
             
           System.out.println(deque.toString());
            
            while((!deque.isEmpty()) && A.get(i) >= A.get(deque.peekLast()))
            	deque.removeLast();
            
            deque.addLast(i);
             
        }
         
        result.add(A.get(deque.peek()));
	
        return result;
        
	}
	
	private static void sliding(int arr[], int k){
		
		int n = arr.length;
		
		Deque<Integer> Qi = new LinkedList<Integer>();
        
        /* Process first k (or first window) elements of array */
        int i;
        for(i = 0; i < k; ++i)
        {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();   // Remove from rear
             
            // Add new element at rear of queue
            Qi.addLast(i);
        }
         
        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < n; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
             
            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-k)
                Qi.removeFirst();
            //System.out.println(Qi.toString());
            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
             
 
            // Add current element at the rear of Qi
            Qi.addLast(i);
             
        }
         
        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
	}

}
