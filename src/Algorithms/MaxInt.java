package Algorithms;

public class MaxInt {

	public static void main(String[] args) {
		int val = -444;
		int g = 5;
		String s = String.valueOf(val);
		StringBuilder str = new StringBuilder(s);
		System.out.println(str);
		boolean insert = false;
		if(val>=0) {
			for(int i=0;i<str.length();i++) {
				if(g>(str.charAt(i)-'0')) {
					str.insert(i,g);
					insert = true;
					break;
				}
			}
		}else {
			for(int i=1;i<str.length();i++) {
				if(g<(str.charAt(i)-'0')) {
					str.insert(i,g);
					insert = true;
					break;
				}
			}
		}
		if(!insert)
			str.append(g);
		System.out.println(Integer.parseInt(str.toString()));
	}

}
