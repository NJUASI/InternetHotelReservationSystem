package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dataHelper.HotelWorkerDataHelper;
import dataHelperImpl.HotelWorkerDataHelperImpl;
import po.HotelWorkerPO;
import utilities.ResultMessage;

public class HotelWorkerDataHelperImplTest {

	HotelWorkerDataHelper helper = null;
	
	@Before
	public void setUp() throws Exception {
		helper  = new HotelWorkerDataHelperImpl();
	}

	@Test
	public void testAdd() {
		HotelWorkerPO hotelWorkerPO  = new HotelWorkerPO("11110000", "123456","金鹰"); 
		assertEquals(ResultMessage.SUCCESS,helper.add(hotelWorkerPO));
	}

	@Test
	public void testModify() {
		HotelWorkerPO hotelWorkerPO  = new HotelWorkerPO("12345678", "111111","centerOfNanJing");
		assertEquals(ResultMessage.SUCCESS,helper.modify(hotelWorkerPO));
		
	}

	@Test
	public void testDelete() {
		assertEquals(ResultMessage.SUCCESS,helper.delete("11110000"));
	}

	@Test
	public void testGetSingle() {
		HotelWorkerPO hotelWorkerPO  = helper.getSingle("98765432");
		assertEquals("000000",hotelWorkerPO.getPassword());
		assertEquals("如家",hotelWorkerPO.getHotelName());
	}

	@Test
	public void testGetAll() {
		List<HotelWorkerPO> list = helper.getAll();
		
		assertEquals("000000",list.get(2).getPassword());
		assertEquals("如家",list.get(2).getHotelName());
	}
}
