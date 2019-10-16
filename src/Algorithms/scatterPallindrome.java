package Algorithms;

import java.util.*;

public class scatterPallindrome {

	public static void main(String[] args) {
		String[] s = {"aabb", "aaa", "aabbaa"};

		for(int k =0; k<s.length;k++) {
			int count =0;
			for(int i=0;i<s[k].length();i++) {
				for(int j =s[k].length()-1;j>=i;j--) {
					if(checkPallindrome(s[k].substring(i,j+1)))
						count++;
				}
			}
			System.out.println(count);
		}
	}	
	public static boolean checkPallindrome(String s) {
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<s.length();i++) {
			if(set.contains(s.charAt(i))){
				set.remove(s.charAt(i));
			}else
				set.add(s.charAt(i));
		}
		if(set.size()<=1)
			return true;
		return false;
	}
}
