import java.util.ArrayList;

public class RemoveElementFromArray {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		
		a.add(22);
		a.add(21);
		a.add(22);
		a.add(28);
		a.add(27);
		a.add(23);
		a.add(22);
		a.add(20);
		a.add(22);
		
		int b = 21;
		
		System.out.println(removeElement(a, b));
		
		int arr[] = {2, 4, 5, 6, 2, 1, 2, 2, 2};
		int b1 = 2;
		
		System.out.println(removeElement(arr, b1));
	}
	
	private static int removeElement(ArrayList<Integer> a, int b) {
		
		int j = 0;
		
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i) != b) {
				a.set(j, a.get(i));
				j++;
			}
		}
		
		a.subList(j, a.size()).clear();
		
		return a.size();
    }
	
	private static int removeElement(int a[], int b) {
		
		int j = 0;
		
		System.out.println("Original len : " + a.length);
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] != b) {
				a[j] = a[i];
				j++;
			}
		}
		
		
		
		return j;
    }

}
