package presentation.guestUI.driver;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelBL.stub.HotelBLService_Stub;
import utilities.enums.ResultMessage;
import utilities.enums.RoomType;
import vo.HotelVO;
import vo.RoomInfoVO;

public class HotelBLService_DriverTest {

	HotelBLService_Stub stub ;
	HotelBLService_Driver driver;

	@Before
	public void setUp() throws Exception {
		stub = new HotelBLService_Stub();
		driver = new HotelBLService_Driver(stub);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddHotel() {
		assertEquals(ResultMessage.SUCCESS,driver.hotelBLService.addHotel(new HotelVO()));
	}

	@Test
	public void testUpdateHotelInfo() {
		assertEquals(ResultMessage.SUCCESS,driver.hotelBLService.updateHotelInfo(new HotelVO()));
	}

	@Test
	public void testGetHotelInfo() {
		assertEquals("1天",driver.hotelBLService.getHotelInfo("12345678").hotelName);
	}

	@Test
	public void testAddRoomType() {
		assertEquals(ResultMessage.SUCCESS,driver.hotelBLService.addRoomType(new RoomInfoVO()));
	}

	@Test
	public void testUpdateHotelRoomInfo() {
		assertEquals(ResultMessage.SUCCESS,driver.hotelBLService.updateHotelInfo(new HotelVO()));
	}

	@Test
	public void testGetHotelRoomInfo() {
		Iterator<RoomInfoVO> itr = driver.hotelBLService.getHotelRoomInfo("12345678");
		assertEquals(100,itr.next().price,0.1);
	}

	@Test
	public void testGetRemainRoomNum() {
		Iterator<RoomInfoVO> itr = driver.hotelBLService.getHotelRoomInfo("12345678");
		assertEquals(RoomType.DOUBLE_BED,itr.next().roomType);
	}

	@Test
	public void testGetOriginPrice() {
		Iterator<RoomInfoVO> itr = driver.hotelBLService.getHotelRoomInfo("12345678");
		assertEquals(100,itr.next().price,0.1);
	}

	@Test
	public void testCheckInOffline() {
		assertEquals(ResultMessage.SUCCESS,driver.hotelBLService.checkInOffline("12345678", RoomType.DOUBLE_BED, 10));
	}

	@Test
	public void testCheckOutOffline() {
		assertEquals(ResultMessage.SUCCESS,driver.hotelBLService.checkOutOffline("1234567", RoomType.BUSINESS_SUITE, 5));
	}

	@Test
	public void testGetAllBookedHotels() {
		Iterator<HotelVO> itr = driver.hotelBLService.getAllBookedHotels();
		assertEquals("1天",itr.next().hotelName);
	}

	@Test
	public void testGetHotels() {
		Iterator<HotelVO> itr = driver.hotelBLService.getAllBookedHotels();
		assertEquals("1天",itr.next().hotelName);
	}

	@Test
	public void testSortHotels() {
		Iterator<HotelVO> itr = driver.hotelBLService.getAllBookedHotels();
		assertEquals("1天",itr.next().hotelName);
	}

	@Test
	public void testSearchHotels() {
		Iterator<HotelVO> itr = driver.hotelBLService.getAllBookedHotels();
		assertEquals("1天",itr.next().hotelName);
	}

}
