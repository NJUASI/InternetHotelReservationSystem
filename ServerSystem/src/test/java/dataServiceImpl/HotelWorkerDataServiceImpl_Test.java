package dataServiceImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;

import dataService.hotelWorkerDataService.HotelWorkerDataService;
import po.HotelWorkerPO;
import utilities.ResultMessage;

public class HotelWorkerDataServiceImpl_Test {

	@Test
	public void testGetSingleHotelWorker() {
		// test the method GetSingleHotelWorker
		try {
			HotelWorkerDataService hotelWorker = new HotelWorkerDataServiceImpl();
			HotelWorkerPO hotelWorkerPO = hotelWorker.getSingleHotelWorker("00001111");

			assertEquals(hotelWorkerPO.getHotelWorkerID(), "00001111");
			assertEquals(hotelWorkerPO.getPassword(), "123456");
			assertEquals(hotelWorkerPO.getHotelName(), "school");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllHotelWorker() {
		// test the method GetAllHotelWorker
		try {
			HotelWorkerDataService hotelWorker = new HotelWorkerDataServiceImpl();
			List<HotelWorkerPO> list = hotelWorker.getAllHotelWorker();
			HotelWorkerPO hotelWorkerPO = list.get(0);

			assertEquals(hotelWorkerPO.getHotelWorkerID(), "00001111");
			assertEquals(hotelWorkerPO.getPassword(), "123456");
			assertEquals(hotelWorkerPO.getHotelName(), "school");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAdd() {
		// test the method Add
		try {
			HotelWorkerDataService hotelWorker = new HotelWorkerDataServiceImpl();
			HotelWorkerPO hotelWorkerPO = new HotelWorkerPO("00001111", "123456", "school");
			assertEquals(hotelWorker.add(hotelWorkerPO), ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testModify() {
		// test the method Modify
		try {
			HotelWorkerDataService hotelWorker = new HotelWorkerDataServiceImpl();
			HotelWorkerPO hotelWorkerPO = new HotelWorkerPO("00001111", "123456", "school");
			assertEquals(hotelWorker.modify(hotelWorkerPO), ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInitHotelWorker() {
		// test the method initHotelWorker
		try {
			HotelWorkerDataService hotelWorker = new HotelWorkerDataServiceImpl();
			assertEquals(hotelWorker.initHotelWorker("00001111"), ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
