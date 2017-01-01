package testSuits.hotelScan;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import rmi.ClientRemoteHelper;
import vo.HotelVO;

public class HotelScanSuite2 {

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
		Iterator<HotelVO> itr = hotelController.getHotels("南京", "仙林中心");
		while(itr.hasNext())
		{
			System.out.println(itr.next().hotelName);
		}
	}
}
