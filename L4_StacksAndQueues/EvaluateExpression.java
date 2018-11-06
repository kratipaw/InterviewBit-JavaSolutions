package L4_StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {

		ArrayList<String> A = new ArrayList<>();
		/*
		A.add("2");
		A.add("1");
		A.add("+");
		A.add("3");
		A.add("*");
		*/
		/*
		A.add("4");
		A.add("13");
		A.add("5");
		A.add("/");
		A.add("+");
		*/
		
		A.add("2");
		A.add("2");
		A.add("/");
		
		System.out.println(evalRPN(A));
		
				
	}
	
	private static int evalRPN(ArrayList<String> A) {
    
		int n = A.size();
		
		if(n == 0)
			return 0;
		
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			
			String curr = A.get(i);
			
			if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")) {
				
				if(!st.isEmpty()) {
					
					int operand2 = st.pop();
					
					int operand1 = st.pop();
					
					int result = calculate(operand1, operand2, curr);
					
					st.push(result);
				}
			}
			
			else
				st.push(Integer.parseInt(curr));
			
		}
	
		return st.peek();
	}

	private static int calculate(int a, int b, String op) {
		
		int result = 0;
		
		switch (op) {
		case "+":
			result = a + b;
			break;

		case "-":
			result = a - b;
			break;

		case "*":
			result = a * b;
			break;

		case "/":
			if(b != 0)
				result = a / b;
				
			break;

		default:
			break;
		}
		
		return result;
	}
}
