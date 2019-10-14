package Algorithms;

public class WeightsAndTasks {

	public static void main(String[] args) {
		int[] weights = {3,2,2};
		int[] tasks = {3,2,2};
		int load = 9/2;
		
		int[][] dp = new int[tasks.length+1][load+1];
		
		for(int i=1;i<=tasks.length;i++) {
			for(int j=1; j<=load;j++) {
				if(j<tasks[i-1])
					dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-tasks[i-1]]+weights[i-1]);
				}
			}
		}
		System.out.println(dp[tasks.length][load]);

	}

}
