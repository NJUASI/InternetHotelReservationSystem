package testSuits.hotelScan;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import rmi.ClientRemoteHelper;
import utilities.enums.SortStrategy;
import vo.HotelVO;

public class HotelScanSuite1 {

	HotelBLService hotelController;
	ClientRemoteHelper clientRemoteHelper;
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper = ClientRemoteHelper.getInstance();
		clientRemoteHelper.setIPandPort("localhost", "8889");
		hotelController = HotelBLController.getInstance();
		hotelController.setGuestID("1234567900");
	}

	@Test
	public void testGetHotels() {
		Iterator<HotelVO> itr = hotelController.getHotels("南京", "新街口地区");
		HotelVO vo1 = itr.next();
		assertEquals("南京天丰大酒店",vo1.hotelName);
	}
	
	@Test
	public void testSortHotels(){
		hotelController.getHotels("南京", "新街口地区");
		Iterator<HotelVO> itr = hotelController.sortHotels(SortStrategy.DESCSCORE);
		HotelVO vo1 = itr.next();
		assertEquals("南京金陵饭店",vo1.hotelName);
	}
	
	@Test
	public void testGetBookedHotels(){
		Iterator<HotelVO> itr = hotelController.getAllBookedHotels();
		HotelVO vo1 = itr.next();
		assertEquals("南京英尊假日酒店",vo1.hotelName);
	}
}