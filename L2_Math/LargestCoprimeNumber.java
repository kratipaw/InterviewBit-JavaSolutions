public class LargestCoprimeNumber {

	public static void main(String[] args) {

		int A = 30;
		
		int B = 12;
		
		System.out.println(cpFact(A, B));
		
	}
	
	private static int cpFact(int A, int B) {
		
		while(gcd(A, B) != 1) {
			A = A/gcd(A,B);
		}
		
		return A;
    }

	private static int gcd(int a, int b) {
		
		/*if(a == 0 || b == 0)
			return 0;
		
		if(a == b)
			return a;
		
		if(a>b)
			return gcd(a-b, b);
		
		return gcd(a, b-a);*/
		
		if( b == 0)
			return a;
		
		return gcd(b, a%b);
		
	}
}
