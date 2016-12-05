package businessLogic.orderBL.driver;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import dataService.orderDataService.OrderDataService_Stub;
import po.CheckInPO;
import po.CheckOutPO;
import po.GuestEvaluationPO;
import po.HotelEvaluationPO;
import po.OrderGeneralPO;
import po.OrderPO;
import utilities.OrderState;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/12/5
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
	public void test2() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);

		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);
		final RoomType roomType = RoomType.AMBASSADOR;
		
		final OrderGeneralVO createOrderGeneralVO = new OrderGeneralVO("1234567890", "12345678", "thisHotel", 
				"nanjing", expectExecuteTime, expectLeaveTime);
		final OrderVO createOrderVO = new OrderVO(createOrderGeneralVO, 250, roomType, 1, 2, "charles", "15012345678", "no");
		
		final OrderPO orderPO = new OrderPO(createOrderVO);
		
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
	public void test3() {
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
	public void test4() {
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
	public void test5() {
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
	 * test interface getOrderDetail
	 */
	@Test
	public void test6() {
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
	public void test7() {
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
	public void test8() {
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
	public void test9() {
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
	public void test10() {
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
	 * test interface getAllUnexecutedOrderGeneral
	 */
	@Test
	public void test11() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final List<OrderGeneralPO> orderGeneralPOs;
		try {
			orderGeneralPOs = driver.orderDataService.getAllUnexecutedOrderGeneral(LocalDate.of(2016, 2, 3));
			
			final OrderGeneralPO orderGeneralPO = orderGeneralPOs.get(0);	
			
			assertEquals("123456789012", orderGeneralPO.getOrderID());
			assertEquals("1234567890", orderGeneralPO.getGuestID());
			assertEquals("12345678", orderGeneralPO.getHotelID());
			assertEquals("thisHotel", orderGeneralPO.getHotelName());
			assertEquals("address", orderGeneralPO.getHotelAddress());
			assertEquals(200, orderGeneralPO.getPrice(), 0);
			assertEquals(LocalDateTime.of(2016, 2, 3, 14, 0), orderGeneralPO.getExpectExecuteTime());
			assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralPO.getExpectLeaveTime());
			assertEquals(OrderState.UNEXECUTED, orderGeneralPO.getState());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test interface updateCheckIn
	 */
	@Test
	public void test12() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		ResultMessage message = ResultMessage.CHECK_IN_FAILURE;
		try {
			final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
			final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);
			final CheckInPO checkInPO = new CheckInPO("123456789012", "306", checkInTime, expectLeaveTime); 
			
			message = driver.orderDataService.updateCheckIn(checkInPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(ResultMessage.CHECK_IN_SUCCESS, message);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test interface updateCheckOut
	 */
	@Test
	public void test13() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		ResultMessage message = ResultMessage.CHECK_OUT_FAILURE;
		try {
			final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
			final CheckOutPO checkOutPO = new CheckOutPO("123456789012", checkOutTime); 
			
			message = driver.orderDataService.updateCheckOut(checkOutPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(ResultMessage.CHECK_OUT_SUCCESS, message);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test interface addEvaluation
	 */
	@Test
	public void test14() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		ResultMessage message = ResultMessage.UPDATE_EVALUATION_FAILURE;
		try {
			final GuestEvaluationPO guestEvaluationPO = new GuestEvaluationPO("123456789012", 4.5, "good");
			message = driver.orderDataService.addEvaluation(guestEvaluationPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(ResultMessage.UPDATE_EVALUATION_SUCCESS, message);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test interface getEvaluations
	 */
	@Test
	public void test15() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final List<HotelEvaluationPO> hotelEvaluationPOs;
		try {
			hotelEvaluationPOs = driver.orderDataService.getEvaluations("12345678");
			
			final HotelEvaluationPO hotelEvaluationPO1 = hotelEvaluationPOs.get(0);
			final HotelEvaluationPO hotelEvaluationPO2 = hotelEvaluationPOs.get(1);
			final HotelEvaluationPO hotelEvaluationPO3 = hotelEvaluationPOs.get(2);
			
			assertEquals("1234567890", hotelEvaluationPO1.getGuestID());
			assertEquals(LocalDate.of(2016, 11, 21), hotelEvaluationPO1.getCheckInDate());
			assertEquals(4.5, hotelEvaluationPO1.getScore(), 0);
			assertEquals("very good", hotelEvaluationPO1.getComment());
			
			assertEquals("1234567891", hotelEvaluationPO2.getGuestID());
			assertEquals(LocalDate.of(2016, 11, 21), hotelEvaluationPO2.getCheckInDate());
			assertEquals(4.5, hotelEvaluationPO2.getScore(), 0);
			assertEquals("good", hotelEvaluationPO2.getComment());
			
			assertEquals("1234567891", hotelEvaluationPO3.getGuestID());
			assertEquals(LocalDate.of(2016, 11, 23), hotelEvaluationPO3.getCheckInDate());
			assertEquals(4.3, hotelEvaluationPO3.getScore(), 0);
			assertEquals("ok", hotelEvaluationPO3.getComment());
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
	public void test16() {
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
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test interface getOrderState
	 */
	@Test
	public void test17() {
		final OrderDataService_Stub stub = new OrderDataService_Stub();
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		OrderState orderState = null;
		try {
			orderState = driver.orderDataService.getOrderState("1234567890", "12345678");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(OrderState.COMMENTED, orderState);
	}
}
