package amazonPrep;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class FuturesLearn {
	public static ForkJoinPool fjp = new ForkJoinPool(10);
	
	public static int compute() {
		System.out.println(Thread.currentThread());
		return 2;
	}
	public static CompletableFuture<Integer> create(){
		return CompletableFuture.supplyAsync(() -> compute(),fjp);
			
	}
		
	public static int handle(Throwable throwable) {
		System.out.println("Error" + throwable);
		return 100;
	}
	
	public static void process(CompletableFuture<Integer> future) {
		future
			.exceptionally(throwable -> handle(throwable))
			.thenApply(data -> data*2)
			.thenApply(data -> data+1)
			.thenAccept(System.out::println);
	}

	public static void main(String[] args) throws InterruptedException {
		
//		CompletableFuture<Integer> cf = create();
//		Thread.sleep(1000);
//		cf
//		.thenApply(data -> data*2)
//		.thenAccept(data -> System.out.println(data +" "+ Thread.currentThread()))
//		.thenRun(() -> System.out.println("logging"));
		CompletableFuture<Integer> cf = new CompletableFuture<Integer>();

		process(cf);
		
//		cf.complete(5);
		cf.completeExceptionally(new RuntimeException("something went wrong"));
		
	}


}
 