package L8_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder1 {

	class WordNode{
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }
	
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
                            String trans = new String(s);
                            
                            if(dictV.contains(trans)){
                                qu.add(trans);
                                dictV.remove(trans);
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
