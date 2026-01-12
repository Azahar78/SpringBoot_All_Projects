package java_test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		 Class<?> carClz = Class.forName("java_test.Car");  // Corrected line
	        Constructor<?> constructor = carClz.getConstructor(String.class, int.class);
	        
	        // Create an instance of Car using reflection
	        Object obj = constructor.newInstance("Honda", 222);
	        
	        // Print the object (invoking the toString() method)
	        System.out.println(obj);
		
	}
}

class Car {
    String model;
    int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return model + " " + year;
    }
}