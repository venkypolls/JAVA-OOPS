package Soda;
import java.util.*;
public class KTree {
	static int count = 0;
	public static void main(String[] args) {
		int k = 3;
		int n = 8;
		int d = 1;
		int[] arr = new int[k];
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<k;i++) {
			arr[i] = i+1;
		}
		recurs(n,arr,d,list,0);
		System.out.println(count);
		count = 0;
	}
	public static void recurs(int n, int[] arr, int d, List<Integer> list,int sum) {
		if(sum == n) {
			
			int max = 0;
			for(int x:list) {
				if(x>max)
					max =x;
			}
			if(max>=d)
				count++;
			
			list.remove(list.size()-1);
			return;
		}
		
		if(sum<n) {
			for(int i=0;i<arr.length;i++) {
				list.add(arr[i]);
				recurs(n,arr,d,list,sum+arr[i]);
				if(list.size()>=1)
				list.remove(list.size()-1);
			}
		}
		
		return;
	}

}
