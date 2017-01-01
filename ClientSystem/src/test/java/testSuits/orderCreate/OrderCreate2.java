package testSuits.orderCreate;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import businessLogic.orderBL.OrderBLController;
import businessLogicService.orderBLService.OrderBLService;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import utilities.enums.OrderState;
import utilities.enums.ResultMessage;
import utilities.enums.RoomType;
import vo.OrderVO;

public class OrderCreate2 {
	
	OrderBLService orderController;
	ClientRemoteHelper clientRemoteHelper = ClientRemoteHelper.getInstance();
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper.setIPandPort("localhost", "8889");
		orderController = OrderBLController.getInstance();
		IDReserve.getInstance().setUserID("1234567900");
	}

	@Test
	public void test() {
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 20);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);

		final OrderState orderState = OrderState.UNEXECUTED;
		final RoomType roomType = RoomType.DOUBLE_BED;
		
		OrderVO orderVO = new OrderVO("950820160302", "1234567900", "98765442", "南京天丰大酒店", "洪武路26号", 200, 200,
				createTime, checkInTime, checkOutTime, expectExecuteTime, expectLeaveTime, orderState, 
				false, false, roomType, 2, "301  302", 3, "王老五","135123412341", "no thanks", 
				4.3, "");
		
		assertEquals(ResultMessage.FAIL, orderController.createOrder(orderVO)	);
	}

}
