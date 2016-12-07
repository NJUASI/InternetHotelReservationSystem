package presentation.webMarketerUI.driver;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import businessLogic.orderBL.stub.OrderBLService_Stub;
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
public class OrderBLService_DriverTest {
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface undoAbnormalOrder
	 */
	@Test
	public void testUndoAbnormalOrder() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		assertEquals(ResultMessage.ABNORMAL_ORDER_UNDO_SUCCESS, driver.orderBLService.undoAbnormalOrder("123456789012"));
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
		assertEquals(RoomType.商务套房, orderVO.roomType);
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
	 * test interface getAllAbnormalOrderGeneral(LocalDate date)
	 */
	@Test
	public void testGetAllAbnormalOrderGeneral01() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final List<OrderGeneralVO> orderGeneralVOs = driver.orderBLService.getAllAbnormalOrderGeneral(LocalDate.of(2016, 2, 3));
		final OrderGeneralVO orderGeneralVO = orderGeneralVOs.get(0);	
		
		assertEquals("123456789012", orderGeneralVO.orderID);
		assertEquals("1234567890", orderGeneralVO.guestID);
		assertEquals("12345678", orderGeneralVO.hotelID);
		assertEquals("thisHotel", orderGeneralVO.hotelName);
		assertEquals("address", orderGeneralVO.hotelAddress);
		assertEquals(200, orderGeneralVO.price, 0);
		assertEquals(LocalDateTime.of(2016, 2, 3, 14, 0), orderGeneralVO.expectExecuteTime);
		assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralVO.expectLeaveTime);
		assertEquals(OrderState.ABNORMAL, orderGeneralVO.state);
		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getAllAbnormalOrderGeneral()
	 */
	@Test
	public void testGetAllAbnormalOrderGeneral02() {
//		final OrderBLService_Stub stub = new OrderBLService_Stub();
//		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
//		
//		final List<OrderGeneralVO> orderGeneralVOs = driver.orderBLService.getAllAbnormalOrderGeneral();
//		final OrderGeneralVO orderGeneralVO = orderGeneralVOs.get(0);	
//		
//		assertEquals("123456789012", orderGeneralVO.orderID);
//		assertEquals("1234567890", orderGeneralVO.guestID);
//		assertEquals("12345678", orderGeneralVO.hotelID);
//		assertEquals("thisHotel", orderGeneralVO.hotelName);
//		assertEquals("address", orderGeneralVO.hotelAddress);
//		assertEquals(200, orderGeneralVO.price, 0);
//		assertEquals(LocalDateTime.of(2016, 2, 3, 14, 0), orderGeneralVO.expectExecuteTime);
//		assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralVO.expectLeaveTime);
//		assertEquals(OrderState.ABNORMAL, orderGeneralVO.state);
//		
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/29
	 * 
	 * test interface getAllUnexecutedOrderGeneral
	 */
	@Test
	public void testGetAllUnexecutedOrderGeneral() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final List<OrderGeneralVO> orderGeneralVOs = driver.orderBLService.getAllUnexecutedOrderGeneral(LocalDate.of(2016, 2, 3));
		final OrderGeneralVO orderGeneralVO = orderGeneralVOs.get(0);	
		
		assertEquals("123456789012", orderGeneralVO.orderID);
		assertEquals("1234567890", orderGeneralVO.guestID);
		assertEquals("12345678", orderGeneralVO.hotelID);
		assertEquals("thisHotel", orderGeneralVO.hotelName);
		assertEquals("address", orderGeneralVO.hotelAddress);
		assertEquals(200, orderGeneralVO.price, 0);
		assertEquals(LocalDateTime.of(2016, 2, 3, 14, 0), orderGeneralVO.expectExecuteTime);
		assertEquals(LocalDateTime.of(2016, 2, 4, 12, 0), orderGeneralVO.expectLeaveTime);
		assertEquals(OrderState.UNEXECUTED, orderGeneralVO.state);
		
	}
}
