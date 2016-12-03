package businessLogic.userBL.driver;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import dataService.webMarketerDataService.WebMarketerDataService_Stub;
import po.WebMarketerPO;
import utilities.ResultMessage;

public class WebMarketerDataService_DriverTest {

	@Test
	public void test1() {
		//test interface getSingle
		WebMarketerDataService_Stub stub = new WebMarketerDataService_Stub();
		WebMarketerDataService_Driver driver = new WebMarketerDataService_Driver(stub);
		
		try {
			assertEquals(ResultMessage.SUCCESS, driver.webMarketerDataService.add(new WebMarketerPO("000001", "123456")));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		//test interface getSingle
		WebMarketerDataService_Stub stub = new WebMarketerDataService_Stub();
		WebMarketerDataService_Driver driver = new WebMarketerDataService_Driver(stub);
		WebMarketerPO webMarketerPO;
		try {
			webMarketerPO = driver.webMarketerDataService.getSingleWebMarketer("000001");
			assertEquals("123456", webMarketerPO.getPassword());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}


}
