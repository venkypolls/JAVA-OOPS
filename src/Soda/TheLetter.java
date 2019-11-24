package Soda;
import java.util.*;
public class TheLetter {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		String s = "abcdefg hijk";
		
		String s1 = "k j i h g f e d c b a";
		Map<Character,Integer> map = new HashMap<>();
		for(int i =0;i<s.length();i++) {
			if(s.charAt(i) != ' ')
				map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
		}
		for(int i =0;i<s1.length();i++) {
			if(s1.charAt(i) != ' ') {
				if(map.containsKey(s1.charAt(i)) && map.get(s1.charAt(i))>0)
					map.put(s1.charAt(i),map.get(s1.charAt(i))-1);
				else {
					System.out.println("NO");
					return;
				}
			}
					
		}
		System.out.println("YES");

	}

}
