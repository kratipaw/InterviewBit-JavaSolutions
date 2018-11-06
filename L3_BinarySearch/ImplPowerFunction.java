package L3_BinarySearch;

public class ImplPowerFunction {

	public static void main(String[] args) {

		//System.out.println(99%13);
		//System.out.println(5000%13);
		/*
		int x = 71045970;
		int n = 41535484;
		int d = 64735492;
		*/
		
		int x = 2;
		int n = 4;
		int d = 5;
			
		System.out.println(pow(x, n, d));
		
	}

	private static int pow(int x, int n, int d) {
		
		long res = 1;
        long aux = x%d;
        System.out.println("aux : " + aux);
        while (n > 0) {
        	System.out.println("loop start");
            if (n%2 == 1) {
                res = res*aux%d;
                System.out.println("res : " + res);
            }
            aux = aux*aux%d;
            System.out.println("aux : " + aux);
            n = n/2;
            System.out.println("loop end");
        }
        if (res < 0)
            res = d + res;
        return (int) res%d;
        
		
    }
}
