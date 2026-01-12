package java_ReflectionApi;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionApi {

	public static void main(String[] args) throws Exception {
		
		Class em = Class.forName("java_ReflectionApi.Employee");
		
		new ReflectionApi().getMethodName("java_ReflectionApi.Employee");
		
		Field[] fields = em.getDeclaredFields();
		
		for(Field f:fields) {
		
		//	System.out.println(f.getName());
		}
		
		System.out.println("==============================================");
		
		Method[] methods = em.getDeclaredMethods();
		
		for(Method f:methods) {
			
		//	System.out.println(f.getName());
		}
		
	
		
		
	}
	
	void getMethodName(String cls) {
		
		try {
			Class classs = Class.forName(cls);
			
		//	System.out.println(classs.getDeclaredFields());
			
			Field[] fields = classs.getDeclaredFields();
			
			for(Field f:fields) {
				System.out.println(f);
			}
			
			System.out.println("=====");
			
			Method[] methods = classs.getDeclaredMethods();
			
			for(Method f:methods) {
				System.out.println(f);
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
}
