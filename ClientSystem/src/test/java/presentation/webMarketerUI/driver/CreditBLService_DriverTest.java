package presentation.webMarketerUI.driver;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.creditBL.stub.CreditBLService_Stub;
import exception.operationFailedException.UpdateFaiedException;
import exception.verificationException.UserInexistException;
import utilities.enums.ResultMessage;

public class CreditBLService_DriverTest {

	@Test
	public void test1() {
		//test interface charge
		CreditBLService_Stub stub = new CreditBLService_Stub();
		CreditBLService_Driver driver = new CreditBLService_Driver(stub);
		try {
			assertEquals(ResultMessage.SUCCESS, driver.creditBLService.charge("1234567890", 100));
		} catch (UserInexistException e) {
			e.printStackTrace();
		} catch (UpdateFaiedException e) {
			e.printStackTrace();
		}
	
	}
	

}
