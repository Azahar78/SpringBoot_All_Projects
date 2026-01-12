package withAutowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredDemo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ac = new  AnnotationConfigApplicationContext();
		
		ac.scan("withAutowired");
		ac.refresh();
		Service service = ac.getBean("service",Service.class);
		
		System.out.println(service);
	}
}
