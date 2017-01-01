package businessLogic.logInBL;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.verificationException.UserInexistException;
import utilities.enums.UserType;
import vo.GuestVO;

public class LogIn_tester {

	@Test
	public void test1() {
		//test cooperation with class User
		//test interface guestLogIn(String guest, String password)
		LogInController controller = LogInController.getInstance();
			
		try {
			assertEquals(UserType.GUEST, controller.logIn("1234567890", "123456"));
			assertEquals(UserType.HOTEL_WORKER, controller.logIn("00001111", "123456"));
			assertEquals(UserType.WEB_MARKETER, controller.logIn("000001", "123456"));
			assertEquals(UserType.WEB_MANAGER, controller.logIn("0001", "123456"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void test2() {
		//test cooperation with class User
		//test interface guestSignUp(GuestVO guestVO)
		LogInController controller = LogInController.getInstance();
		
		GuestVO guestVO = new GuestVO("1234567890", LocalDate.of(1995, 4, 1), "school", "zhangsan", 
				"xiaosan", "000000", "13523456789", 100);
			
		try {
			assertEquals("1234567890", controller.guestSignUp(guestVO).userID);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		} catch (PasswordInputException e) {
			e.printStackTrace();
		} catch (InvalidLengthInputException e) {
			e.printStackTrace();
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
	}

}
