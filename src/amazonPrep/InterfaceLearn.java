package amazonPrep;

interface A3{
	//abstract by default
	void write(); 
}
interface B2 {
	void write(); 
}

//multiple inheritance through interface 
class B1 implements A3,B2{
	public void write() {
		System.out.println("writing");
	}
}

public class InterfaceLearn {

	public static void main(String[] args) {
		B2 obj = new B1();
		obj.write();
	}

}
