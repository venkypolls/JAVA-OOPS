package amazonPrep;

//import java.lang.*;
class Add{
	int num1;
	int num2;
	int result;
	
	void add() {
		result = num1+num2;
	}
	public Add(int n1, int n2) {
		this.num1 = n1;
		this.num2 = n2;
	}
	public Add(Double n) {
		this.num1 =  n.intValue();
		this.num2 = num1;
	}
}

public class Calculator {

	public static void main(String[] args) {
		Add obj = new Add(8.5);
		System.out.println(obj.num1);
		obj.add();
		System.out.println(obj.result);
		
	}
}
