import java.util.ArrayList;

public class RemoveDupsFromSortedArray {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		a.add(5000);
		a.add(5000);
		a.add(5000);
		/*a.add(2);
		a.add(2);
		a.add(4);
		a.add(5);
		a.add(5);
		a.add(5);
		a.add(7);
		a.add(7);*/
		
		System.out.println("Original Length : " + a.size());
		
		System.out.println(removeDuplicates(a));
	}
	
	private static int removeDuplicates(ArrayList<Integer> a) {
		
		int j = 0;
		
		for (int i = 0; i < a.size()-1; i++) {
			if(a.get(i).intValue()!=a.get(i+1).intValue()) {
				
				a.set(j, a.get(i));
				j++;
			}
		}
		
		a.set(j, a.get(a.size()-1));
		j++;
		
		a.subList(j, a.size()).clear();
		
		return a.size();
    }

}
