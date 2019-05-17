import java.util.ArrayList;

public class FizzBuzz {

	public static void main(String[] args) {

		ArrayList<String> list = print(15);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "   ");
		}
	}
	
	private static ArrayList<String> print(int A){
		
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 1; i <= A; i++) {
			if(i%3==0 && i%5==0)
				list.add("FizzBuzz");
			else if (i%3 == 0 && i%5!=0)
				list.add("Fizz");
			else if (i%3 != 0 && i%5==0)
				list.add("Buzz");
			else 
				list.add(String.valueOf(i));
			
		}
		
		return list;
	}

}
