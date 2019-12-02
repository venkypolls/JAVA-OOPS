package FOA_assignment;

public class CombinationFlights {

	public static void main(String[] args) {
		String[] str_arr = new String[] {"LAX","SFO","PHX","SEA","DEN","ATL","ORD","BOS","IAD","JFK"};

		for(int i=0;i<str_arr.length-1;i++) {
			for(int j=i+1;j<str_arr.length;j++) {
				System.out.println(str_arr[i]+" "+str_arr[j]);
				System.out.println(str_arr[j]+" "+str_arr[i]);
			}
		}
		
		
		
		
		
		
		

	}

}
