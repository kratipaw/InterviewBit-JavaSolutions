package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * Example :
 * 
 * Given numerator = 1, denominator = 2, return "0.5"
 * Given numerator = 2, denominator = 1, return "2"
 * Given numerator = 2, denominator = 3, return "0.(6)"
 */

public class Fraction {

	public static void main(String[] args) {

		int A = 1;
		int B = -2;
		
		System.out.println(fractionToDecimal(A, B));
	}

	private static String fractionToDecimal(int A, int B) {
		
		if(A == 0)
			return "0";
		
		StringBuilder result = new StringBuilder("");
		if((A < 0 && B > 0) || (A > 0 && B < 0))
			result.append("-");
		
		long n = A;
		n = Math.abs(n);
		long d = B;
		d = Math.abs(d);
		System.out.println("n : " + n + ", d : " + d);
		
		long quot = n / d;
		
		result.append(quot);
		
		long rem = n % d;
		
		if(rem == 0)
			return result.toString();
		
		result.append(".");
		
		Map<Long, Integer> map = new HashMap<>();
		
		int indx = 0;
		
		boolean repeating = false;
		
		while(rem > 0 && !repeating) {
			
			if(map.containsKey(rem)) {
				indx = map.get(rem);
				repeating = true;
				break;
			}
			
			else 
				map.put(rem, result.length());
			
			rem *= 10;
			
			long tmp = rem / d;
			
			result.append(tmp);
			
			rem = rem % d;
		}
		
		if(repeating) {
			result.append(")");
			String start = result.substring(0, indx);
			return start + "(" + result.substring(indx);
		}
		
		return result.toString();
	}
}
