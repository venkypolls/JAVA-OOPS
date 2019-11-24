package Soda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReallyBigNumbers {

	public static void main(String[] args) throws IOException {
		String[] line;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		int n, s;
		n = Integer.parseInt(line[0]);
		s = Integer.parseInt(line[1]);
		int count = 0;
		for(int i = 1; i <= n; i ++) {
			String temp = String.valueOf(i);
			int sum = 0;
			for(int j = 0; j < temp.length(); j++) {
				sum+=temp.charAt(j)-'0';
			}
			if(i-sum >= s) {
				count+=1;
			}
		}
		System.out.println(count);
	}

}


