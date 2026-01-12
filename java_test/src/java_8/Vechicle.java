package java_8;

public interface Vechicle {

	String startEngin();
	
//	void message();
	
	default void cleanVechile() {
		System.out.println("washing done..");
	}
	
	static String turnOnLight() {
		return "Light flash on ";
	}
}
