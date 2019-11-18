package L8_Graph;

public class WordLadder2 {

  public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        int len = start.length();
        
        Set<String> dictSet = new HashSet<>(dict);
        Set<String> startSet = new HashSet<>();
        startSet.add(start);
        dictSet.remove(start);
        dictSet.add(end);
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        while(!startSet.isEmpty()) {
            if (startSet.contains(end)) {
                break;
            }
            
            Set<String> set = new HashSet<>();
            for (String word : startSet) {
                ArrayList<String> relatedWords = getRelatedWords(word, dictSet);
                if (!relatedWords.isEmpty()) {
                    map.put(word, relatedWords);
                    set.addAll(relatedWords);
                }
            }
            
            dictSet.removeAll(set);
            startSet = set;
        }
        
        List<String> path = new ArrayList<>();
        
        path.add(start);
        
        dfs(result, path, start, end, map);
        
        return result;
    }
    
    public void dfs(ArrayList<ArrayList<String>> result, List<String> path, String curr, String endWord, Map<String, ArrayList<String>> map){
        
        if(curr.equals(endWord)){
            result.add(new ArrayList<>(path));
            return;
        }
        
        
        if(map.containsKey(curr)){   
            
            for(String str : map.get(curr)){
                path.add(str);

                dfs(result, path, str, endWord, map);

                path.remove(path.size() - 1);
            }
        }
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
