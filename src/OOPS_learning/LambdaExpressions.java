package OOPS_learning;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressions {

	public static void main(String[] args) {
		
		
//		lambda expressions
		String[] months = {"January","February","March","April","May","June","July","August","September","October","December"};
		Arrays.sort(months, (a, b) -> b.compareTo(a));
		for(String x: months)
			System.out.print(x+" ");
		
		//streams
		List<Integer> list = Arrays.asList(6,5,4,3,2,1);
		int[] arr = list.stream().filter(i -> i%2==0).sorted((a,b)-> a-b).mapToInt(i->i).toArray();
		for(int y: arr)
			System.out.print(y+" ");
	}
	
	

}
