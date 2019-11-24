package Algorithms;

import java.util.*;

public class ValueOfString {

	public static void main(String[] args) {
		String str = "50*2+5-8-20";
		
		Stack<String> stInt = new Stack<>();
		Stack<String> stOpe = new Stack<>();
		int i=str.length()-1,j=str.length()-1;
		
		while(i>0) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9') {
				i--;
			}else {
				stInt.push(str.substring(i+1,j+1));
				stOpe.push(str.substring(i,i+1));
				i--;
				j=i;
			}
			if(i==0) {
				stInt.push(str.substring(i,j+1));
			}
		}
		
		while(!stOpe.isEmpty()) {
			String op = stOpe.pop();
			String v1 = stInt.pop();
			String v2 = stInt.pop();
			int count= 0;
			if(op.equals("+")) {
				count += Integer.parseInt(v1)+Integer.parseInt(v2);
			}else if(op.equals("-")) {
				count += Integer.parseInt(v1)-Integer.parseInt(v2);
			}else {
				count += Integer.parseInt(v1)*Integer.parseInt(v2);
			}
			stInt.push(Integer.toString(count));
		}
		System.out.println(stInt.pop());
		
		
	}

}
