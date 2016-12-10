package dataServiceImpl;

import java.time.LocalDate;

public class test {

	public static void main(String[] args) {
		String random = formateRandomNumber((int) (Math.random() * 10000));
		String date = formateDate(LocalDate.of(2016, 5, 28));
		System.out.println(random+date);
	}
	
	private static String formateRandomNumber(int randomNumber) {
		if (randomNumber >= 1000 && randomNumber <= 9999) {
			return String.valueOf(randomNumber);
		} else if (randomNumber > 100 && randomNumber <= 999) {
			return "0" + String.valueOf(randomNumber);
		} else if (randomNumber > 10 && randomNumber <= 99) {
			return "00" + String.valueOf(randomNumber);
		} else {
			return "000" + String.valueOf(randomNumber);
		}
	}

	private static String formateDate(LocalDate localDate) {
		String temp = localDate.toString();
		return temp.substring(0, 4) + temp.substring(5, 7) + temp.substring(8);
	}
}
