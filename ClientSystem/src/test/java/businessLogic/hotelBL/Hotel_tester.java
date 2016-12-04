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
