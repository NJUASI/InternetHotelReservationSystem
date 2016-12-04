package presentation.hotelWorkerUI.driver;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.hotelBL.stub.HotelBLService_Stub;
import vo.HotelVO;

public class HotelBLService_DriverTest {

	@Test
	public void test1() {
		//test interface getHotelDetail
		HotelBLService_Stub stub = new HotelBLService_Stub();
		HotelBLService_Driver driver = new HotelBLService_Driver(stub);
		HotelVO hotelVO = driver.hotelBLService.getHotelInfo("12345678");
				
		assertEquals("12345678", hotelVO.hotelID);
		assertEquals("thisHotel", hotelVO.hotelName);
		assertEquals("NanJing", hotelVO.city);
		assertEquals("center", hotelVO.cycle);
		assertEquals("4", hotelVO.level);
		assertEquals(5, hotelVO.score, 0);
		assertEquals("good", hotelVO.introduction);
		assertEquals("allEquipment", hotelVO.equipment);
	}
}
