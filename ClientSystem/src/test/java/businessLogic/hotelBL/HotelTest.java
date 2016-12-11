package businessLogic.hotelBL;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import businessLogic.hotelBL.hotel.Hotel;
import utilities.enums.ResultMessage;
import vo.HotelVO;
import vo.RoomInfoVO;

public class HotelTest {

	Hotel hotel;
	String hotelWorkerID;
	
	@Before
	public void setUp() throws Exception {
		hotelWorkerID = "12345678";
		hotel = new MockHotel("12345678");
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Ignore
	@Test
	public void testGetHotelInfo() {
		HotelVO hotelInfo = hotel.getHotelInfo(hotelWorkerID);
		assertEquals(hotelInfo.city, "NanJing");
	}

	@Test
	public void testUpdateHotelInfo() {
		assertEquals(hotel.updateHotelInfo(new HotelVO(hotel.getHotelPO())), ResultMessage.SUCCESS);
	}

	@Ignore
	@Test
	public void testGetHotelRoomInfo() {
		Iterator<RoomInfoVO> itr = hotel.getHotelRoomInfo(hotelWorkerID);
		assertEquals(itr.next().hotelID, "123");
	}

	@Ignore
	@Test
	public void testUpdateRemainRoomInfo() {
	
	}

	@Test
	public void testAddHotel() {
		assertEquals(hotel.addHotelInfo(new HotelVO(hotel.getHotelPO())), ResultMessage.SUCCESS);
	}

//	@Test
//	public void testUpdateEvaluation() {
//		EvaluationVO evaluation = new EvaluationVO("13", 1, "123");
//		assertEquals(hotel.updateEvaluation(evaluation), ResultMessage.SUCCESS);
//	}

}
