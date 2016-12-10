package presentation.hotelWorkerUI.driver;

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
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.HotelEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/12/5
 *
 */
public class OrderBLService_DriverTest {

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface executeOrder
	 */
	@Test
	public void testExecuteOrder() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.executeOrder("123456789012"));
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getOrderDetail
	 */
	@Test
	public void testGetOrderDetail() {
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
	 * test interface getAllHotelOrderGeneral
	 */
	@Test
	public void testGetAllHotelOrderGeneral() {
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
	 * @updateTime 2016/12/5
	 * 
	 * test interface updateCheckIn
	 */
	@Test
	public void testUpdateCheckIn() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);
		
		final CheckInVO checkInVO = new CheckInVO("123456789012", "305", checkInTime, expectLeaveTime);
		
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.updateCheckIn(checkInVO));
		
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
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);

		final CheckOutVO checkOutVO = new CheckOutVO("123456789012", checkOutTime);
		
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.updateCheckOut(checkOutVO));
		
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
