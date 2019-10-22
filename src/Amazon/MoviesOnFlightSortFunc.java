package Amazon;
import java.util.*;

class Item{
	int index;
	int val;
	Item(int v, int i){
		this.val = v;
		this.index = i;
	}
}

public class MoviesOnFlightSortFunc {

	public static void main(String[] args) {
		int[] nums = {90, 85, 75, 60, 120,110,110, 150, 125};
		int target = 250;
		int newTarget = target-30;
		//60 75 85 90 110 110 120 125 150
		List<Item> list = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			Item item = new Item(nums[i],i);
			list.add(item);
		}
		Collections.sort(list, (a,b) -> a.val-b.val);
		int[] val = new int[2];
		int[] ind = new int[2];
		int i=0,j=nums.length-1;
		while(i<j) {
			int lisSum = list.get(i).val+list.get(j).val;
			if(lisSum <= newTarget) {
				if(( lisSum > val[0]+val[1]) || (lisSum == val[0]+val[1] && Math.max(list.get(i).val, list.get(j).val) > Math.max(val[0], val[1]))) {
					val[0] = list.get(i).val;
					ind[0] = list.get(i).index;
					val[1] = list.get(j).val;
					ind[1] = list.get(j).index;
				}
				i++;
			}else {
				j--;
			}
//			System.out.println(i+" "+j);
		}
		for(int x: ind)
			System.out.print(x+" ");
	}

}
