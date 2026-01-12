package java_8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JavaLocalDate {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(2025,11,24);
		
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println(date.format(pattern));
	}
}
