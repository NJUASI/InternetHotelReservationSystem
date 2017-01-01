package presentation.guestUI.driver;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;

import org.junit.Test;

import businessLogic.orderBL.stub.OrderBLService_Stub;
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
 * updateTime 2016/12/4
 * 
 * 添加addEvaluation测试
 */
public class OrderBLService_DriverTest {

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getAllGuestOrderGeneral
	 */
	@Test
	public void test1() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final Iterator<OrderGeneralVO> orderGeneralVOs = driver.orderBLService.
				getAllOrderGenerals("1234567890", UserType.GUEST);
		final OrderGeneralVO orderGeneralVO = orderGeneralVOs.next();	
		
		assertEquals("123456789012", orderGeneralVO.orderID);
		assertEquals("1234567890", orderGeneralVO.guestID);
		assertEquals("12345678", orderGeneralVO.hotelID);
		assertEquals("thisHotel", orderGeneralVO.hotelName);
		assertEquals("address", orderGeneralVO.hotelAddress);
		assertEquals(200, orderGeneralVO.price, 0);
		assertEquals(LocalDateTime.of(2016, 2, 3, 14, 0), orderGeneralVO.expectExecuteTime);
		assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralVO.expectLeaveTime);
		assertEquals(OrderState.EXECUTED, orderGeneralVO.state);
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getOrderDetails
	 */
	@Test
	public void test2() {
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
	 * @updateTime 2016/12/2
	 * 
	 * test interface getHotelEvaluations
	 */
	@Test
	public void test3() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		Iterator<HotelEvaluationVO> evaluations = driver.orderBLService.getEvaluations("12345678");
		
		HotelEvaluationVO hotelEvaluationVO1 = evaluations.next();
		HotelEvaluationVO hotelEvaluationVO2 = evaluations.next();
		HotelEvaluationVO hotelEvaluationVO3 = evaluations.next();
		
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
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * 
	 * test interface createOrder
	 */
	@Test
	public void test4() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);
		final RoomType roomType = RoomType.DOUBLE_BED;
		
		final OrderGeneralVO orderGeneralVO = new OrderGeneralVO("1234567900", "98765444", "thisHotel", 
				"kkk", expectExecuteTime, expectLeaveTime, "charles", "15112345678");
		final OrderVO orderVO = new OrderVO(orderGeneralVO, 500, roomType, 1, 2, "");
		
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
	public void test5() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.undoNormalOrder("123456789012"));
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/2
	 * 
	 * test interface addEvaluation
	 */
	@Test
	public void test6() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.addEvaluation(new GuestEvaluationVO
				("123420161002", 4, "5")));
	}

}
