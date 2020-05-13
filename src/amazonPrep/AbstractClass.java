package amazonPrep;

abstract class Animal{
	public abstract void walk(Number x);
	
	public void eat(String str) {
		System.out.println(str+ " eating");
	}
}
class Men extends Animal{
	public void walk(Number x) {
		System.out.println("Men walking "+x);
	}
	public void speak() {}
}
class Women extends Animal{
	public void walk(Number x) {
		System.out.println("Women walking " + x);
	}
	public void speak() {}
}


public class AbstractClass {

	public static void main(String[] args) {
		Animal obj = new Men();
		obj.walk(4.5f);
		obj.eat("men");
		obj = new Women();
		Integer x = 6;
		obj.walk(x);
		obj.eat("Women");
		
	}

}
