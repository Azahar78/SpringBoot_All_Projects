package java_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaStreamDemo1 {

	public static void main(String[] args) {
		
		List<Employee> list = Arrays.asList(
				new Employee("john",22,30000.03),
				new Employee("devid",35,50000.03),
				new Employee("Abdul",12,20000.03),
				new Employee("Raja",22,70000.03),
				new Employee("Shazen",1,100000.03)
				);
		
		list.stream().filter(emp->emp.salary<=30000.0).forEach(emp->System.out.println(emp.name+" "+emp.age));
		
		List<Employee> empList = list.stream().filter(emp->emp.salary>=30000).collect(Collectors.toList());
		
		empList.forEach(emp->System.out.println(emp));
		
		 Optional<Employee> empOptional = list.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.salary)));
	
		System.out.println("Max Salary : "+empOptional.get()+empOptional.isPresent());
		
		Map<Integer, List<Employee>> ageby = empList.stream().collect(Collectors.groupingBy(e->e.age));
		
		Map<Integer, Long> collect = empList.stream().collect(Collectors.groupingBy(e->e.age,Collectors.counting()));
		
		
		System.out.println(collect);
		
		System.out.println(ageby.get(22));
	   
	}
}

class Employee{
	
	String name;
	int age;
	double salary;
	Employee(String name,int age, double salary){
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	
	
	public String toString() {
		return"Employee : "+name+" "+age+" "+salary;
	}
}