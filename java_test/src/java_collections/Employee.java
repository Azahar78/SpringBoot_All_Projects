package java_collections;

import java.lang.Thread.Builder;

public class Employee {

	private String name;
	private boolean isPermanate;
	private String address;
	
	private Employee(Builder builder ) {
		this.name=builder.name;
		this.isPermanate=builder.isPermanate;
		this.address=builder.address;
	}
	
	public static class Builder {
		
		private String name;
		private boolean isPermanate;
		private String address;
	
		/*
		public Builder(String name) {
			this.name = name;
		}
		*/
		public Builder() {
			super();
		}
		
		public Builder setName(String name) {
			this.name=name;
			return this;
		}
		public Builder setisPermanate(boolean isPermanate) {
			this.isPermanate=isPermanate;
			return this;
		}
		
		public Builder setAddress(String address) {
			this.address=address;
			return this;
		}
		
		public Employee build() {
			return new Employee(this);
		} 
	}
	
	@Override
	public String toString() {
		
		return "Employee : "+name+" "+((isPermanate)?" Yes..":" No..")+" "+address;
	}
	
	public static void main(String[] args) {
		
		Employee employee = new Employee.Builder().setName("John")
				.setisPermanate(false)
				.setAddress("Dubai")
				.build();
		
		System.out.println(employee);
	}
}
