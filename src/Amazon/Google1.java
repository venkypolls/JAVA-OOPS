package Amazon;
import java.util.*;
import java.util.Scanner;

public class Google1 {

	public static String solution(String[] A) {
	    // Your solution goes here.
	    Map<String,Integer> map = new HashMap<>();
	    int max = 0;
	    for(String s : A) {
	    	if(s.charAt(0) == '+') {
	    		map.put(s,map.getOrDefault(s, 0)+1);
	    		max = Math.max(max, map.get(s));
	    	}
	    }
	    String maxString = "+9Z";
	    for(String s: map.keySet()) {
	    	if(map.get(s) == max && compareStr(s,maxString))
	    		maxString = s;
	    }
	    return maxString.substring(1);
	  }
	public static boolean compareStr(String s, String maxS) {
		if(s.charAt(1) < maxS.charAt(1))
			return true;
		else if(s.charAt(1) == maxS.charAt(1) && s.charAt(2) < maxS.charAt(2))
			return true;
		
		return false;
			
	}
	  public static void main(String[] args) {
	    // Read from stdin, solve the problem, and write the answer to stdout.
	    Scanner in = new Scanner(System.in);
	    System.out.print(solution(in.next().split(",")));
	  }
	
}
//+1A,-1A,+3F,-3F,+3F,+8X