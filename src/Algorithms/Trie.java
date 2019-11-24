package Algorithms;

public class Trie {

	static final int length = 26;
	static class Node{
		Node[] characters = new Node[length];
		boolean endHere = false;
		char val;
		Node(){ 
			endHere = false; 
            for (int i = 0; i < length; i++) 
            	characters[i] = null; 
        } 
	}
	static Node root = new Node();
	
	
	public static void main(String[] args) {
		String keys[] = {"the", "a", "there", "answer", "thaw", 
                "by", "bye", "their"};
		for (int i = 0; i < keys.length ; i++) 
			addStr(keys[i]);
		
		System.out.println(search("the"));
		System.out.println(search("these"));
		System.out.println(search("their"));
		System.out.println(search("thaw"));
		
		addStr( "abcd");

	}
	static boolean search(String str) {
		Node temp = root;
		int length = str.length();
		int pos =0;
		while(pos<length) {
			temp = temp.characters[str.charAt(pos)-'a'];
			if(temp ==null)
				return false;
			pos++;
		}
		if(temp.endHere)
			return true;
		return false;
		
	}
	static void addStr(String str) {
		Node temp = root;
		int pos = 0;
		int len = str.length();
		
		while(pos<len) {
			if(temp.characters[str.charAt(pos)-'a'] !=null) {
				temp = temp.characters[str.charAt(pos)-'a'];
			}else {
				temp.characters[str.charAt(pos)-'a'] = new Node();
				temp = temp.characters[str.charAt(pos)-'a'];
				temp.val = str.charAt(pos);
			}
			pos++;
		}
		temp.endHere = true;
	}
}
