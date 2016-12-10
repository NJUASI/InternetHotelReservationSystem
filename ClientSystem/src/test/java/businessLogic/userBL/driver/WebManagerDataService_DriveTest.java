package businessLogic.userBL.driver;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import dataService.webManagerDataService.WebManagerDataService_Stub;
import po.WebManagerPO;
import utilities.Ciphertext;

public class WebManagerDataService_DriveTest {

	@Test
	public void test1() {
		//test interface getSingle
		WebManagerDataService_Stub stub = null;
		try {
			stub = new WebManagerDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		WebManagerDataService_Driver driver = new WebManagerDataService_Driver(stub);
		
		try {
			assertEquals("0001", driver.webManagerDataService.add(new WebManagerPO("0001", "123456")).getWebManagerID());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		//test interface getSingle
		WebManagerDataService_Stub stub = null;
		Ciphertext a = new Ciphertext();
		try {
			stub = new WebManagerDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		WebManagerDataService_Driver driver = new WebManagerDataService_Driver(stub);
		WebManagerPO webManagerPO;
		try {
			webManagerPO = driver.webManagerDataService.getSingleWebManager("0001");
			assertEquals("123456",a.decode( webManagerPO.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
