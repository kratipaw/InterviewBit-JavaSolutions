import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {

		String A = "(a + (b+c))";
		
		System.out.println(braces(A));
	}
	
	private static int braces(String A) {
    
		int n = A.length();
		
		if(n == 0)
			return 0;
		
		char tok[] = A.toCharArray();
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			char ch = tok[i];
			if(ch == ')')
			{
				char top = stack.peek();
				stack.pop();
				
				boolean flag = true;
				
				while(top!='(') {
					
					if(top == '+' || top == '-' || top == '*' || top == '/') {
						flag = false;
					}

					top = stack.peek();
					stack.pop();
				}

				if(flag == true)
					return 1;
			}
			else if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') 
				stack.push(ch);
			
		}
		
		return 0;
	
	}

}
