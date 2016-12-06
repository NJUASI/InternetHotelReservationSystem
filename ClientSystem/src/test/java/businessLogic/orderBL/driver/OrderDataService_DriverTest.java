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
import vo.GuestEvaluationVO;
import vo.HotelEvaluationVO;

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
	public void testCreateOrder() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 20);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);

		final OrderState orderState = OrderState.EXECUTED;
		final RoomType roomType = RoomType.商务套房;
		

		final OrderGeneralPO createOrderGeneralVO = new OrderGeneralPO("123456789012", "1234567890", 
				"12345678", "thisHotel", "nanjing", 200, expectExecuteTime, expectLeaveTime, orderState, 
				false, "zhangsan", "15012345678");
		final OrderPO createOrderVO = new OrderPO(createOrderGeneralVO, 250, createTime, checkInTime, checkOutTime, 
				roomType, 1, "305", 2, "no", 4.5, "good");
		
		try {
			assertEquals(ResultMessage.ORDER_CREATE_SUCCESS, driver.orderDataService.createOrder(createOrderVO));
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
	public void testExecuteOrder() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		try {
			assertEquals(ResultMessage.ORDER_EXECUTE_SUCCESS, driver.orderDataService.executeOrder("123456789012"));
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
	public void testUndoAbnormalOrder() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		try {
			assertEquals(ResultMessage.ABNORMAL_ORDER_UNDO_SUCCESS, driver.orderDataService.undoAbnormalOrder("123456789012"));
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
	public void testUndoNormalOrder() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		try {
			assertEquals(ResultMessage.NORMAL_ORDER_UNDO_SUCCESS, driver.orderDataService.undoNormalOrder("123456789012"));
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
	public void testGetOrderDetails() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
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
			assertEquals(RoomType.商务套房, orderPO.getRoomType());
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
	public void testGetAllGuestOrderGeneral() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
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
	public void testGetAllHotelOrderGeneral() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
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
	public void testGetAllAbnormalOrderGeneral01() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
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
			assertEquals(OrderState.ABNORMAL, orderGeneralPO.getState());
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
	public void testGetsAllAbnormalOrderGeneral02() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
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
			assertEquals(OrderState.ABNORMAL, orderGeneralPO.getState());
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
	public void testUpdateCheckIn() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);
		final CheckInPO checkInPO = new CheckInPO("123456789012", "305", checkInTime, expectLeaveTime);		

		ResultMessage result = ResultMessage.CHECK_IN_FAILURE;
		try {
			result = driver.orderDataService.updateCheckIn(checkInPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(ResultMessage.CHECK_IN_SUCCESS, result);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test interface updateCheckOut
	 */
	@Test
	public void testUpdateCheckOut() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final CheckOutPO checkOutPO = new CheckOutPO("123456789012", checkOutTime);
		
		ResultMessage result = ResultMessage.CHECK_OUT_FAILURE;
		try {
			result = driver.orderDataService.updateCheckOut(checkOutPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(ResultMessage.CHECK_OUT_SUCCESS, result);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test interface addEvaluation
	 */
	@Test
	public void testAddEvaluation() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		ResultMessage result = ResultMessage.UPDATE_EVALUATION_FAILURE;
		try {
			result = driver.orderDataService.addEvaluation(new GuestEvaluationPO("123420161002", 4, "5"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(ResultMessage.UPDATE_EVALUATION_SUCCESS, result);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test interface getEvaluations
	 */
	@Test
	public void testGetEvaluations() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		final OrderDataService_Driver driver = new OrderDataService_Driver(stub);
		
		List<HotelEvaluationPO> hotelEvaluationPOs = null;
		try {
			hotelEvaluationPOs = driver.orderDataService.getEvaluations("12345678");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
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
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getBookedHotels
	 */
	@Test
	public void testGetBookedHotels() {
		OrderDataService_Stub stub = null;
		try {
			stub = new OrderDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
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
