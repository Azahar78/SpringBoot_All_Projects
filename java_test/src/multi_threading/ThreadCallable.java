package multi_threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadCallable  implements Callable{

	@Override
	public Object call() throws Exception {
		System.out.println(" Call method");
		m1();
		m2();
		m3();
		return "done";
	}
	
	
	void m1() {
		System.out.println(" m1 started..");
		System.out.println(Thread.currentThread());
		System.out.println(" m1 ended..");
	}
	
	void m2() {
		System.out.println(" m2 started..");
		System.out.println(Thread.currentThread());
		System.out.println(" m2 ended..");
	}
	
	void m3() {
		System.out.println(" m3 started..");
		System.out.println(Thread.currentThread());
		System.out.println(" m3 ended..");
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("main start");
		ThreadCallable threadCallable = new ThreadCallable();
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future submit = null;
		
		for(int i =0;i<10;i++) {
			submit =service.submit(threadCallable);
		}
		
		System.out.println(submit.get());
		
		service.shutdown();
		System.out.println("main End");
	}

}
