package presentation.webMarketerUI.driver;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.logInBL.stub.LogInBLService_Stub;
import utilities.ResultMessage;

public class LogInBLService_DriverTest {

	@Test
	public void test1() {
		//test interface webMarketerLogIn
		LogInBLService_Stub stub = new LogInBLService_Stub();
		LogInBLService_Driver driver = new LogInBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.logInBLService.webMarketerLogIn("1234567890","000000"));
	}

}
