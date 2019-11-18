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

	public int ladderLength_tle(String start, String end, ArrayList<String> dictV) {
    
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
	
	class Pair {
        
        String key;
        int value;
        
        public Pair(String s, int v){
            key = s;
            value = v;
        }
        
        public String getKey() {
            return key;
        }
        
        public int getValue() {
            return value;
        }
    }
    
    public int solve(String A, String B, ArrayList<String> C) {
        
        Set<String> dict = new HashSet<>(C);
        Set<String> start = new HashSet<>();
        start.add(A);
        dict.remove(A);
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        while(!start.isEmpty()) {
            if (start.contains(B)) {
                break;
            }
            
            Set<String> set = new HashSet<>();
            for (String word : start) {
                ArrayList<String> relatedWords = getRelatedWords(word, dict);
                if (!relatedWords.isEmpty()) {
                    map.put(word, relatedWords);
                    set.addAll(relatedWords);
                }
            }
            
            dict.removeAll(set);
            start = set;
        }
        
        Queue<Pair> qu = new LinkedList<Pair>();
        
        qu.add(new Pair(A, 1));
        
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(A, true);
        
        while(!qu.isEmpty()){
         
            Pair node = qu.poll();
            
            String curr = node.getKey();
            int level = node.getValue();
            
            ArrayList<String> relatedWords = map.getOrDefault(curr, new ArrayList<String>());
                
            for(String relatedWord : relatedWords){
                if(relatedWord.equalsIgnoreCase(B)){
                    return level + 1;
                }

                if(!visited.containsKey(relatedWord)){
                    visited.put(relatedWord, true);
                    Pair newEntry = new Pair(relatedWord, level + 1);
                    qu.add(newEntry);
                }
            }
        }
        
        return 0;
    }
    
    public ArrayList<String> getRelatedWords(String word, Set<String> dict) {
        
        ArrayList<String> relatedWords = new ArrayList<String>();
        
        char[] wordArr = word.toCharArray();
        
        for(int i = 0; i < wordArr.length; i++){
            
            char ch = word.charAt(i);
            
            for(char c = 'a'; c <= 'z'; c++){
                
                if(c == ch)
                    continue;
                
                wordArr[i] = c;
                
                String newWord = String.valueOf(wordArr);
                if(dict.contains(newWord))
                    relatedWords.add(newWord);
            }
            wordArr[i] = ch;
        }
        
        return relatedWords;
    }
}
