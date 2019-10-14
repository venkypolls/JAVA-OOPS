package Algorithms;

public class Spiral {

	public static void main(String[] args) {
		
		int[][] inp = {{1,2,3},{4,5,6},{7,8,9}};
		int rowLen = inp[0].length;
		int colLen = inp.length;
		int k = 0;
		while(colLen <= 0 || rowLen<= 0) {
			for(int i =k; i<rowLen-1;i++) {
				System.out.print(inp[k][i]+ " ");
			}
			for(int i=k ;i<colLen-1;i++) {
				System.out.print(inp[i][rowLen-1] + " ");
			}
			for(int i =rowLen-1; i>k ;i--) {
				System.out.print(inp[colLen-1][i]+" ");
			}
			for(int i =colLen-1;i>k;i--) {
				System.out.print(inp[i][k] + " ");
			}
			colLen -= 2;
			rowLen -= 2;
			k++;
		}
	}
}
