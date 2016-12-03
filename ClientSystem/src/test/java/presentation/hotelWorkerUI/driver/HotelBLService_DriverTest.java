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
				
		assertEquals("12345678", hotelVO.hotelGeneralVO.hotelID);
		assertEquals("thisHotel", hotelVO.hotelGeneralVO.hotelName);
		assertEquals("address", hotelVO.hotelAddress);
		assertEquals("NanJing", hotelVO.hotelGeneralVO.city);
		assertEquals("center", hotelVO.hotelGeneralVO.cycle);
		assertEquals("4", hotelVO.hotelGeneralVO.level);
		assertEquals(5, hotelVO.hotelGeneralVO.score, 0);
		assertEquals("good", hotelVO.introduction);
		assertEquals("allEquipment", hotelVO.equipment);
	}
}
