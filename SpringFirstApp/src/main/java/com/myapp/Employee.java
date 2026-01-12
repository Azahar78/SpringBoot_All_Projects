package com.myapp;

public class Employee {

	private Person person;
	private String dept;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Employee [person=" + person + ", dept=" + dept + "]";
	}
	
	
}
