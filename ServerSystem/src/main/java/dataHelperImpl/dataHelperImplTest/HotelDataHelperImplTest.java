package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import dataHelper.HotelDataHelper;
import dataHelperImpl.HotelDataHelperImpl;
import po.HotelPO;

public class HotelDataHelperImplTest {

	List<HotelPO> list;
	HotelDataHelper helper;

	@Before
	public void setUp() throws Exception {
		helper = new HotelDataHelperImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHotels() {

		list = helper.getHotels("南京", "仙林中心");

		assertEquals("如家", list.get(0).getHotelName());
		assertEquals("7天", list.get(1).getHotelName());
	}

	@Test
	public void testGetHotelInfo() {
		HotelPO po = helper.getHotelInfo("12345678");
		assertEquals("桔子", po.getHotelName());
	}

	@Test
	public void testUpdateHotelInfo() {
		HotelPO po = new HotelPO();
		po.setHotelID("12345679");
		po.setHotelName("桔子");
		po.setCity("南京");
		po.setCircle("马群");
		helper.updateHotelInfo(po);
		po = helper.getHotelInfo("12345679");
		assertEquals("桔子", po.getHotelName());
	}

	@Ignore //避免重复添加
	@Test
	public void testAddHotelInfo() {
		HotelPO po = new HotelPO();
		po.setHotelID("12345677");
		po.setHotelName("桔子水晶");
		po.setCity("南京");
		po.setCircle("马群");
		helper.addHotelInfo(po);
		po = helper.getHotelInfo("12345677");
		assertEquals("桔子水晶", po.getHotelName());
	}

}
