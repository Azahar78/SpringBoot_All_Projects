package java_test;

import java.util.Arrays;

public class VArgs {

	static String[] fruits(String... friut) {
		
		String fruits[]= friut;
		
		return fruits;
	}
	
	public static void main(String[] args) {
		
	String[] ft =fruits("apple","mango","banana");
	
	
		System.out.println(Arrays.toString(ft));
		
		for(String fruits:ft) {
			System.out.print(fruits+" ");
		}
	}
}
