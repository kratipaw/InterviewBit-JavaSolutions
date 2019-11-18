package L6_Tree;

/**

Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

 You are expected to use Trie in an Interview for such problems 

Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)
Input:

S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
Example:

Input: 
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]

*/

public class HotelReviews {
  
  class TrieNode {
        
        TrieNode[] children = null;
        boolean isEndOfWord = false;
        
        public TrieNode() {
        
            children = new TrieNode[26];
            isEndOfWord = false;
        
            for(int i = 0; i < 26; i++)
                children[i] = null;
        }
    }
    
    public void insert(TrieNode root, String word) {
        
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null)
                root.children[idx] = new TrieNode();
            
            root = root.children[idx];
        }
        
        root.isEndOfWord = true;
    }
    
    public boolean search(TrieNode root, String word) {
        
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null)
                return false;
            
            root = root.children[idx];
        }
        
        return root != null && root.isEndOfWord;
    }
    
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        if(A == null || B == null || A.isEmpty() || B.isEmpty())
            return result;
        
        String[] goodWords = A.split("_");
        
        TrieNode root = new TrieNode();
        
        for(int i = 0; i < goodWords.length; i++) {
            insert(root, goodWords[i]);
        }
        
        HashMap<Integer, ArrayList<Integer>> matchesToIndex  = new HashMap<>();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < B.size(); i++) {
            
            String review = B.get(i);
            
            int matches = 0;
            
            String[] words = review.split("_");
            
            for(int j = 0; j < words.length; j++) {
                
                if(search(root, words[j]))
                    matches++;
            }
            
            if(matches < min)
                min = matches;
                
            if(matches > max)
                max = matches;
                
            if(!matchesToIndex.containsKey(matches))
                matchesToIndex.put(matches, new ArrayList<Integer>());
                
            ArrayList<Integer> idxList = matchesToIndex.get(matches);
            
            idxList.add(i);
            
            matchesToIndex.put(matches, idxList);
        }
        
        for(int i = max; i >= min; i--) {
            
            if(matchesToIndex.containsKey(i)) {
                ArrayList<Integer> tmp = matchesToIndex.get(i);
                Collections.sort(tmp);
                result.addAll(tmp);
            }
        }
        
        return result;
    }
}
