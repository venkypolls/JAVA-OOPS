package Algorithms;

public class MaximalCommonalityGoldmann {

	public static void main(String[] args) {
		
		String str = "abcdedeara";
		int[] alpha = new int[26];
		for(int i=0;i<str.length();i++)
			alpha[str.charAt(i)-'a']++;
		
		int curr=0, max=0;
		for(int i=0;i<str.length();i++) {
			if(alpha[str.charAt(i)-'a']>1){
				alpha[str.charAt(i)-'a'] -= 2;
				curr++;
			}else if(alpha[str.charAt(i)-'a']==0) {
				curr--;
			}else {
				alpha[str.charAt(i)-'a']--;
				
			}
			max = Math.max(curr, max);
		}
		System.out.println(max);
	}
}
