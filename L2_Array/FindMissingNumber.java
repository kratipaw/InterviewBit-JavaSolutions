import java.util.ArrayList;

public class FindMissingNumber {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		/*
		A.add(1);
		A.add(2);
		A.add(0);
		*/
		/*
		A.add(3);
		A.add(4);
		A.add(-1);
		A.add(1);
		*/
		
		A.add(-8);
		A.add(-7);
		A.add(-6);
		A.add(2);
		//A.add(3);
		
		
		System.out.println(firstMissingNumber(A));
		
	}
	
	private static int firstMissingNumber(ArrayList<Integer> A) {
		
		int j = 0;
			
		int n = A.size();
		
		for (int i = 0; i < n; i++) {
			
			if(A.get(i)<=0) {
				int temp = A.get(i);
				A.set(i, A.get(j));
				A.set(j, temp);
				j++;
			}
		}
		
		ArrayList<Integer> B = new ArrayList<>();
		
		for (int i = j; i < A.size(); i++) {
			B.add(A.get(i));
		}
		
		for (int k = 0; k < B.size(); k++) {
			
			if(Math.abs(B.get(k)) - 1 <B.size() && B.get(Math.abs(B.get(k)) - 1)>0) {
				B.set(Math.abs(B.get(k)) - 1, -B.get(Math.abs(B.get(k)) - 1));
			}
		}
		
		
		for (int k = 0; k < B.size(); k++) {
			if(B.get(k)>0)
				return k+1;
		}
		
		return B.size()+1;
	}
}
