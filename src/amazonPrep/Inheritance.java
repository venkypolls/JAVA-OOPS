package amazonPrep;

class Calc{
	Calc(){
		System.out.println("in constructor cal");
	}
	public int add(int a, int b) {
		return a+b;
	}
	public void show() {
		System.out.println("in super");
	}
}

class AdvCalc extends Calc{
	AdvCalc(){
		System.out.println("in constructor advcal");
	}
	public int sub(int a, int b) {
		return a-b;
	}
	@Override
	public void show() {
		super.show();
		System.out.println("in sub");
	}
}


public class Inheritance {

	public static void main(String[] args) {
		AdvCalc obj = new AdvCalc();
		System.out.println(obj.sub(10, 5));
		System.out.println(obj.add(10, 5));
		obj.show();

	}

}
