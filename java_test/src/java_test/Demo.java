package java_test;

public class Demo {
	
	public static void main(String args[]) {
		
		CarImpl carImpl = new CarImpl();
		carImpl.start();
		System.out.println(carImpl.horn());
		carImpl.stop();
		
		Cars.carType();
		carImpl.startBike();
		carImpl.racing();
		
		Cars c =new CarImpl();
		
		System.out.println("====================================");
		
		c.start();
		System.out.println(c.horn());
		c.stop();
		
		Bike b =new CarImpl();
		
		System.out.println("====================================");
		
		b.startBike();
		b.racing();
	}
}


