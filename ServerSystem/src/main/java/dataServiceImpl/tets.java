package dataServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class tets {

	public static void main(String[] args) {
		
		LocalDateTime thisTime = LocalDateTime.of(2016, 01, 01, 13, 43);
		System.out.println(thisTime.toLocalDate().toString());
		System.out.println(formateDate(thisTime.toLocalDate()));

	}
	
	private static String formateDate(LocalDate localDate) {
		String temp = localDate.toString();
		return temp.substring(0, 4) + temp.substring(5, 7) + temp.substring(8);
	}
}
