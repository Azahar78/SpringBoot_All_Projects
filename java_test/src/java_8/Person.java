package java_8;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Person {

	String name;
	int age;
	
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
	public String toString() {
		return "Person info "+name+" "+age;
	}
	
	
	public static void main(String[] args) {
		
		List<Person> pList = List.of(new Person("jjohn",15),
				new Person("smith", 20),
				new Person("john",30),
				new Person("william", 10),
				new Person("Raja",45),
				new Person("Rani", 40)
				);
		
		Predicate<Person> pAge = age->age.age>=18;
		
		List<Person> pAdult = new LinkedList<>();
		
		List<Person> pUnderAge = new LinkedList<>();
		
		
		for(Person person:pList) {
			
			if(pAge.test(person)) {
				
				pAdult.add(person);
				//System.out.println("List of Adult Person : "+person.name+" "+person.age);
			}
			else {
				//System.out.println("List of under age Person : "+person.name+" "+person.age);
				pUnderAge.add(person);
			}
		}
		
		pAdult.forEach(p->System.out.println("Adult : "+p+"\n"));
		
		pUnderAge.forEach(p->System.out.println("Under Age : "+p+"\n"));
		
		
	}
	
}
