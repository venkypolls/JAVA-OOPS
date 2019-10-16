package OOPS_learning;


//abstract class cannot be instantiated 
abstract class Writer{
	public void write(Number i) {
		System.out.println(i);
	}
	//abstract methods have to be overriden by the class's that extend it.
	public abstract void erase();
} 

class Pen extends Writer{
	@Override
	public void erase() {
		System.out.println("erasing");	
	}	
}

class Pencil extends Writer{
	@Override
	public void erase() {
		System.out.println("erasing");	
	}
}

public class AbstractClass {

	public static void main(String[] args) {
		Writer pen = new Pen();
		pen.write(5.67);
		pen.erase();	
	}

}
