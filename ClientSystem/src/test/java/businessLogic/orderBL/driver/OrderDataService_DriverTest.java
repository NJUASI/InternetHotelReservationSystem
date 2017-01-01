package businessLogic.orderBL.driver;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import dataService.orderDataService.OrderDataService_Stub;
import po.OrderGeneralPO;
import po.OrderPO;
import utilities.OrderState;
import utilities.ResultMessage;
import utilities.RoomType;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/11/27
 *
 */
public class OrderDataService_DriverTest {

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface createOrder
	 */
	@Test
	public void test1() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 20);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);

		final OrderState orderState = OrderState.EXECUTED;
		final RoomType roomType = RoomType.AMBASSADOR;
		
		
		final OrderPO orderPO = new OrderPO("123456789012", "1234567890", "12345678", "thisHotel", "address", 200, 200,
				createTime, checkInTime, checkOutTime, expectExecuteTime, expectLeaveTime, orderState, 
				roomType, 2, "301", 2, "zhangsan", "13554321234", "no","good");
		
		try {
			assertEquals(ResultMessage.SUCCESS, driver.orderDataService.createOrder(orderPO));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface executeOrder
	 */
	@Test
	public void test2() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		try {
			assertEquals(ResultMessage.SUCCESS, driver.orderDataService.executeOrder("123456789012"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface undoAbnormalOrder
	 */
	@Test
	public void test3() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		try {
			assertEquals(ResultMessage.SUCCESS, driver.orderDataService.undoAbnormalOrder("123456789012"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface undoNormalOrder
	 */
	@Test
	public void test4() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		try {
			assertEquals(ResultMessage.SUCCESS, driver.orderDataService.undoNormalOrder("123456789012"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getOrderDetails
	 */
	@Test
	public void test5() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		final OrderPO orderPO;
		try {
			orderPO = driver.orderDataService.getOrderDetail("123456789012");
			final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 20);
			final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
			final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
			final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
			final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);
		
			assertEquals("123456789012", orderPO.getOrderID());
			assertEquals("thisHotel", orderPO.getHotelName());
			assertEquals("address", orderPO.getHotelAddress());
			assertEquals(200, orderPO.getPreviousPrice(), 0);
			assertEquals(200, orderPO.getPrice(), 0);
			assertEquals(createTime, orderPO.getCreateTime());
			assertEquals(checkInTime, orderPO.getCheckInTime());
			assertEquals(checkOutTime, orderPO.getCheckOutTime());
			assertEquals(expectExecuteTime, orderPO.getExpectExecuteTime());
			assertEquals(expectLeaveTime, orderPO.getExpectLeaveTime());
			assertEquals(OrderState.EXECUTED, orderPO.getState());
			assertEquals(RoomType.AMBASSADOR, orderPO.getRoomType());
			assertEquals(2, orderPO.getRoomNumCount());
			assertEquals("301  302", orderPO.getRoomNumber());
			assertEquals("zhangsan", orderPO.getName());
			assertEquals("13554321234", orderPO.getPhone());
			assertEquals("no", orderPO.getMessage());
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getAllGuestOrderGeneral
	 */
	@Test
	public void test6() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final List<OrderGeneralPO> orderGeneralPOs;
		try {
			orderGeneralPOs = driver.orderDataService.getAllGuestOrderGeneral("1234567890");
			final OrderGeneralPO orderGeneralPO = orderGeneralPOs.get(0);	
			
			assertEquals("123456789012", orderGeneralPO.getOrderID());
			assertEquals("1234567890", orderGeneralPO.getGuestID());
			assertEquals("12345678", orderGeneralPO.getHotelID());
			assertEquals("thisHotel", orderGeneralPO.getHotelName());
			assertEquals("address", orderGeneralPO.getHotelAddress());
			assertEquals(200, orderGeneralPO.getPrice(), 0);
			assertEquals(LocalDateTime.of(2016, 2, 3, 14, 0), orderGeneralPO.getExpectExecuteTime());
			assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralPO.getExpectLeaveTime());
			assertEquals(OrderState.EXECUTED, orderGeneralPO.getState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getAllHotelOrderGeneral
	 */
	@Test
	public void test7() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final List<OrderGeneralPO> orderGeneralPOs;
		try {
			orderGeneralPOs = driver.orderDataService.getAllHotelOrderGeneral("12345678");
			final OrderGeneralPO orderGeneralPO = orderGeneralPOs.get(0);	
			
			assertEquals("123456789012", orderGeneralPO.getOrderID());
			assertEquals("1234567890", orderGeneralPO.getGuestID());
			assertEquals("12345678", orderGeneralPO.getHotelID());
			assertEquals("thisHotel", orderGeneralPO.getHotelName());
			assertEquals("address", orderGeneralPO.getHotelAddress());
			assertEquals(200, orderGeneralPO.getPrice(), 0);
			assertEquals(LocalDateTime.of(2016, 2, 3, 14, 0), orderGeneralPO.getExpectExecuteTime());
			assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralPO.getExpectLeaveTime());
			assertEquals(OrderState.EXECUTED, orderGeneralPO.getState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getAllAbnormalOrderGeneral(LocalDate date)
	 */
	@Test
	public void test8() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final List<OrderGeneralPO> orderGeneralPOs;
		try {
			orderGeneralPOs = driver.orderDataService.getAllAbnormalOrderGeneral(LocalDate.of(2016, 2, 3));
			final OrderGeneralPO orderGeneralPO = orderGeneralPOs.get(0);	
			
			assertEquals("123456789012", orderGeneralPO.getOrderID());
			assertEquals("1234567890", orderGeneralPO.getGuestID());
			assertEquals("12345678", orderGeneralPO.getHotelID());
			assertEquals("thisHotel", orderGeneralPO.getHotelName());
			assertEquals("address", orderGeneralPO.getHotelAddress());
			assertEquals(200, orderGeneralPO.getPrice(), 0);
			assertEquals(LocalDateTime.of(2016, 2, 3, 14, 0), orderGeneralPO.getExpectExecuteTime());
			assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralPO.getExpectLeaveTime());
			assertEquals(OrderState.EXECUTED, orderGeneralPO.getState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getAllAbnormalOrderGeneral()
	 */
	@Test
	public void test9() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final List<OrderGeneralPO> orderGeneralPOs;
		try {
			orderGeneralPOs = driver.orderDataService.getAllAbnormalOrderGeneral();
			final OrderGeneralPO orderGeneralPO = orderGeneralPOs.get(0);	
			
			assertEquals("123456789012", orderGeneralPO.getOrderID());
			assertEquals("1234567890", orderGeneralPO.getGuestID());
			assertEquals("12345678", orderGeneralPO.getHotelID());
			assertEquals("thisHotel", orderGeneralPO.getHotelName());
			assertEquals("address", orderGeneralPO.getHotelAddress());
			assertEquals(200, orderGeneralPO.getPrice(), 0);
			assertEquals(LocalDateTime.of(2016, 2, 3, 14, 0), orderGeneralPO.getExpectExecuteTime());
			assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralPO.getExpectLeaveTime());
			assertEquals(OrderState.EXECUTED, orderGeneralPO.getState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getBookedHotels
	 */
	@Test
	public void test10() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final List<String> bookedHotels;
		try {
			bookedHotels = driver.orderDataService.getBookedHotels("1234567890");
			
			assertEquals("12345678", bookedHotels.get(0));
			assertEquals("12345679", bookedHotels.get(1));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
