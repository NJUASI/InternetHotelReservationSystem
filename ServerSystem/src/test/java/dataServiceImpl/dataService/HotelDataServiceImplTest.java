package dataServiceImpl.dataService;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataHelper.HotelDataHelper;
import dataHelper.RoomDataHelper;
import dataHelperImpl.stub.HotelDataHelperImpl_Stub;
import dataHelperImpl.stub.RoomInfoDataHelperImpl_Stub;
import po.HotelPO;
import utilities.enums.ResultMessage;

public class HotelDataServiceImplTest {

	private RoomDataHelper roomDataHelper;
	private HotelDataHelper hotelDataHelper;
	
	@Before
	public void setUp() throws Exception {
		roomDataHelper = new RoomInfoDataHelperImpl_Stub();
		hotelDataHelper = new HotelDataHelperImpl_Stub();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHotelInfo() {
		HotelPO po = hotelDataHelper.getHotelInfo("12345670");
		assertEquals("Hotel1",po.getHotelName());
	}

	@Test
	public void testUpdateHotelInfo() {
		assertEquals(ResultMessage.SUCCESS,hotelDataHelper.updateHotelInfo(null));
	}

	@Test
	public void testAddHotelInfo() {
		assertEquals(ResultMessage.SUCCESS,hotelDataHelper.updateHotelInfo(null));
	}

	@Test
	public void testGetHotels() {
		List<HotelPO> list = hotelDataHelper.getHotels("南京", "仙林中心");
		
		assertEquals("Hotel1",list.get(0).getHotelName());
		assertEquals("Hotel2",list.get(1).getHotelName());
	}

	@Test
	public void testUpdateRoomInfo() {
		assertEquals(ResultMessage.SUCCESS,hotelDataHelper.updateHotelInfo(null));
	}

	@Test
	public void testAddRoomInfo() {
		assertEquals(ResultMessage.SUCCESS,hotelDataHelper.updateHotelInfo(null));
	}

	@Test
	public void testDeleteRoomInfo() {
		assertEquals(ResultMessage.SUCCESS,hotelDataHelper.updateHotelInfo(null));
	}

}
