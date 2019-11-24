package Amazon;

public class PathWithMaximumScore {

	public static void main(String[] args) {
		
		int[][] arr = new int[][] {{5,2,3,8},{4,5,7,5}};
		if(arr.length == 0 || arr[0].length == 0)
			System.out.println(0);
		int min = arr[0][0]; 
		for(int i=1;i<arr.length;i++) {
			min = Math.min(min, arr[i][0]);
			arr[i][0] = min;
		}
		for(int i=1;i<arr[0].length;i++) {
			min = Math.min(min, arr[0][i]);
			arr[0][i] = min;
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<arr[0].length;j++) {
				arr[i][j] = Math.max(Math.min(arr[i][j],arr[i-1][j]), Math.min(arr[i][j], arr[i][j-1]));
			}
		}
		System.out.println(arr[arr.length-1][arr[0].length-1]);
			
	}

}
