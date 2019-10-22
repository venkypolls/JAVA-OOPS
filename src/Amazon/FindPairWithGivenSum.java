package Amazon;

import java.util.*;

public class FindPairWithGivenSum {

	public static void main(String[] args) {
		int[] nums = {30,20,20,10,30};
		int target = 90;
		int newTarget = target-30;
		Map<Integer,Integer> map = new HashMap<>();
		int[] res = new int[2];
		int[] pos = new int[2];
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<=newTarget || nums[i]>=0) {
				if(map.containsKey(newTarget-nums[i])) {
					if(Math.max(res[0],res[1]) < Math.max(nums[i], newTarget-nums[i])) {
						res[0] = nums[i];
						res[1] = newTarget-nums[i];
						pos[0] = i;
						pos[1] = map.get(newTarget-nums[i]);
						
					}
					map.remove(newTarget-nums[i]);
				}else {
					if(!map.containsKey(nums[i]))
						map.put(nums[i],i);
				}
			}
		}
		for(int x: pos)
			System.out.print(x+" ");
		
	}

}
