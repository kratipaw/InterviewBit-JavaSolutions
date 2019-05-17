import java.util.Stack;

public class SimplifyDirectoryPath {

	public static void main(String[] args) {
		//String A = "/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/..";

		String A = "/./../a/b/..//c/";
		
		System.out.println(simplifyPath(A));
		
		//String res = "/ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/wrm/grm/ach/jsy/dic/ggz/smq/yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/llb/tud/olc/zns/fiv/eeu/fex/kke/eng/bow/uvz/jmz/hwb/ids/dwj/aqu/erf";
		//String res = "/ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/wrm/grm/ach/jsy/dic/ggz/smq/yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/llb/tud/olc/zns/fiv/eeu/fex/kke/eng/bow/uvz/jmz/hwb/ids/dwj/aqu/erf"; 
				
		//System.out.println(res.equalsIgnoreCase(res1));
	}
	
	private static String simplifyPath(String A) {
		
		String tok[] = A.split("/");
		
		int n = tok.length;
		
		Stack<String> st = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			
			if(!tok[i].isEmpty() || !tok[i].equalsIgnoreCase("")) {
			
			if(tok[i].equalsIgnoreCase("..")) {
				if(!st.isEmpty())
					st.pop();
			}
			else if(tok[i].equalsIgnoreCase("."))
				//st.clear();
				continue;
			
			else
				st.push(tok[i]);
			}
		}
		
		if(st.isEmpty())
			return "/";
		
		StringBuilder sb = new StringBuilder();
		
		n = st.size();
		
		for (int i = 0; i < n; i++) {
			
			if(!st.get(i).isEmpty()) {
				sb.append("/");
				sb.append(st.get(i));
			}
		}
	
		return sb.toString();
    }

}
