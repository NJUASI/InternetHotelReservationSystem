package businessLogic.hotelBL.driver;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import businessLogic.hotelBL.stub.HotelBLService_Stub;
import dataService.hotelDataService.HotelDataService_Stub;
import po.HotelPO;
import presentation.guestUI.driver.HotelBLService_Driver;
import utilities.enums.ResultMessage;
import utilities.enums.RoomType;
import vo.HotelVO;
import vo.RoomInfoVO;

public class HotelDataService_DriverTest {

	HotelDataService_Stub stub ;
	HotelBLService_Driver driver;

	@Before
	public void setUp() throws Exception {
		stub = new HotelDataService_Stub();
	}

	@After
	public void tearDown() throws Exception {
	}

	
}
