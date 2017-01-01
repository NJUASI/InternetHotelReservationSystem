package presentation.guestUI.driver;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import businessLogic.logInBL.stub.LogInBLService_Stub;
import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.inputException.SpecialCharacterException;
import exception.verificationException.UserInexistException;
import exception.verificationException.WrongPasswordException;
import utilities.enums.UserType;
import vo.GuestVO;

public class LogInBLService_DriverTest {

	@Test
	public void test1() {
		//test interface guestLogIn
		LogInBLService_Stub stub = new LogInBLService_Stub();
		LogInBLService_Driver driver = new LogInBLService_Driver(stub);
		try {
			assertEquals(UserType.GUEST, driver.logInBLService.logIn("1234567890","000000"));
		} catch (SpecialCharacterException e) {
			e.printStackTrace();
		} catch (WrongPasswordException e) {
			e.printStackTrace();
		} catch (InvalidLengthInputException e) {
			e.printStackTrace();
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		//test interface guestSignUp
		LogInBLService_Stub stub = new LogInBLService_Stub();
		LogInBLService_Driver driver = new LogInBLService_Driver(stub);
		try {
			assertEquals("1234567890", driver.logInBLService.guestSignUp(new GuestVO("1234567890", 
					LocalDate.of(1995, 4, 1), "school","zhangsan", "xiaosan", "000000", "13568792345", 100)).userID);
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
