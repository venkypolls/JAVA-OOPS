package OOPS_learning;

public class wrapperClasses {

	public static void main(String[] args) {
		int x = 5;
		
		Integer val = x;//auto boxing
		x = val;// auto un boxing converting from Integer to int
		
		String xyz = "1234";
		int str = Integer.parseInt(xyz);//can use lotta such functions
		System.out.println(Integer.toBinaryString(str));//these as well
		

	}

}
