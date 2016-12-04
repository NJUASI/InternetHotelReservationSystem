package businessLogic.hotelBL;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import businessLogic.hotelBL.hotel.Hotel;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.CheckInVO;
import vo.CheckOutVO;
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

	@Test
	public void testGetHotelInfo() {
		HotelVO hotelInfo = hotel.getHotelInfo(hotelWorkerID);
		assertEquals(hotelInfo.city, "NanJing");
	}

	@Test
	public void testUpdateHotelInfo() {
		assertEquals(hotel.updateHotelInfo(new HotelVO(hotel.getHotelPO())), ResultMessage.SUCCESS);
	}

	@Test
	public void testGetHotelRoomInfo() {
		Iterator<RoomInfoVO> itr = hotel.getHotelRoomInfo(hotelWorkerID);
		assertEquals(itr.next().hotelID, "123");
	}

	@Test
	public void testUpdateHotelRoomInfo() {
		RoomInfoVO vo = new RoomInfoVO("12345678","高级大床房",10,5,100);
		assertEquals(hotel.updateHotelRoomInfo(vo,"高级大床房"), ResultMessage.SUCCESS);
	}

	@Test
	public void testUpdateCheckIn() {
		CheckInVO checkInVO = new CheckInVO("123", "123", LocalDateTime.now(), LocalDateTime.now());
		assertEquals(hotel.updateCheckIn(checkInVO), ResultMessage.SUCCESS);
	}

	@Test
	public void testUpdateCheckOut() {
		CheckOutVO checkOutVO = new CheckOutVO("123", LocalDateTime.now());
		assertEquals(hotel.updateCheckOut(checkOutVO), ResultMessage.SUCCESS);
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
