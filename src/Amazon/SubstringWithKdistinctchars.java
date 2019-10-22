package Amazon;

import java.util.*;

public class SubstringWithKdistinctchars {

	public static void main(String[] args) {
		String s = "pqpqs";
		int k = 2;
		System.out.print(subarraysWithKDistinct(s.toCharArray(),k));

	}
	public static int subarraysWithKDistinct(char[] A, int K) {
        return till(A, K) - till(A, K - 1);
    }
    public static int till(char[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> value = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (value.getOrDefault(A[j]-'a', 0) == 0) K--;
            value.put(A[j]-'a', value.getOrDefault(A[j]-'a', 0) + 1);
            while (K < 0) {
                value.put(A[i]-'a', value.get(A[i]-'a') - 1);
                if (value.get(A[i]-'a') == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

}
