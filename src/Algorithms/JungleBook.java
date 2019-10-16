package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JungleBook {

	public static void main(String[] args) {
		int[] arr = {-1,8,4,0,7,3,8,9,-1,6};
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				List<Integer> a = map.get(arr[i]);
				a.add(i);
				map.put(arr[i], a);
			}else {
				List<Integer> a = new ArrayList<>();
				a.add(i);
				map.put(arr[i],a);
			}		
		}
		int[] resC = new int[arr.length];
		for(int i =0; i<map.get(-1).size();i++) {
			dfs(resC,arr,map,map.get(-1).get(i),1);
		}
		System.out.println(Arrays.stream(resC).max().getAsInt());
	}
	public static void dfs(int[] resC, int[] arr, Map<Integer, List<Integer>> map, int val, int sum) {
		resC[val] = sum;
		if(map.containsKey(val)) {
			for(int i =0; i<map.get(val).size();i++) {
				dfs(resC,arr,map,map.get(val).get(i),sum+1);
			}
		}
		return;
	}

}
