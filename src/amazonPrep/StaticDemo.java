package amazonPrep;


class Emp{
	int eid;
	String name;
	static String ceo;
	
	Emp(int eid, String name){
		this.eid = eid;
		this.name = name;
	}
	static {
		ceo = "Venks";
	}
	public void display() {
		System.out.println("eid:"+this.eid + " name:"+this.name+" ceo:"+Emp.ceo);
	}
}

public class StaticDemo {

	static int i;
	public static void main(String[] args) {
		System.out.println(i);
		i = 9;
		
		Emp emp1 = new Emp(1,"hank");
		Emp emp2 = new Emp(2,"rock");
		emp1.display();
		emp2.display();

	}

}
