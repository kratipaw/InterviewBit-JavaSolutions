import java.util.ArrayList;

public class ShortestUniquePrefix {

	
	
	public static void main(String[] args) {

		ArrayList<String> A = new ArrayList<String>();
		A.add("zebra");
		A.add("dog");
		A.add("duck");
		A.add("dove");
		
		ArrayList<String> result = prefix(A);
		System.out.println("size : " + result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}

	public static ArrayList<String> prefix(ArrayList<String> A) {
		
		ArrayList<String> result = new ArrayList<>();

		int n = A.size();
		
		if(A == null || n == 0)
			return result;
		
		TrieNode root = new TrieNode();
		
		root.freq = 0;
		
		for (int i = 0; i < n; i++) 
				root.insert(A.get(i));

		for (int i = 0; i < n; i++) {
			
			int length = A.get(i).length();
			
			TrieNode current = root;
			
			StringBuilder temp = new StringBuilder("");
			
			for (int j = 0; j < length; j++) {
			
				int charVal = A.get(i).charAt(j);
				
				temp.append((char) charVal);
				
				if (current.child[charVal].freq == 1) {
					result.add(temp.toString());
					break;
				}
				
				current = current.child[charVal];
			}
		}
		
		return result;
	}
	
}

class TrieNode {
	
	final int MAX = 256;
	
	TrieNode[] child = new TrieNode[MAX];
	
	int freq;

	boolean isEndOfWord;
	
	public TrieNode() {
		
		freq = 1; //Here frequency is how many times this node is visited.
		
		for (int i = 0; i < MAX; i++) 
			child[i] = null;
		
		isEndOfWord = false;
	}
	
	public void insert(String str) {

		if(str == null || str.trim().length() < 1)
			return;
		
		TrieNode current = this;
		
		int length = str.length();

		for (int i = 0; i < length; i++) {
           
			int charVal = str.charAt(i);
		
			if (current.child[charVal] == null) 
				current.child[charVal] = new TrieNode();
			
			else 
				current.child[charVal].freq++;
			
			current = current.child[charVal];
		}
	}
}
