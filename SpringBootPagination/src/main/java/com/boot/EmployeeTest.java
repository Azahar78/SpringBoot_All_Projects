package com.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.boot.entity.Employee;
import com.boot.repo.EmployeeRepo;

//@Component
public class EmployeeTest implements CommandLineRunner {

	//@Autowired
	private EmployeeRepo repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * Employee emp1 = new Employee(1, "John Doe", 4556.0, "DevOps"); Employee emp2
		 * = new Employee(2, "Jane Smith", 4689.0, "Development"); Employee emp3 = new
		 * Employee(3, "Paul Brown", 4899.0, "HR"); Employee emp4 = new Employee(4,
		 * "Anna White", 5000.0, "Marketing"); Employee emp5 = new Employee(5,
		 * "Mike Johnson", 5200.0, "DevOps"); Employee emp6 = new Employee(6,
		 * "Sara Davis", 5500.0, "HR"); Employee emp7 = new Employee(7, "Tom Wilson",
		 * 5700.0, "Development"); Employee emp8 = new Employee(8, "Lucy Clark", 5900.0,
		 * "Marketing"); Employee emp9 = new Employee(9, "James Martinez", 6100.0,
		 * "DevOps"); Employee emp10 = new Employee(10, "Emma Lewis", 6300.0, "HR");
		 * Employee emp11 = new Employee(11, "Daniel Walker", 6500.0, "Development");
		 * Employee emp12 = new Employee(12, "Laura Hall", 6700.0, "Marketing");
		 * Employee emp13 = new Employee(13, "Matthew Allen", 6900.0, "Development");
		 * Employee emp14 = new Employee(14, "Olivia Young", 7100.0, "IT"); Employee
		 * emp15 = new Employee(15, "Ethan Scott", 7300.0, "Quality Assurance");
		 * Employee emp16 = new Employee(16, "Sophia King", 7500.0, "Training");
		 * Employee emp17 = new Employee(17, "Lucas Adams", 7700.0, "IT"); Employee
		 * emp18 = new Employee(18, "Mia Baker", 7900.0, "HR"); Employee emp19 = new
		 * Employee(19, "David Carter", 8100.0, "Quality Assurance"); Employee emp20 =
		 * new Employee(20, "Isabella Nelson", 8300.0, "IT");
		 * 
		 * 
		 * List<Employee> emplist = Arrays.asList(emp1,emp2,emp3,emp4,emp5,
		 * emp6,emp7,emp8,emp9,emp10,emp11, emp12,emp13,emp13,emp14,emp15,emp16,
		 * emp17,emp18,emp19,emp20);
		 * 
		 * repo.saveAll(emplist);
		 */

		// List<Employee> list =
		// repo.findAll(Sort.by(Order.asc("name"),Order.desc("dept")));

		// list.forEach(employee->System.out.println(employee));

		/*
		 * PageRequest pageReq = PageRequest.of(4, 4);
		 * 
		 * Page<Employee> page = repo.findAll(pageReq);
		 * 
		 * long elements = page.getTotalElements();
		 * 
		 * System.out.println(" Number of total element : "
		 * +elements+" No of total Pages : "+page.getTotalPages());
		 * 
		 * List<Employee> list = page.getContent();
		 * 
		 * list.forEach(System.out::println);
		 */

		System.out.println("====================================================");

         Employee employee = new Employee();
		 employee.setDept("HR");
		 
		 ExampleMatcher matcher = ExampleMatcher.matching()
				    .withIgnorePaths("id")
				    .withIgnorePaths("name")
				    .withIgnorePaths("salary")
				    .withMatcher("dept", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase()); 

		 
		 
		 
		System.out.println(employee);

		
		
		
		Example<Employee> of = Example.of(employee,matcher);

	   System.out.println(repo.count(of));

		repo.findAll(of).forEach(System.out::println);

	
		
		

	}
}
