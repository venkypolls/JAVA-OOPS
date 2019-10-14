package OOPS_learning;

class Calc{
	int a;
	int b;
	
	Calc(){}
	
	Calc(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	int addVal(){
		return this.a+this.b;
	}
	void show() {
		System.out.println("im in class Calc");
	}
}
class SubCalc extends Calc{
	
	SubCalc(int a, int b) {	
		//the way to call parent constructor
		super(a, b);
	}

	int subVal() {
		return this.a-this.b;
	}
	//Override annotation used to detect coding issues when we type out the function name wrong
	@Override
	void show() {
		//super is used to call parent methods and variables
		//this is used to call current class's variables and functions
		super.show();
		System.out.println("im in class SubCalc");
	}
	
}

public class Inheritance {	
	public static void main(String[] args) {
		SubCalc cal = new SubCalc(5,3);
		System.out.println(""+cal.addVal());
		System.out.println(""+cal.subVal());
		cal.show();
	}
}
