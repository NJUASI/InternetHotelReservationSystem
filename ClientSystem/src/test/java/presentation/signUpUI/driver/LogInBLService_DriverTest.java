package presentation.signUpUI.driver;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import businessLogic.logInBL.stub.LogInBLService_Stub;
import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import vo.GuestVO;

public class LogInBLService_DriverTest {

	@Test
	public void test1() {
		//test interface guestSignUp
		try {
			LogInBLService_Stub stub = new LogInBLService_Stub();
			LogInBLService_Driver driver = new LogInBLService_Driver(stub);
			assertEquals(null, driver.logInBLService.guestSignUp(new GuestVO("1234567890", 
					LocalDate.of(1995, 4, 1), "school","zhangsan", "xiaosan", "000000", "13568792345", 100)));
		} catch (InvalidInputException e) {
			e.printStackTrace();
		} catch (PasswordInputException e) {
			e.printStackTrace();
		} catch (InvalidLengthInputException e) {
			e.printStackTrace();
		}
	}
}
