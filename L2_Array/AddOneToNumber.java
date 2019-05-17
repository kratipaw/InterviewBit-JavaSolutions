import java.util.ArrayList;

public class AddOneToNumber {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		
		A.add(0);
		A.add(6);
		A.add(0);
		A.add(6);
		A.add(4);
		A.add(8);
		A.add(8);
		A.add(1);
		
		
		/*A.add(0);
		A.add(0);
		A.add(0);
		A.add(1);
		A.add(0);
		A.add(2);
		A.add(0);
		A.add(3);*/
		
		
		ArrayList<Integer> result = new ArrayList<>();
		
		result = plusOne(A);

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
	}

	private static void printArrayList(ArrayList<Integer> A) {
		for (int i = 0; i < A.size(); i++) {
			System.out.print(A.get(i));
		}
        System.out.println();
	}
	
	private static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        
		ArrayList<Integer> result = new ArrayList<>();
		
        int n = A.size();
        
        for (int i = 0; i < A.size(); i++) {
			if(A.get(i) != 0)
				break;
			else
			{
				A.remove(i);
				//if(i != 0)
					i = i -1;
				
			}
		}
        
        n = A.size();
        
        if(n == 0) {
        	result.add(1);
        	return result;
        }
        
        int carry = 0, sum = 0;
        
        for (int i = n - 1; i >= 0; i--) {
			
        	if(i == n -1)
        		sum = A.get(i).intValue() + 1;
        	else
        		sum = A.get(i).intValue() + carry;
        	
        	if(sum>=10)
        		carry = 1;
        	else
        		carry = 0;
        	
        	sum = sum % 10;
        	
        	result.add(sum);
		}
        
        if(carry>0)
        	result.add(carry);
        
        int size = result.size();
        
        for (int i = 0; i < size/2; i++) {
        	
        	int temp = result.get(i);
			result.set(i, result.get(size-1-i));
			result.set(size-1-i, temp);
		}
        
        return result;
    }
}
