package Amazon;
import java.util.Scanner;

public class Google2 {

  public static String solution(String T) {
    // Your solution goes here.
    
    StringBuilder sb = new StringBuilder(T);
    if(sb.charAt(0) == '?') {
    	if(sb.charAt(1) == '?' || sb.charAt(1)-'0' <=3)
    		sb.setCharAt(0, '2');
    	else
    		sb.setCharAt(0, '1');
    }
    if(sb.charAt(1) == '?') {
    	if(sb.charAt(0)-'0' == 2 )
    		sb.setCharAt(1, '3');
    	else
    		sb.setCharAt(1, '9');
    }
    if(sb.charAt(3) == '?') {	
    	sb.setCharAt(3, '5');
    }
    if(sb.charAt(4) == '?') {	
    	sb.setCharAt(4, '9');
    }	
    return sb.toString();
    
  }

  public static void main(String[] args) {
    // Read from stdin, solve the problem, write answer to stdout.
    Scanner in = new Scanner(System.in);
    System.out.print(solution(in.next()));
  }
}
//2?:?8