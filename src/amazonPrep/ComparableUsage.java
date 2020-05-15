package amazonPrep;

import java.util.*;

class Students implements Comparable<Students>{
	
	int roll;
	String name;
	int marks;
	
	public Students(int roll, String name, int marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		
	}
	public String toString() {
		return "name:"+this.name + " marks:"+this.marks+ " roll:"+this.roll;
	}
	
	@Override
	public int compareTo(Students o) {
		return this.marks>o.marks?1:-1;
	}	
} 


public class ComparableUsage {

	public static void main(String[] args) {
		List<Students> list = new ArrayList<>();
		list.add(new Students(18,"venk",93));
		list.add(new Students(20,"venk1",73));
		list.add(new Students(14,"venk2",83));
		list.add(new Students(1,"venk3",63));
		
		Collections.sort(list, (a,b) -> a.roll>b.roll?1:-1);
		
		for(Students s: list) {
			System.out.println(s.toString());
		}
	}

}
