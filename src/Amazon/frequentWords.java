package Amazon;

import java.util.Arrays;
import java.util.List;
import java.util.*;

public class frequentWords {

	public static void main(String[] args) {
		String str = "jack and jill went to the market to buy bread and cheese cheese is jack favourite food";
		String[] exclude = {"and","he","the","to","is"};
		List<String> result = mostCommon(Arrays.asList(exclude),str);
		for(String s:result)
			System.out.println(s);

	}
	public static List<String> mostCommon(List<String> exclude, String str){
		Set<String> set = new HashSet<>();
		for(String s:exclude)
			set.add(s);
		String[] words = str.split(" ");
		Map<String,Integer> map = new HashMap<>();
		for(String s: words) {
			if(!set.contains(s))
				map.put(s, map.getOrDefault(s,0)+1);
		}
		List<String> result = new ArrayList<>();
		int max =0;
		for(String s: map.keySet()) {
			if(map.get(s)>max) {
				result.clear();
				result.add(s);
				max = map.get(s);
			}else if(map.get(s)==max) {
				result.add(s);
			}
		}
		return result;
	}

}
