package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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

	@Ignore  //该方法测试已过，为避免重复修改，故ignore
	@Test
	public void testUpdateRoomInfo() {
		
		RoomInfoPO po = new RoomInfoPO();
		po.setHotelID("12345678");
		po.setRoomType("高级双床房");
		
		helper.updateRoomInfo(po, "高级大床房");
	
		list = helper.getRoomInfo("12345678");
		assertEquals("高级双床房",list.get(0).getRoomType());
		
	}

	@Ignore //该方法测试已过，为避免重复添加，故ignore
	@Test
	public void testAddRoomInfo() {

		RoomInfoPO po = new RoomInfoPO();
		po.setHotelID("12345678");
		po.setRoomType("高级大床房");
		
		helper.addRoomInfo(po);
		
		list = helper.getRoomInfo("12345678");
		assertEquals("高级大床房",list.get(2).getRoomType());
	}

	@Ignore //该方法测试已过，为避免重复删除，故ignore
	@Test
	public void testDeleteRoomInfo() {
		
		list = helper.getRoomInfo("12345678");
		assertEquals(3, list.size());
		helper.deleteRoomInfo("12345678", "高级大床房");
		list = helper.getRoomInfo("12345678");
		assertEquals(2, list.size());
				
	}

}
