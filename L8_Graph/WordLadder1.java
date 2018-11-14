package L8_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence
 * from start to end, such that:
 * 
 * You must change exactly one character in every transformation
 * Each intermediate word must exist in the dictionary
 * 
 * Example :
 * 
 * Given:
 * 
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note that we account for the length of the transformation path instead of the 
 * number of transformation itself.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lower-case alphabetic characters.
 * 
 */
public class WordLadder1 {

	public static void main(String[] args) {

		String start = "hit";
		
		String end = "cog";
		
		ArrayList<String> dictV = new ArrayList<>();
		dictV.add("hot");
		dictV.add("dot");
		dictV.add("dog");
		dictV.add("lot");
		dictV.add("log");
		
		System.out.println(new WordLadder1().ladderLength(start, end, dictV));
	}

	public int ladderLength(String start, String end, ArrayList<String> dictV) {
    
		Queue<String> qu = new LinkedList<String>();
        
		qu.add(start);
        
		dictV.add(end);
		int count = 1;
        
        while(!qu.isEmpty()){
            
            int size = qu.size();
            
            for(int j = 0; j < size; j++){
                String word = qu.remove();
                
                if(word.equals(end)){
                    return count;
                }
                
                for(int i = 0; i < word.length(); i++){
                    
                	for(char c = 'a'; c <= 'z'; c++){
                        if(c != word.charAt(i)){
                            char[] s = word.toCharArray();
                            s[i] = c;
                            String tmp = new String(s);
                            
                            if(dictV.contains(tmp)){
                                qu.add(tmp);
                                dictV.remove(tmp);
                            }
                        }
                    }
                }
            }
            
            count++;
        }
        
        return 0;
	}
}
