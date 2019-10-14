package OOPS_learning;


class Item{
	int i;
	float j;
	static String company;
	//instantiate static variables of a class
	static {
		company = "big company";
	}
	Item(){
		i =10;
	}
	//method overloading(constructor)
	Item(int i,float j){
		this.i = i;
		this.j = j;
	}
	public void print(){
		System.out.println("value of i is :"+i +" sold by "+company);
		System.out.println("value of j is :"+j+" sold by "+company);
	}
	//inner class code
	class Inner{
		public void printInner() {
			System.out.println("inner class");
		}
	}
	
	//variable arguments passed to a function check syntax
	public void addSum(int ... arr) {
		int sum = 0;
		for(int k:arr)
			sum+=k;
		System.out.println("the sum is :"+sum);
	}
}

public class Constructor {

	static int value;
	public static void main(String[] args) {
		Item item = new Item(4,5.7f);
		value = 10;
		item.print();
		//instantiate an inner class
		Item.Inner in = item.new Inner();
		in.printInner();
		item.addSum(1,2,3,4,5,6,7,8,9);
	}

}
