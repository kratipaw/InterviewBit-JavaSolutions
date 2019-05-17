import java.util.Stack;

public class MinStack {

	int top = -1;
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	
	public void push(int x) {

		int prev = 0;
		if(!min.isEmpty()) {
			prev = min.pop();
			min.add(prev);
			
			top = top + 1;
			stack.add(top, x);
			
			if(x>=prev)
				min.add(prev);
			else
				min.add(x);
		}
		else {
			top = top + 1;
			stack.add(top, x);
			min.add(top, x);
		}
		
		
		
	}

    public void pop() {
        if(top>= 0) {
        	stack.pop();
        	min.pop();
        	top--;
        }
    }

    public int top() {
    	if(top>=0) 
    		return stack.get(top);
    		
    	
    	return -1;
    }

    public int getMin() {
        
    	if(!min.isEmpty()) {
    		int res = min.pop();
    		min.add(res);
    		
    		return res;
    	}
    	
    	return -1;
    		
    }
}
