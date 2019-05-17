/**
 * Given a number N, return number of ways you can draw N chords in a circle 
 * with 2*N points such that no 2 chords intersect.
 * Two ways are different if there exists a chord which is present in one way and 
 * not in other.
 * 
 * For example,
 * 
 * N=2
 * If points are numbered 1 to 4 in clockwise direction, then different ways to 
 * draw chords are:
 * {(1-2), (3-4)} and {(1-4), (2-3)}
 * 
 * So, we return 2.
 * Notes:
 * 
 * 1 ≤ N ≤ 1000
 * Return answer modulo 109+7.
 * 
 */
public class IntersectingChordInCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N; 
        N = 2; 
        System.out.println(chordCnt(N)); 
        N = 1; 
        System.out.println(chordCnt(N)); 
        N = 4; 
        System.out.println(chordCnt(N)); 
        N = 3;
        System.out.println(chordCnt(N));
        N = 20;  //ans = 564120378
        System.out.println(chordCnt(N));
        
        N = 31;  //ans = 937414464
        System.out.println(chordCnt(N));
        
	}

	private static int chordCnt(int A) {
        
        int points = 2 * A;
        
        long dp[] = new long[points + 1];
        
        dp[0] = 1;
        
        dp[2] = 1;
        
        for (int i = 4; i <= points; i+=2) {
            for (int j = 0; j < i; j+=2) {
                dp[i] = (dp[i] + dp[j] * dp[i - j -2]) % 1000000007;
            }
        }
       
        return  (int) (dp[points]);
    }

}
