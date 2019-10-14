package Algorithms;

public class GridGameGoldmann {

	public static void main(String[] args) {
		int[][] arr = {{0,1,0,0},{0,0,0,0}};
		boolean[] rules = {false,true,false,false,false,false,false,false,false};
		//alive-dead - 2  dead-alive - 3
		int times = 1;
		
		for(int k=0;k<times;k++) {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					int count = 0;
					if(i-1>=0 && (arr[i-1][j]==1 || arr[i-1][j]==2))
						count++;
					if(i-1>=0 && j-1>=0 && (arr[i-1][j-1]==1 || arr[i-1][j-1]==2))
						count++;
					if(i-1>=0 && j+1<arr[0].length && (arr[i-1][j+1]==1 || arr[i-1][j+1]==2))
						count++;
					if(i+1<arr.length && (arr[i+1][j]==1 || arr[i+1][j]==2))
						count++;
					if(i+1<arr.length && j-1>=0 && (arr[i+1][j-1]==1 || arr[i+1][j-1]==2))
						count++;
					if(i+1<arr.length && j+1<arr[0].length && (arr[i+1][j+1]==1 || arr[i+1][j+1]==2))
						count++;	
					if(j-1>=0 && (arr[i][j-1]==1 || arr[i][j-1]==2))
						count++;
					if(j+1<arr[0].length && (arr[i][j+1]==1 || arr[i][j+1]==2))
						count++;
					
					if(arr[i][j] == 1 && !rules[count])
						arr[i][j] = 2;
					else if(arr[i][j] == 0 && rules[count])
						arr[i][j] = 3;
					
				}
			}
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					if(arr[i][j] == 2)
						arr[i][j] = 0;
					if(arr[i][j] == 3)
						arr[i][j] = 1;
				}
			}
			
		}
		for(int[] a : arr) {
			for(int x :a) {
				System.out.print(x+" ");
			}
			System.out.println();
		}

	}

}
