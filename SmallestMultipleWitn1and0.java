package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * You are given an integer N. You have to find smallest multiple of N which
 * consists of digits 0 and 1 only. Since this multiple could be large, return
 * it in form of a string.
 * 
 * Note:
 * 
 * Returned string should not contain leading zeroes.
 * 
 * For example,
 * 
 * For N = 55, 110 is smallest multiple consisting of digits 0 and 1. For N = 2,
 * 10 is the answer.
 * 
 * 
 */

public class SmallestMultipleWitn1and0 {

	public static void main(String[] args) {

		int A = 12;

		System.out.println(new SmallestMultipleWitn1and0().multiple(A));
	}

	// Gives TLE
	/*
	 * public String multiple_TLE(int A) {
	 * 
	 * Queue<String> qu = new LinkedList<String>();
	 * 
	 * HashSet<Integer> set = new HashSet<>();
	 * 
	 * qu.add("1");
	 * 
	 * while(!qu.isEmpty()){
	 * 
	 * String tmp = qu.poll();
	 * 
	 * int rem = mod(tmp, A);
	 * 
	 * if(rem == 0) return tmp;
	 * 
	 * else if(!set.contains(rem)) {
	 * 
	 * set.add(rem); qu.add(tmp + "0"); qu.add(tmp + "1"); } }
	 * 
	 * return ""; }
	 * 
	 * public int mod(String str, int A) {
	 * 
	 * int num = 0; System.out.println("string : " + str); for (int i = 0; i <
	 * str.length(); i++) {
	 * 
	 * System.out.println("Before : num = " + num);
	 * 
	 * num = num * 10 + (str.charAt(i) - '0');
	 * 
	 * System.out.println("After : num = " + num);
	 * 
	 * num = num % A; }
	 * 
	 * return num; }
	 */

	public String multiple(int A) {

		String result = "0";

		if (A > 0) {

			boolean[] isVisited = new boolean[A];
			Arrays.fill(isVisited, false);

			Queue<Node> queue = new LinkedList<>();

			queue.add(new Node(true, 1 % A, null));
			isVisited[1 % A] = true;

			Node destNode = null;

			while (!queue.isEmpty()) {

				Node currNode = queue.remove();

				if (currNode.val == 0) {
					// We have reached a valid multiple of num
					destNode = currNode;
					break;
				} else {
					// Visit the next 2 neighbors
					// Append 0 - (currNode.val * 10)
					// Append 1 - (currNode.val * 10) + 1

					// Append a '0'
					int val1 = (currNode.val * 10) % A;
					if (!isVisited[val1]) {
						queue.add(new Node(false, val1, currNode));
						isVisited[val1] = true;
					}

					// Append a '1'
					int val2 = (val1 + 1);
					if (val2 == A) {
						val2 = 0;
					}
					if (!isVisited[val2]) {
						queue.add(new Node(true, val2, currNode));
						isVisited[val2] = true;
					}
				}
			}

			// Trace the path from destination to source
			if (destNode == null) {
				throw new IllegalStateException("Result should not be null");
			} else {
				StringBuilder reverseResultBuilder = new StringBuilder();
				Node currNode = destNode;
				while (currNode != null) {
					reverseResultBuilder.append(currNode.isDigitOne ? '1' : '0');
					currNode = currNode.prev;
				}
				result = reverseResultBuilder.reverse().toString();
			}
		}

		return result;

	}

}

class Node {
	public boolean isDigitOne;
	public int val;
	public Node prev;

	public Node(boolean isDigitOne, int val, Node prev) {
		this.isDigitOne = isDigitOne;
		this.val = val;
		this.prev = prev;
	}
}
