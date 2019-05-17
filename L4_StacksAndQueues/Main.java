public class Main {

	public static void main(String[] args) {
		
		MinStack min = new MinStack();
		
		min.push(7);
		min.push(2);
		min.push(5);
		min.push(3);
		min.push(1);
		min.push(9);
		min.push(0);
		
		for (int i = 0; i < min.stack.size(); i++) {
			
			System.out.print(min.stack.get(i) + " ");
		}
		System.out.println();
		
		for (int i = 0; i < min.min.size(); i++) {
			
			System.out.print(min.min.get(i) + " ");
		}
		System.out.println();
		
		min.pop();
		
		System.out.println("Top : " + min.top());
		
		System.out.println("getMin : " + min.getMin());

	}

}
