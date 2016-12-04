package presentation.guestUI.driver;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Ignore;
import org.junit.Test;

import businessLogic.hotelBL.stub.HotelBLService_Stub;
import vo.HotelVO;

/**
 * 
 * @author Harvey
 * lastChangedBy charles
 * updateTime 2016/12/2
 * 
 * 去除Evaluation测试
 */
public class HotelBLService_DriverTest {

	@Ignore
	@Test
	public void test1() {
		//test interface getHotelList
		HotelBLService_Stub stub = new HotelBLService_Stub();
		HotelBLService_Driver driver = new HotelBLService_Driver(stub);
		Iterator<HotelVO> list = driver.hotelBLService.getHotels("南京", "仙林");
		HotelVO hotelGeneralVO1 = list.next();
		HotelVO hotelGeneralVO2 = list.next();
		
		assertEquals("thisHotel", hotelGeneralVO1.hotelName);
		assertEquals("NanJing", hotelGeneralVO1.city);
		assertEquals("center", hotelGeneralVO1.cycle);
		assertEquals("4", hotelGeneralVO1.level);
		assertEquals(5, hotelGeneralVO1.score, 0);
		
		assertEquals("thisHotel", hotelGeneralVO2.hotelName);
		assertEquals("NanJing", hotelGeneralVO2.city);
		assertEquals("center", hotelGeneralVO2.cycle);
		assertEquals("4", hotelGeneralVO2.level);
		assertEquals(5, hotelGeneralVO2.score, 0);
	}

	@Ignore
	@Test
	public void test2() {
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
	
//	@Test
//	public void test3() {
//		//test interface Evaluation
//		HotelBLService_Stub stub = new HotelBLService_Stub();
//		HotelBLService_Driver driver = new HotelBLService_Driver(stub);
//		
//		assertEquals(ResultMessage.SUCCESS, driver.hotelBLService.updateEvaluation(new EvaluationVO
//				("123420161002", 4, "5")));
//	}
}
