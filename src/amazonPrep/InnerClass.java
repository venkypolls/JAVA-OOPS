package amazonPrep;

class Outer{
	int num;
	
	class Inner{
		public void show() {
			System.out.println("inside inner class");
		}
	}
	public void sum(int ...i) {
		int sum =0;
		for (int num:i) {
			sum += num;
		}
		System.out.println(sum);
	}
}

public class InnerClass {

	public static void main(String[] args) {
		Outer out = new Outer();
		
		Outer.Inner inn = out.new Inner();
		inn.show();
		out.sum(1,2,3,4,5,6);

	}

}

