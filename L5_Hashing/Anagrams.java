package L5_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
   	Given an array of strings, return all groups of strings that are anagrams. 
   	Represent a group by a list of integers representing the index in the original list. 
   	Look at the sample case for clarification.

	Anagram : a word, phrase, or name formed by rearranging the letters of another, 
	such as 'spar', formed from 'rasp' 
	 
	Note: All inputs will be in lower-case. 
	
	Example :
	
	Input : cat dog god tca
	Output : [[1, 4], [2, 3]]
	cat and tca are anagrams which correspond to index 1 and 4. 
	dog and god are another set of anagrams which correspond to index 2 and 3.
	The indices are 1 based ( the first element has index 1 instead of index 0).
	
	Ordering of the result : You should not change the relative ordering of the 
	words / phrases within the group. Within a group containing A[i] and A[j], 
	A[i] comes before A[j] if i < j.
	 
 */

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
