package businessLogic.orderBL;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import utilities.OrderState;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.GuestEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/12/5
 */
public class Order_tester {
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * 
	 * test cooperation with class Promotion
	 * test interface getDiscout
	 */
	@Test
	public void test1() {
		final OrderController controller = OrderController.getInstance();

		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);
		final RoomType roomType = RoomType.AMBASSADOR;
		
		final OrderGeneralVO createOrderGeneralVO = new OrderGeneralVO("1234567890", "12345678", "thisHotel", 
				"nanjing", expectExecuteTime, expectLeaveTime);
		final OrderVO createOrderVO = new OrderVO(createOrderGeneralVO, 250, roomType, 1, 2, "charles", "15012345678", "no");
		assertEquals(ResultMessage.ORDER_CREATE_SUCCESS, controller.createOrder(createOrderVO));
				
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * test cooperation with class Hotel
	 * test interface addEvaluation
	 */
	@Test
	public void test2() {
		final OrderController controller = OrderController.getInstance();
		assertEquals(ResultMessage.UPDATE_EVALUATION_SUCCESS, controller.addEvaluation(new GuestEvaluationVO("1234567890", 4.5, "good")));
				
	}
}