package Algorithms;

import java.util.HashSet;
import java.util.Set;

public class UniquePairSumK {

	public static void main(String[] args) {
		
		int[] arr = {2,3,4,1,5,2,3,4,4,6};
		int target = 5;
		
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> seen = new HashSet<Integer>();
		int count = 0;
		for(int x : arr) {
			if(set.contains(target-x) && !seen.contains(x)) {
				count++;
				seen.add(x);
				seen.add(target-x);
			}else if(!set.contains(x)) {
				set.add(x);
			}
		}
		System.out.println(count);

	}

}
