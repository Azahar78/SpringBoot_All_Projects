package java_8;

import java.util.function.Predicate;

public class Demo1 implements Vechicle {

	public static void main(String[] args) {
		
		/*
		 * Vechicle vechicle = new Vechicle() {
		 * 
		 * @Override public String startEngin() {
		 * 
		 * return "Engin Started.."; } };
		 */
		
		Demo1 demo1 = new Demo1();
		
		
		Predicate<Integer> p= num -> num >=100;
		
		Predicate<String> pName = name->name.equals("john");
		
		
		System.out.println(p.test(90)?" Done ":"Failed");
		
		System.out.println(pName.test("John")?" Match ":"Not Matched");
		
		Vechicle vechicle=()->"Engin Stated with full power";
		
		String startEngin = demo1.startEngin();
		demo1.cleanVechile();
		
		System.out.println(startEngin+" "+Vechicle.turnOnLight());
		
		System.out.println(vechicle.startEngin());
}

	@Override
	public String startEngin() {
		
		return "Engin Started..";
	}

	
}
