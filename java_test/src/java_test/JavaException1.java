package java_test;

public class JavaException1 {

	void m2(int a, int b) {
		System.out.println(" m2() started..");
		
		int c = a/b;
		System.out.println(c);
	     System.out.println(" m2() ended..");
	}

	void m1(int a, int b) {
     System.out.println(" m1() started..");
     m2(a,b);
     System.out.println(" m1() ended..");
	}

	public static void main(String[] args) {

		System.out.println("main() started..");
		try {
			JavaException1 ex1 = new JavaException1();
	        ex1.m1(10, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("main() ended..");
	

	}
}
