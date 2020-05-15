package amazonPrep;

import java.util.*;


@FunctionalInterface
interface C1{
	void write();
	default void show() {
		System.out.println("defualt method in interface");
	}
}

public class AnonymousClass {

	public static void main(String[] args) {
		C1 obj = new C1() {
			public void write() {
				System.out.println("writing");
			}
		};
		obj.write();
		
		//lambda expression
		C1 obj2 = () -> System.out.println("writing lambda");
		obj2.write();
		
		List<Integer> al = new ArrayList<Integer>();
		al.add(5);
		al.add(2);
		al.sort(( a, b) -> a.compareTo(b));
		System.out.println(al.get(0));
		System.out.println(al.get(1));
	}

}
