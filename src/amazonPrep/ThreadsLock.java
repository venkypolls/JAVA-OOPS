package amazonPrep;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadF {

	int count = 0;
	Lock lock = new ReentrantLock();
	Condition cond = lock.newCondition();
	public void thread1() throws InterruptedException {
		lock.lock();
		System.out.println("waiting thr 1 ...");
		cond.await();
		
		for(int i=0; i<1000;i++)
			count++;
		lock.unlock();
		
	}
	public void thread2() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("in thr 2");
		cond.signal();
		for(int i=0; i<1000;i++)
			count++;
		lock.unlock();
		
	}
	
}
public class ThreadsLock {

	public static void main(String[] args) throws InterruptedException {
		ThreadF thr = new ThreadF();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					thr.thread1();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					thr.thread2();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("end count-" + thr.count);
	}

}
