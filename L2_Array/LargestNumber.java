package L2_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		
		List<Integer> A = new ArrayList<>();
		
		A.add(60);
		A.add(24);
		A.add(34);
		A.add(60);
		A.add(97);
		A.add(75);
		A.add(0);
		A.add(76);
		A.add(8);
		
		System.out.println(getLargestNumber(A));

	}

	private static String getLargestNumber(final List<Integer> A) {
		
		Collections.sort(A, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {

				int num1 = Integer.parseInt(String.valueOf(o1) + String.valueOf(o2));
				
				int num2 = Integer.parseInt(String.valueOf(o2) + String.valueOf(o1));
				
				if(num1>num2)
					return -1;
				else 
					return 1;
			}
		});
		
		Iterator<Integer> it = A.iterator();
		StringBuilder result = new StringBuilder();
		while(it.hasNext()) {
			result.append(it.next());
		}
		System.out.println(result.toString());
		boolean flag = true;
		for (int i = 0; i < result.length(); i++) {
			if(result.charAt(i)!='0') {
				flag = false;
				break;
			}
		}
		/*
		if(Double.parseDouble(result.toString()) == 0)
			return "0";
		*/
		if(flag)
			return "0";
		else
			return result.toString();
	}
	
	public String largestNumber(final List<Integer> A) {
        StringBuffer strBuf = new StringBuffer();
        Node num[];
        int i = 0;
        
        num = new Node[A.size()];
        
        for (int n : A) {
            num[i] = new Node(n);
            i++;
        }
        
        Arrays.sort(num);
        
        for (Node n : num) {
            if (n.number == 0 && strBuf.length() != 0)
                continue;
            strBuf.append(n.number);
        }

        
        return strBuf.toString();
    }
    
    class Node implements Comparable<Node> {
        
        int number;
        
        public Node(int number) {
            this.number = number;
        }
        
        @Override
        public int compareTo(Node o) {
            String first = String.valueOf(this.number) + String.valueOf(o.number);
            String second = String.valueOf(o.number) + String.valueOf(this.number);
            
            return second.compareTo(first);
        }
        
    }
}
