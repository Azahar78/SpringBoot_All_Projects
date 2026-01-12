package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.entity.Employee;
import java.util.List;
import java.util.Optional;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

    List<Employee>findByDeptAndName(String eDept,String name);
	
	List<Employee>findBydept(String eDept);
	List<Employee> findByNameLike(String name);
	List<Employee> findByDeptLike(String dept);
	
	// HQl 
	
	@Query("from Employee ")
	List<Employee> getAllEmployee();
	
	@Query("select name from Employee ")
	List<String> getEmpName();
	
	@Query("select name,dept from Employee")
	List<Object[]>getEmpNameAndDept();
	
	@Query("select name from Employee where id=:id")
	Optional<String>getEmpNameById(int id);
	
	@Query("from Employee where id=:id")
	Optional<Employee>getEmpById(int id);
	
	@Query("select dept,count(dept) from Employee group by dept")
	List<Object[]>getEmpByDept();
}
