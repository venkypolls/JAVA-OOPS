package amazonPrep;

//final on a class makes it not able to extend
class A1{
	//final on a variable makes it a constant
	final int X;
	A1(){
		X = 10;
	}
	//final on a method avoids it from being overriden
	public  void fun() {} 
}
class A2 extends A1{
	public void fun(){}
}
public class FinalKeyword {

	public static void main(String[] args) {
		

	}

}
