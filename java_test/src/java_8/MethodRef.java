package java_8;

public class MethodRef {

	public static void main(String[] args) {
		
		MethodRef ref = new MethodRef();
		
		MethodInterface m2 =ref::m2;
		
		String m1 = m2.m1();
		
		System.out.println(m1);
		
	}

	String m2() {
		return "m2() called..";
	}
}


interface MethodInterface{
	
	String m1();
}