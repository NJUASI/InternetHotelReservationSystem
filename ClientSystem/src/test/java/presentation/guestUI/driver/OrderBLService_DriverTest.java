package presentation.guestUI.driver;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;

import org.junit.Test;

import businessLogic.orderBL.OrderBLController;
import businessLogic.orderBL.stub.OrderBLService_Stub;
import businessLogicService.orderBLService.OrderBLService;
import utilities.enums.OrderState;
import utilities.enums.ResultMessage;
import utilities.enums.RoomType;
import utilities.enums.UserType;
import vo.GuestEvaluationVO;
import vo.HotelEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/12/5
 * 
 * 添加addEvaluation测试
 * 添加getTempPrice, getEvaluations测试
 */
public class OrderBLService_DriverTest {

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test interface getTempPrice
	 */
	@Test
	public void testGetTempPrice() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 30);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);
		
		final OrderState orderState = OrderState.EXECUTED;
		final RoomType roomType = RoomType.SINGLE_BED;
		
		final OrderVO orderVO = new OrderVO("123456789012", "1234567890", "12345678", "thisHotel", "address", 200, 200,
				createTime, checkInTime, checkOutTime, expectExecuteTime, expectLeaveTime, orderState, false, 
				roomType, 2, "301  302", 2, "zhangsan","13554321234", "no", 4.3, "good");
		
		assertEquals(200, driver.orderBLService.getTempPrice(orderVO), 0);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * 
	 * test interface createOrder
	 */
	@Test
	public void testCreateOrder() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 30);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);
		
		final OrderState orderState = OrderState.EXECUTED;
		final RoomType roomType = RoomType.SINGLE_BED;
		
		final OrderVO orderVO = new OrderVO("123456789012", "1234567890", "12345678", "thisHotel", "address", 200, 200,
				createTime, checkInTime, checkOutTime, expectExecuteTime, expectLeaveTime, orderState, false, 
				roomType, 2, "301  302", 2, "zhangsan","13554321234", "no", 4.3, "good");
		
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.createOrder(orderVO));
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
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.undoNormalOrder("123456789012"));
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
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		final OrderVO orderVO = driver.orderBLService.getOrderDetail("123456789012");
		
		assertEquals("123456789012", orderVO.orderGeneralVO.orderID);
		assertEquals("thisHotel", orderVO.orderGeneralVO.hotelName);
		assertEquals("address", orderVO.orderGeneralVO.hotelAddress);
		assertEquals(200, orderVO.orderGeneralVO.price, 0);
		assertEquals(LocalDateTime.of(2016, 2, 2, 18, 30), orderVO.createTime);
		assertEquals(LocalDateTime.of(2016, 2, 3, 11, 23), orderVO.checkInTime);
		assertEquals(LocalDateTime.of(2016, 2, 4, 10, 58), orderVO.checkOutTime);
		assertEquals(LocalDateTime.of(2016, 2, 3, 14, 00), orderVO.orderGeneralVO.expectExecuteTime);
		assertEquals(LocalDateTime.of(2016, 2, 4, 12, 00), orderVO.orderGeneralVO.expectLeaveTime);
		assertEquals(OrderState.EXECUTED, orderVO.orderGeneralVO.state);
		assertEquals(RoomType.BUSINESS_SUITE, orderVO.roomType);
		assertEquals(2, orderVO.roomNumCount);
		assertEquals("301  302", orderVO.roomNumber);
		assertEquals("zhangsan", orderVO.orderGeneralVO.name);
		assertEquals("13554321234", orderVO.orderGeneralVO.phone);
		assertEquals("no", orderVO.message);
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
		final OrderBLService stub = OrderBLController.getInstance();
		final Iterator<OrderGeneralVO> orderGeneralVOs = stub.getAllOrderGenerals("1234567890", UserType.GUEST);
		
		final OrderGeneralVO orderGeneralVO = orderGeneralVOs.next();
		
		assertEquals("123456789012", orderGeneralVO.orderID);
		assertEquals("1234567890", orderGeneralVO.guestID);
		assertEquals("12345678", orderGeneralVO.hotelID);
		assertEquals("thisHotel1", orderGeneralVO.hotelName);
		assertEquals("address", orderGeneralVO.hotelAddress);
		assertEquals(200, orderGeneralVO.price, 0);
		assertEquals(LocalDateTime.of(2016, 2, 1, 14, 0), orderGeneralVO.expectExecuteTime);
		assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralVO.expectLeaveTime);
		assertEquals(OrderState.EXECUTED, orderGeneralVO.state);
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/2
	 * 
	 * test interface addEvaluation
	 */
	@Test
	public void testAddEvaluation() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.addEvaluation(new GuestEvaluationVO
				("123420161002", 4, "5")));
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
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final Iterator<HotelEvaluationVO> hotelEvaluationVOs = driver.orderBLService.getEvaluations("12345678");
		final HotelEvaluationVO hotelEvaluationVO1 = hotelEvaluationVOs.next();
		final HotelEvaluationVO hotelEvaluationVO2 = hotelEvaluationVOs.next();
		final HotelEvaluationVO hotelEvaluationVO3 = hotelEvaluationVOs.next();
				
		assertEquals("1234567890", hotelEvaluationVO1.guestID);
		assertEquals(LocalDate.of(2016, 2, 3), hotelEvaluationVO1.checkInDate);
		assertEquals(4.5, hotelEvaluationVO1.score, 0);
		assertEquals("very good", hotelEvaluationVO1.comment);
		
		assertEquals("1234567891", hotelEvaluationVO2.guestID);
		assertEquals(LocalDate.of(2016, 4, 17), hotelEvaluationVO2.checkInDate);
		assertEquals(4.5, hotelEvaluationVO2.score, 0);
		assertEquals("good", hotelEvaluationVO2.comment);
		
		assertEquals("1234567891", hotelEvaluationVO3.guestID);
		assertEquals(LocalDate.of(2016, 11, 23), hotelEvaluationVO3.checkInDate);
		assertEquals(4.3, hotelEvaluationVO3.score, 0);
		assertEquals("ok", hotelEvaluationVO3.comment);
	}
}
