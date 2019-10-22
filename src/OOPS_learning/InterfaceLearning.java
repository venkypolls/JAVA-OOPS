package OOPS_learning;

// annotation for functional interface used to make anonymous classes
@FunctionalInterface
interface Intr{
	public void show();
}

interface Intr2{
	static int num = 10;
	//use default to write method in interface
	default void show() {
		System.out.println("displaying in interface 2 with final static variable"+num);
	}
	default void show2() {
		System.out.println("displaying in interface 2 show2 method ");
	}
}

class Implementor implements Intr,Intr2{
	
	public void show() {
		System.out.println("displaying in Implementor");
		//to display show method of interface use the below
		Intr2.super.show();
	}
//	public void show2() {
//		Intr2.super.show2();
//	}
	
}

public class InterfaceLearning {

	public static void main(String[] args) {
		
		Intr implementor = new Implementor();
		implementor.show();
		
	}

}
