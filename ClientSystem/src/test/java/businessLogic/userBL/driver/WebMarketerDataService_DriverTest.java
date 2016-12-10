package businessLogic.userBL.driver;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import dataService.webMarketerDataService.WebMarketerDataService_Stub;
import po.WebMarketerPO;
import utilities.Ciphertext;

public class WebMarketerDataService_DriverTest {

	@Test
	public void test1() {
		//test interface getSingle
		WebMarketerDataService_Stub stub = null;
		try {
			stub = new WebMarketerDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		WebMarketerDataService_Driver driver = new WebMarketerDataService_Driver(stub);
		
		try {
			assertEquals("000001", driver.webMarketerDataService.add(new WebMarketerPO("000001", "123456")).getWebMarketerID());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		//test interface getSingle
		WebMarketerDataService_Stub stub = null;
		Ciphertext a = new Ciphertext();
		try {
			stub = new WebMarketerDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		WebMarketerDataService_Driver driver = new WebMarketerDataService_Driver(stub);
		WebMarketerPO webMarketerPO;
		try {
			webMarketerPO = driver.webMarketerDataService.getSingleWebMarketer("000001");
			assertEquals("123456", a.decode(webMarketerPO.getPassword()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}


}
