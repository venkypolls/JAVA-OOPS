package Soda;

import java.util.Scanner;

public class ChessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		int player_a = 1, player_b = 2, spec = 3, winner=0, temp_spec;
		for(int i =0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		boolean flag = false;
		for(int i =0; i < n; i++) {
				if(ar[i]!=player_a && ar[i]!=player_b) {
				flag = true;
				System.out.println("NO");
				break;
			}else {
				if(ar[i] == player_a) {
					winner = player_a;
					player_a = winner;
					temp_spec = player_b;
					player_b = spec;
					spec = temp_spec;
				}
			}
		}
		if(!flag) {
			System.out.println("YES");
		}
	}
}
