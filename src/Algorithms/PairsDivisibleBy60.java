package Algorithms;
import java.util.*;
public class PairsDivisibleBy60 {

	public static void main(String[] args) {
		int[] time = {30,20,150,100,40};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for(int i=0; i<time.length;i++){
			int val= (60 - time[i]%60)%60;
			if(map.containsKey(val))
				count += map.get(val);
			map.put(time[i]%60, map.getOrDefault(time[i]%60, 0) + 1);
		}
		System.out.println(count);

	}

}
