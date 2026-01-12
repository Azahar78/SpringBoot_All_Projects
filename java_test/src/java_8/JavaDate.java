package java_8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDate {

	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd|MM|YYYY");
		String format = dateFormat.format(date);
		
		System.out.println(format);
		
		
		try {
			Date date2 = dateFormat.parse("17|05|2025");
			System.out.println(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
