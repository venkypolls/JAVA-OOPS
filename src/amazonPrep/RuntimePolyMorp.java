package amazonPrep;

class A{
	public void show() {
		System.out.println("in A");
	}
}

class B extends A{
	public void show() {
		System.out.println("in B");
	}	
	public void show1() {}
}

class C extends A{
	public void show() {
		System.out.println("in C");
	}
}

public class RuntimePolyMorp {

	public static void main(String[] args) {
		A obj = new B();
		obj.show();
		obj = new C();
		obj.show();
		
		String num_str = "12345";
		int k = Integer.parseInt(num_str);
		System.out.println(k);
	}

}
