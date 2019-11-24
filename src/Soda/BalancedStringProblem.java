package Soda;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BalancedStringProblem {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] freq = new int[3];
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '0') {
			freq[0]++;
			}else if(input.charAt(i)=='1') {
			freq[1]++;
			}else if(input.charAt(i) == '2') {
			freq[2]++;
			}
		}
		if(freq[0] == freq[1] && freq[1] == freq[2]) {
			System.out.println(input);
		}else {
			int reqCount = input.length()/3;
			int[] characterProc = new int[3];
			StringBuilder sb = new StringBuilder(input);
			for(int i = 0; i < input.length(); i++) {
				if(freq[sb.charAt(i)-'0'] == reqCount) {
					continue;
				}
				if(sb.charAt(i)=='0' && freq[0] > reqCount && characterProc[0] >=reqCount) {
					if(freq[1] < reqCount) {
					sb.setCharAt(i, '1');
					freq[1]+=1;
					freq[0]-=1;
					}
					else if(freq[2] < reqCount) {
					sb.setCharAt(i, '2');
					freq[2]+=1;
					freq[0]-=1;
					}
				}
				if(sb.charAt(i)=='1' && freq[1] > reqCount) {
					if(freq[0] < reqCount) {
					sb.setCharAt(i, '0');
					freq[0]+=1;
					freq[1]-=1;
					}
					else if(freq[2] < reqCount && characterProc[1] >=reqCount) {
					sb.setCharAt(i, '2');
					freq[2]+=1;
					freq[1]-=1;
					}
				}
				else if(sb.charAt(i)=='2' && freq[2] > reqCount) {
					if(freq[0] < reqCount) {
					sb.setCharAt(i, '0');
					freq[0]+=1;
					freq[2]-=1;
					}
					else if(freq[1] < reqCount) {
					sb.setCharAt(i, '1');
					freq[1]+=1;
					freq[2]-=1;
					}
				}
				characterProc[sb.charAt(i)-'0']++;
			}
		System.out.println(sb.toString());
		}	

	}

}
