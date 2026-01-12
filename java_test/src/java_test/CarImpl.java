package java_test;

public class CarImpl extends Bike implements Cars{

	@Override
	public void start() {
		System.out.println(" Car Sarted...");
		
	}

	@Override
	public String horn() {
		// TODO Auto-generated method stub
		return "Peep Peep ...";
	}

	@Override
	public void stop() {
		System.out.println(" Car Stopped...");
		
	}

	@Override
	void startBike() {
		System.out.println("Bike starting..");
		
	}

}
