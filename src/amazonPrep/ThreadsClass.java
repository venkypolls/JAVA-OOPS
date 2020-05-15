package amazonPrep;

class Thr implements Runnable{
	
	String val;
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(this.val);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	Thr(String s) {
		val = s;
	}
}


public class ThreadsClass {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable ob1 = new Thr("hi");
		Runnable ob2 = new Thr("hello");
		
		Thread t1 = new Thread(ob1);
		Thread t2 = new Thread(ob2);
		t1.setPriority(5);
		System.out.println(Thread.currentThread().getName());
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		
		System.out.println(t1.isAlive());
		System.out.println("Bye!");
	}

}
