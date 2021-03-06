import java.util.Arrays;

/**
 * Given a string, find if there is any sub-sequence that repeats itself. A
 * sub-sequence of a string is defined as a sequence of characters generated by
 * deleting some characters in the string without changing the order of the
 * remaining characters.
 * 
 * Input: string
 * 
 * Output:
 * 
 * 0/1 0 -> No 1 -> Yes Example:
 * 
 * abab ------> yes, ab is repeated. So, return 1. 
 * abba ------> No, a and b follow different order. So, return 0. 
 * 
 * NOTE : sub-sequence length should be greater than or equal to 2
 */

public class RepeatingSubSequence {

	public static void main(String[] args) {

		String A = "ab";

		System.out.println(solve_viaDP(A) + "  ----------  " + anytwo(A));

		System.out.println(solve_viaDP("aaab") + "  ----------  " + anytwo("aaab"));

		System.out.println(solve_viaDP("aabb") + "  ----------  " + anytwo("aabb"));

		System.out.println(solve_viaDP("abab") + "  ----------  " + anytwo("abab"));

	}

	private static int anytwo(String A) {
		if (A == null || A.length() == 0)
			return 0;

		int n = A.length();

		int freq[] = new int[256];

		Arrays.fill(freq, 0);

		char arr[] = A.toCharArray();

		for (int i = 0; i < n; i++) {

			freq[arr[i]]++;

			if (freq[arr[i]] > 2)
				return 1;

		}

		int k = 0;
		for (int i = 0; i < n; i++)
			if (freq[arr[i]] > 1) {
				arr[k++] = arr[i];
			}

		if (isPali(arr, 0, k - 1)) {
			if (k % 2 == 1 && arr[k / 2] == arr[k / 2 - 1])
				return 1;

			return 0;
		}

		return 1;
	}

	private static boolean isPali(char A[], int left, int right) {

		while (left < right) {
			if (A[left] != A[right])
				return false;

			left++;
			right--;
		}

		return true;
	}

	private static int solve_viaDP(String A) {

		int n = A.length();

		int dp[][] = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (A.charAt(i - 1) == A.charAt(j - 1) && i != j)
					dp[i][j] = 1 + dp[i - 1][j - 1];

				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		
		
		return dp[n][n] > 1 ? 1 : 0;
	}
}
