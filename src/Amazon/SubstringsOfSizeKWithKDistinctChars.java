package Amazon;

import java.util.*;

public class SubstringsOfSizeKWithKDistinctChars {

	public static void main(String[] args) {
		String s = "awaglknagawunagwkwagl";
		int k = 4;
		Set<String> list = new HashSet<>();
		int count = 0;
		int[] arr = new int[26];
		for(int i=0;i<k;i++) {
			if(arr[s.charAt(i)-'a'] == 0) 
				count++;
			arr[s.charAt(i)-'a']++;
		}
		if(count == k)
			list.add(s.substring(0,k));
		int j =k;
		for(int i=1;i<=s.length()-k;i++) {
			if(arr[s.charAt(i-1)-'a']==1)
				count--;
			arr[s.charAt(i-1)-'a']--;
			if(arr[s.charAt(j)-'a']==0)
				count++;
			arr[s.charAt(j)-'a']++;
			if(count==k) {
				list.add(s.substring(i,j+1));
			}
			j++;	
		}
		List<String> res = new ArrayList<>(list);
		for(String st: res)
			System.out.println(st);
	}

}
