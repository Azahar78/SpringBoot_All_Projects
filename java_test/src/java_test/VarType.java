package java_test;

public class VarType {

	private int id;
	private String name;
	private String adress;
	
	public VarType(int id,String name,String adress) {
		this.id=id;
		this.name=name;
		this.adress=adress;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAddress(String address) {
		this.adress = address;
	}

	public String getAddress() {
		return this.adress;
	}

	public String toString() {
		return this.id + " " + this.name + " " + this.adress;
	}

	public static void main(String[] args) {

		VarType varType = new VarType(101,"Azahar Khatik","Pune");
	
		
		System.out.println(varType);

	}
}
