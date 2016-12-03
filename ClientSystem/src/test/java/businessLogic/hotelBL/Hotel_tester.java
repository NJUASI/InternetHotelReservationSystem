package businessLogic.hotelBL;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Iterator;

import org.junit.Ignore;
import org.junit.Test;

import vo.HotelEvaluationVO;
import vo.HotelGeneralVO;

public class Hotel_tester {
	
	@Ignore
	@Test
	public void test1() {
		//test cooperation with class Order
		//test interface getBookedHotels
		HotelController hotelController = HotelController.getInstance();
		Iterator<HotelGeneralVO> list = hotelController.getBookedHotels();
		HotelGeneralVO hotelGeneralVO1=list.next();
		HotelGeneralVO hotelGeneralVO2=list.next();
		
		assertEquals("12345678", hotelGeneralVO1.hotelID);
		assertEquals("thisHotel", hotelGeneralVO1.hotelName);
		assertEquals("NanJing", hotelGeneralVO1.city);
		assertEquals("center", hotelGeneralVO1.cycle);
		assertEquals("4", hotelGeneralVO1.level);
		assertEquals(5, hotelGeneralVO1.score, 0);
		
		assertEquals("12345679", hotelGeneralVO2.hotelID);
		assertEquals("thatHotel", hotelGeneralVO2.hotelName);
		assertEquals("NanJing", hotelGeneralVO2.city);
		assertEquals("center", hotelGeneralVO2.cycle);
		assertEquals("4", hotelGeneralVO2.level);
		assertEquals(5, hotelGeneralVO2.score, 0);
	}
	
	@Ignore
	@Test
	public void test2() {
		//test cooperation with class Order
		//test interface getEvaluation
		HotelController hotelController = HotelController.getInstance();
		Iterator<HotelEvaluationVO> list = hotelController.getEvaluations("12345678");
		HotelEvaluationVO evaluationVO1=list.next();
		HotelEvaluationVO evaluationVO2=list.next();
		
		assertEquals("1234567890", evaluationVO1.guestID);
		assertEquals(LocalDate.of(2016, 11, 21), evaluationVO1.checkInDate);
		assertEquals(4.5, evaluationVO1.score, 0);
		assertEquals("good", evaluationVO1.comment);
		
		assertEquals("1234567891", evaluationVO2.guestID);
		assertEquals(LocalDate.of(2016, 11, 22), evaluationVO2.checkInDate);
		assertEquals(4.7, evaluationVO2.score, 0);
		assertEquals("very good", evaluationVO2.comment);
	}
	
}
