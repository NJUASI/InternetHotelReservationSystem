package presentation.hotelWorkerUI.driver;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.logInBL.stub.LogInBLService_Stub;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.SpecialCharacterException;
import exception.verificationException.UserInexistException;
import exception.verificationException.WrongPasswordException;
import utilities.enums.UserType;

public class LogInBLService_DriverTest {

	@Test
	public void test1() {
		//test interface hotelWorkerLogIn
		LogInBLService_Stub stub = new LogInBLService_Stub();
		LogInBLService_Driver driver = new LogInBLService_Driver(stub);
		try {
			assertEquals(UserType.HOTEL_WORKER, driver.logInBLService.logIn("12345678","123456"));
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

}
