package presentation.guestUI.driver;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import businessLogic.logInBL.stub.LogInBLService_Stub;
import utilities.ResultMessage;
import vo.GuestVO;

public class LogInBLService_DriverTest {

	@Test
	public void test1() {
		//test interface guestLogIn
		LogInBLService_Stub stub = new LogInBLService_Stub();
		LogInBLService_Driver driver = new LogInBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.logInBLService.guestLogIn("1234567890","000000"));
	}

	@Test
	public void test2() {
		//test interface guestSignUp
		LogInBLService_Stub stub = new LogInBLService_Stub();
		LogInBLService_Driver driver = new LogInBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.logInBLService.guestSignUp(new GuestVO("1234567890", 
				LocalDate.of(1995, 4, 1), "school","zhangsan", "xiaosan", "000000", "13568792345", 100)));
	}
}
