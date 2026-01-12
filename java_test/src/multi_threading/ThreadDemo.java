package multi_threading;

//public class ThreadDemo extends Thread
public class ThreadDemo implements Runnable
{

	void m1() {
		System.out.println(" m1 started..");
		System.out.println(Thread.currentThread());
		System.out.println(" m1 ended..");
	}
	
	void m2() {
		System.out.println(" m2 started..");
		System.out.println(Thread.currentThread());
		   
//	    try {
//	        Thread.sleep(10000); // Sleep for 10 seconds
//	    } catch (InterruptedException e) {
//	        e.printStackTrace();
//	    }
		System.out.println(" m2 ended..");
	}
	
	void m3() {
		System.out.println(" m3 started..");
		System.out.println(Thread.currentThread());
		System.out.println(" m3 ended..");
	}
	
	@Override
	public void run() {
		
		m1();
		m2();
		m3();
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(" main started..");
		
		ThreadDemo td = new ThreadDemo();
		Thread thread = new Thread(td);
		thread.start();;
	//	td.m1();
	//	td.m2();
	//	td.m3();
		System.out.println(Thread.currentThread());
		System.out.println(" main ended..");

		
	
	}
}
