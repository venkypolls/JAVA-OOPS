package OOPS_learning;


class Parent{
	Parent(){}
	void show() {
		System.out.println("in class Parent");
	}
}
class child1 extends Parent{
	void show() {
		System.out.println("in class child1");
	}
	void show1() {
		System.out.println("in class child1 show1");
	}	
}

class child2 extends Parent{
	void show() {
		System.out.println("in class child2");
	}
}

public class PolyMorphism {

	public static void main(String[] args) {
		
		Parent cls = new child1(); // runtime polymorphism only parent functions can be invoked but calls the childs's fucntion 
		cls.show();
		//cls.show1() not possible -> the object is formed at runtime so it alows only parent function's access at compile time.		
		cls = new child2();// dynamic method dispatch, cos the reference is of parent this assignment is possible.
		cls.show();
	
	}
}
