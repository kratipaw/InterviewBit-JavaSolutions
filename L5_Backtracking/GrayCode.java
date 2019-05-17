import java.util.ArrayList;

/**

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence.

*/

public class GrayCode{

  public ArrayList<Integer> grayCode(int a) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(a == 0)
            return result;
        
        result = util(a);
        
        return result;
    }
    
    public ArrayList<Integer> util(int a){
        
        if(a == 0){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(0);
            return tmp;
        }
        
        ArrayList<Integer> prev = util(a - 1);
        
        for (int i = prev.size() - 1; i>=0; i--) {
            
            int num = prev.get(i);
            
            num = num | (1 << (a - 1));
            
            prev.add(num);
        }
        return prev;
        
    } 

}
