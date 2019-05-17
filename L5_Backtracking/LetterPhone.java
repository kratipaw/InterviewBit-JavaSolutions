import java.util.ArrayList;
import java.util.HashMap;

/**

  Given a digit string, return all possible letter combinations that the number could represent.

  A mapping of digit to letters (just like on the telephone buttons) is given.
  
  The digit 0 maps to 0 itself.
  The digit 1 maps to 1 itself.

  Input: Digit string "23"
  Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
  
  Make sure the returned strings are lexicographically sorted.
  
*/

public class LetterPhone {
  
  public static HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
    
    public ArrayList<String> letterCombinations(String A) {
        
        dict.put('0',new char[]{'0'});
        dict.put('1',new char[]{'1'});
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});
        
        ArrayList<String> result = new ArrayList<String>();
        
        if(A == null || A.length() == 0)
            return result;
            
        if(A.length() == 1 && (A.equals("0") || A.equals("1"))){
            result.add(A);
            return result;
        }
            
        
        util(result, A, 0, "");
        
        return result;
        
    }
    
    public void util(ArrayList<String> result, String A, int idx, String curr){
        
        if(curr.length() == A.length()){
            result.add(curr);
            return;
        }
        
        char ch = A.charAt(idx);
        char[] options = dict.get(ch);
        for(int i = 0; i < options.length; i++){
            
            util(result, A, idx + 1, curr + options[i]);
        }
    }

}
