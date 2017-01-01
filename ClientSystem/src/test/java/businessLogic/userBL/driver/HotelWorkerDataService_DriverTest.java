package businessLogic.userBL.driver;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import dataService.hotelWorkerDataService.HotelWorkerDataService_Stub;
import po.HotelWorkerPO;
import utilities.enums.ResultMessage;

public class HotelWorkerDataService_DriverTest {

	@Test
	public void test1() {
		//test interface getSingle
		
		try {
			HotelWorkerDataService_Stub stub = new HotelWorkerDataService_Stub();
			HotelWorkerDataService_Driver driver = new HotelWorkerDataService_Driver(stub);
			
			HotelWorkerPO hotelWorkerPO = driver.hotelWorkerDataService.getSingleHotelWorker("00001111");
			
			assertEquals("123456", hotelWorkerPO.getPassword());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void test2() {
		//test interface add
		
		try {	
			HotelWorkerDataService_Stub stub = new HotelWorkerDataService_Stub();
			HotelWorkerDataService_Driver driver = new HotelWorkerDataService_Driver(stub);
			
			assertEquals(ResultMessage.SUCCESS, driver.hotelWorkerDataService.add(new HotelWorkerPO("00001111", "123456")));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
