package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataHelper.HotelDataHelper;
import dataHelperImpl.HotelDataHelperImpl;
import po.HotelGeneralPO;

public class HotelDataHelperImplTest {

	List<HotelGeneralPO> list;
	HotelDataHelper helper;
	
	@Before
	public void setUp() throws Exception {
		helper = new HotelDataHelperImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHotelGenerals() {
		
		list = helper.getHotelGenerals("南京", "仙林中心");
		
		assertEquals("如家", list.get(0).getHotelName());
		assertEquals("7天", list.get(1).getHotelName());
	}

}
