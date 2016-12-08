package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataHelper.RoomDataHelper;
import dataHelperImpl.RoomDataHelperImpl;
import po.RoomInfoPO;

public class RoomDataHelperImplTest {

	List<RoomInfoPO> list;
	RoomDataHelper helper;


	@Before
	public void setUp() throws Exception {
		helper = new RoomDataHelperImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRoomInfo() {
		list = helper.getRoomInfo("12345678");
		
		assertEquals("高级双床房",list.get(0).getRoomType());
		assertEquals("单人间",list.get(1).getRoomType());
	}

}
