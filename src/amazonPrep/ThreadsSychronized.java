package amazonPrep;

class  Counter{
	int c = 0;
	//allows only 1 thread to execute it
	public synchronized void count() {
		c++;
	}
}

public class ThreadsSychronized {

	public static void main(String[] args) throws InterruptedException {
		
		Counter obj = new Counter();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<1000;i++)
					obj.count();
				
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<1000;i++)
					obj.count();
				
			}
			
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(obj.c);
	}

}
