package presentation.hotelWorkerUI.driver;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

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
 * updateTime 2016/11/27
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
	public void test1() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.executeOrder("123456789012"));
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface undoAbnormalOrder
	 */
	@Test
	public void test2() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.orderBLService.undoAbnormalOrder("123456789012"));
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * test interface getOrderDetail
	 */
	@Test
	public void test3() {
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
		assertEquals(RoomType.AMBASSADOR, orderVO.roomType);
		assertEquals(2, orderVO.roomNumCount);
		assertEquals("301  302", orderVO.roomNumber);
		assertEquals("zhangsan", orderVO.name);
		assertEquals("13554321234", orderVO.phone);
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
	public void test4() {
		final OrderBLService_Stub stub = new OrderBLService_Stub();
		final OrderBLService_Driver driver = new OrderBLService_Driver(stub);
		
		final List<OrderGeneralVO> orderGeneralVOs = driver.orderBLService.getAllHotelOrderGeneral("1234567890");
		final OrderGeneralVO orderGeneralVO = orderGeneralVOs.get(0);	
		
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
}
