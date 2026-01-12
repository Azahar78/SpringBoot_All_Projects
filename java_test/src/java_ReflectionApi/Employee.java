package java_ReflectionApi;

public class Employee {

	 int id;
	 String name;
	 String add;
	 
	 void getMessage(String msg) {
		 System.out.println(msg);
	 }
	 
	 Employee getDetails(int id ,String name,String add) {
		 
		 Employee emp = new Employee();
		 emp.id=id;
		 emp.name=name;
		 emp.add=add;
		 
		 return emp;
		 
	 }
	 
	 
	 
	 public String toString() {
		 return "Employee id : "+this.id+" Name : "+this.name+" Address : "+this.add;
	 }
	
}
