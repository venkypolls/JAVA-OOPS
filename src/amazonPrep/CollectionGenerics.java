package amazonPrep;


import java.util.*;

public class CollectionGenerics {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		Collections.sort(list, ( i,  j) -> j.compareTo(i) );
	
		for(Integer i : list) {
			System.out.println(i);
		}
	}

}