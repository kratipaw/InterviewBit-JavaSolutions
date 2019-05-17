import java.util.ArrayList;
import java.util.Collections;

/**
 * Pretty print a json object using proper indentation.
 * 
 * Every inner brace should increase one indentation to the following lines.
 * Every close brace should decrease one indentation to the same line and the following lines.
 * The indents can be increased with an additional �\t�
 * Example 1:
 * 
 * Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
 * Output : 
 * { 
 *     A:"B",
 *     C: 
 *     { 
 *         D:"E",
 *         F: 
 *         { 
 *             G:"H",
 *             I:"J"
 *         } 
 *    } 
 * }
 * 
 * Example 2:
 * 
 * Input : ["foo", {"bar":["baz",null,1.0,2]}]
 * Output : 
 * [
 *     "foo", 
 *     {
 *         "bar":
 *         [
 *             "baz", 
 *             null, 
 *             1.0, 
 *             2
 *         ]
 *     }
 * ]
 * [] and {} are only acceptable braces in this case.
 * 
 * Assume for this problem that space characters can be done away with.
 * 
 * Your solution should return a list of strings, where each entry corresponds to a single line. 
 * The strings should not have �\n� character in them.
 */

public class PrettyJson {

	public static void main(String[] args) {

		String A = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
		
		ArrayList<String> result = prettyJSON(A);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i).toString());
		}
		
	}
	
	private static ArrayList<String> prettyJSON(String A) {
    
		ArrayList<String> result = new ArrayList<>();

        int opn = 0;
        
        int cls = 0;
        
        StringBuilder sb = new StringBuilder("");
        System.out.println("len : " + sb.length());
        char[] chars = A.toCharArray();
 
        for (char c : chars) {
        	
            if ("{[".indexOf(c) != -1) {
                
            	if (sb.length() != 0) {
            		
            		result.add(String.join("", Collections.nCopies(opn - cls, "\t")) + sb.toString());
                    
            		sb.setLength(0);
                }
                
            	opn++;
                
                sb.append(c);
                
                result.add(String.join("", Collections.nCopies(opn - cls - 1, "\t")) + sb.toString());
                
                sb.setLength(0);
            }
            else if ("}]".indexOf(c) != -1) {
                
            	if (sb.length() != 0) {
                    
            		result.add(String.join("", Collections.nCopies(opn - cls, "\t")) + sb.toString());
                    
                    sb.setLength(0);
                }
                
            	cls++;
                
            	sb.append(c);
            }
            else if (c == ',') {
                
            	sb.append(',');
                
            	result.add(String.join("", Collections.nCopies(opn - cls, "\t")) + sb.toString());
                
            	sb.setLength(0);
            }
            else {
                sb.append(c);
            }
        }

        if (sb.length() != 0) {
        	result.add(sb.toString());
        }

        return result;
	
	}
}
