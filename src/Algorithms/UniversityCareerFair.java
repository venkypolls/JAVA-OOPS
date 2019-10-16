package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Stalls{
	Stalls(int arr, int dur){
		this.arrival = arr;
		this.duration = dur;
	}
	int arrival;
	int duration;
}
public class UniversityCareerFair {

	public static void main(String[] args) {
		int[] arrival = {7,3,3,5,1};
		int[] duration = {1,2,1,2,2};
		List<Stalls> list = new ArrayList<Stalls>();
		for(int i=0; i<arrival.length ;i++) {
			Stalls st = new Stalls(arrival[i],duration[i]);
			list.add(st);
		}
		Collections.sort(list, (a,b) -> Integer.compare(a.arrival,b.arrival));
		int count = 1;
		int endT = list.get(0).arrival + list.get(0).duration;
		for(int i =1 ; i<list.size();i++) {
			if(list.get(i).arrival>=endT) {
				count++;
				endT = list.get(i).arrival + list.get(i).duration;
			}else {
				endT = Math.min(endT, list.get(i).arrival + list.get(i).duration);
			}
		}
		System.out.println(count);
	}

}
