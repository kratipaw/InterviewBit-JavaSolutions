import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSum {

	public static void main(String[] args) {

		System.out.println(primesum(10));
		
	}
	
	private static ArrayList<Integer> primesum(int A) {
    
		ArrayList<Integer> result = new ArrayList<>();

		if(A < 3)
			return result;
		
		boolean isPrime[] = new boolean[A+1];
		
		Arrays.fill(isPrime, true);
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		for (int i = 2; i * i <= A; i++) {
			
			if(isPrime[i]) {
				
				for (int j = i * 2; j <= A; j = j + i) {
					isPrime[j] = false;
				}
			}
		}
		
		for (int i = 0; i <= A ; i++) {
			
			if(isPrime[i] && isPrime[A - i]) {
				result.add(i);
				result.add(A - i);
				
				break;
			}
		}

		return result;
	}

}
