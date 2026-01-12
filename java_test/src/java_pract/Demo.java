package java_pract;

public class Demo {

	public static void main(String[] args) {
		
		Vehicle v = new Vehicle() {
		
		@Override
		public void message() {
			System.out.println(" Hello , Good Afternoon..");
			
		}
		
		@Override
		public String info(String msg) {
			
			return msg;
		}
	};
	
	
	v.message();
	
	String info = v.info("john");
	
	System.out.println(info);
		
	}
}
