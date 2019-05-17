import java.util.ArrayList;
import java.util.Collections;

/**

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.

*/

public class GenerateParenthesis_2 {

  public ArrayList<String> generateParenthesis(int A) {
        
        ArrayList<String> result = new ArrayList<>();
        
        util(result, "", A, A);
        
        Collections.sort(result);
        
        return result;
    }
    
    public void util(ArrayList<String> result, String curr, int opn, int cls){
        
        if (opn == 0 && cls == 0) {
                result.add(curr);
            }
            
            if (opn > 0) {
                util(result, curr + "(", opn - 1, cls);
            }
            
            if (opn < cls) {
                util(result, curr + ")", opn, cls - 1);
            }
    }

}
