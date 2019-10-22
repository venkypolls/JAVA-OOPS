package Amazon;

public class LongestPallindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("xyyxabcdcba"));
	}
	public static String longestPalindrome(String s) {
        boolean[][] mat = new boolean[s.length()][s.length()];
        if(s.length() == 0)
            return s;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j){
                    mat[i][j] = true;
                }else if(j == i+1 && s.charAt(i) == s.charAt(j)){
                    mat[i][j] = true;
                }else if(mat[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    mat[i][j] = true;
                }
            }
        }
        int i1=0,j1=0, max=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(mat[i][j] && max<j-i){
                    max = j-i;
                    i1=i;
                    j1=j;
                }
            }
        }
        return s.substring(i1,j1+1);
    }
}
