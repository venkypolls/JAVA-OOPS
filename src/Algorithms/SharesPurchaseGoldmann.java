package Algorithms;

public class SharesPurchaseGoldmann {

	public static void main(String[] args) {
		String str = "ABBCZBAC";
		int count = 0;
		boolean[] alpha = new boolean[3];
		for(int i = 0;i<str.length()-2;i++) {
			for(int j=i;j<str.length();j++) {
				if(str.charAt(j) == 'A')
					alpha[0] = true;
				if(str.charAt(j) == 'B')
					alpha[1] = true;
				if(str.charAt(j) == 'C')
					alpha[2] = true;
				if(alpha[0] && alpha[1] && alpha[2]) {
					count += str.length()-j;
					break;
				}
			}
			alpha[0] = false;
			alpha[1] = false;
			alpha[2] = false;
		}
		System.out.print(count);
	}
}
