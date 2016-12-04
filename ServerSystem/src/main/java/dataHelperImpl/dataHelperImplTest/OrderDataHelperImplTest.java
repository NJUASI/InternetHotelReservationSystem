package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import dataHelper.OrderDataHelper;
import dataHelperImpl.OrderDataHelperImpl;
import po.OrderPO;
import utilities.OrderState;
import utilities.ResultMessage;
import utilities.RoomType;

public class OrderDataHelperImplTest {

	OrderDataHelper helper =null;
	
	@Before
	public void setUp() throws Exception {
		helper = new OrderDataHelperImpl();
	}

	@Ignore
	@Test
	public void testAdd() {
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 20);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);

		final OrderState orderState = OrderState.EXECUTED;
		final RoomType roomType = RoomType.AMBASSADOR;
		
		OrderPO orderPO = new OrderPO("123456789012", "1234567890", "12345678", "thisHotel", "address", 200, 200,
				createTime, checkInTime, checkOutTime, expectExecuteTime, expectLeaveTime, orderState, 
				roomType, 2, "301  302", 2, "zhangsan","13554321234", "no","good");
		
		assertEquals(ResultMessage.SUCCESS,helper.add(orderPO));
	}

	@Ignore
	@Test
	public void testSetState() {
		assertEquals(ResultMessage.SUCCESS,helper.setState("13342016112", OrderState.ABNORMAL));
	}

	@Ignore
	@Test
	public void testSetComment() {
		assertEquals(ResultMessage.SUCCESS,helper.setEvaluation("13342016112", 3, "notGood"));
	}

	@Ignore
	@Test
	public void testGetSingleOrder() {
		OrderPO orderPO = helper.getSingleOrder("123420161201");
		
		assertEquals("1000000001",orderPO.getGuestID());
		assertEquals("98765432",orderPO.getHotelID());
		assertEquals("学校",orderPO.getHotelName());
	}

	@Ignore
	@Test
	public void testGetAllOrderOfGuest() {
		List<OrderPO> list = helper.getAllOrderOfGuest("1000000001");
		
		assertEquals("1000000001",list.get(0).getGuestID());
		assertEquals("98765432",list.get(0).getHotelID());
		assertEquals("学校",list.get(0).getHotelName());
		assertEquals(LocalDateTime.of(2016, 1, 1, 19, 41,17),list.get(0).getCreateTime());
	}

	@Ignore
	@Test
	public void testGetAllOrderOfHotel() {
		List<OrderPO> list = helper.getAllOrderOfHotel("98765432");
		
		assertEquals("1000000001",list.get(0).getGuestID());
		assertEquals("98765432",list.get(0).getHotelID());
		assertEquals("学校",list.get(0).getHotelName());
		assertEquals(LocalDateTime.of(2016, 1, 1, 19, 41,17),list.get(0).getCreateTime());
	}

	@Test
	public void testGetAbnormal() {
		List<OrderPO> list = helper.getAbnormal();
		
		assertEquals("1000000000",list.get(0).getGuestID());
		assertEquals("12345678",list.get(0).getHotelID());
		assertEquals("center",list.get(0).getHotelName());
		assertEquals(LocalDateTime.of(2016, 9, 1, 2, 34,51),list.get(0).getCreateTime());
	}

	@Ignore
	@Test
	public void testGetUnexecuted() {
		List<OrderPO> list = helper.getUnexecuted();
		
		assertEquals("1000000001",list.get(0).getGuestID());
		assertEquals("98765432",list.get(0).getHotelID());
		assertEquals("学校",list.get(0).getHotelName());
		assertEquals(LocalDateTime.of(2016, 1, 1, 19, 41,17),list.get(0).getCreateTime());
	}
}
