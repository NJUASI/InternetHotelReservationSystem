package businessLogic.userBL.driver;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import dataService.webManagerDataService.WebManagerDataService_Stub;
import po.WebManagerPO;
import utilities.ResultMessage;

public class WebManagerDataService_DriveTest {

	@Test
	public void test1() {
		//test interface getSingle
		WebManagerDataService_Stub stub = new WebManagerDataService_Stub();
		WebManagerDataService_Driver driver = new WebManagerDataService_Driver(stub);
		
		try {
			assertEquals(ResultMessage.SUCCESS, driver.webManagerDataService.add(new WebManagerPO("0001", "123456")));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		//test interface getSingle
		WebManagerDataService_Stub stub = new WebManagerDataService_Stub();
		WebManagerDataService_Driver driver = new WebManagerDataService_Driver(stub);
		WebManagerPO webManagerPO;
		try {
			webManagerPO = driver.webManagerDataService.getSingleWebManager("0001");
			assertEquals("123456", webManagerPO.getPassword());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
