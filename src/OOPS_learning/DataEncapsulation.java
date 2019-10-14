package OOPS_learning;

class Student{
	private int rollNo;
	private String name;
	
	public int getRollNo() {
		return rollNo;
	}
	// advantage of having getting setters is
	// data is safe you cannot directly change the values
	// inside getters and setter we can have log functions which logs who accessed and when it was accessed
	// or before letting the access we can check if the user is logged in by calling logged in function
	public void setRollNo(int rollNo) {
		//is rollNo logged in check logging(rollNo)
		// log data log("setting roll number in time " - rollNo)
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}

public class DataEncapsulation {

	public static void main(String[] args) {
		Student st = new Student();
		st.setName("venky");
		st.setRollNo(1);
		System.out.println("name - "+st.getName());
		System.out.println("roll - "+st.getRollNo());		
	}
}
