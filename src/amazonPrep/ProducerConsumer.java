package amazonPrep;


class Producer implements Runnable{
	
	Buffer b;
	public Producer(Buffer b) {
		this.b = b;
		Thread t1 = new Thread(this,"producer");
		t1.start();
	}
	

	@Override
	public void run() {
		while(true) {
			try {
				b.set();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			 
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			
		}
	}
	
}
class Consumer implements Runnable{
	
	Buffer b;
	public Consumer (Buffer b) {
		this.b = b;
		Thread t1 = new Thread(this,"consumer");
		t1.start();
	}
	

	@Override
	public void run() {
		while(true) {
			try {
				b.get();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
			
		}
	}
	
}
class Buffer {
	int val =0;
	boolean prod =false;
	
	public synchronized int get() throws Exception {
		while(!prod) {
			wait();
		}
		System.out.println("consumer get - "+ val);
		prod = false;
		notify();
		return this.val;
		
	}
	public synchronized void set() throws Exception {
		while(prod) {
			wait();
		}
		this.val++;
		System.out.println("producer set - "+val);
		prod = true;
		notify();
	}
}

public class ProducerConsumer {

	public static void main(String[] args) {
		Buffer b = new Buffer();
		new Producer(b);
		new Consumer(b);

	}

}
