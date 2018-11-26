package L5_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

	public static void main(String[] args) {

		List<String> a = new ArrayList<>();
		a.add("cat");
		a.add("dog");
		a.add("god");
		a.add("tca");
		
		ArrayList<ArrayList<Integer>> result = new Anagrams().anagrams(a);
		for(ArrayList<Integer> ll : result) {
			System.out.println(ll.toString());
		}
	}
	
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(a == null || a.size() == 0)
			return result;
		
		int n = a.size();
		
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			
			char[] tmp = a.get(i).toCharArray();
			Arrays.sort(tmp);
			
			String key = String.valueOf(tmp);

			ArrayList<Integer> list = null;
			
			if(map.containsKey(key))
				list = map.get(key);
			
			else
				list = new ArrayList<>();
			
			list.add(i + 1);
			
			map.put(key, list);
		}
		
		for(ArrayList<Integer> ll : map.values()) {
			result.add(ll);
		}
		
		return result;
	}

}
