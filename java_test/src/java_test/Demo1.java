package java_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo1 implements Cloneable {

	public static void main(String[]args) throws IOException {
		
		System.out.println(" enter some word ");
		
	//	Scanner sc =new Scanner(System.in);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String str = reader.readLine();
		char ch[]=str.toCharArray();
		
		Demo1 demo = new Demo1();
		demo.reverseString(str, ch);
		
		System.out.println("-----------------------------");
		
		String reverseStrings = demo.reverseStrings(str, ch);
		
		System.out.println(reverseStrings);
		
		
		System.out.println("===================================");
		
		  String name = demo.getClass().getName();
		  System.out.println(name);
		  
		  
		  

		//System.out.println("hello");
	}
	
	void reverseString(String str,char ch[]) {
		for(int i =str.length()-1;i>=0;i--) {
		     System.out.print(ch[i]+" ");
			}
	}
	
	
	String reverseStrings(String str,char ch[]) {
		
		String temp ="";
		
		for(int i =str.length()-1;i>=0;i--) {
		    
		     temp+=ch[i];
			}
		
		return temp;
	}
}
