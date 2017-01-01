package testSuits.abnormalOrderView;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.orderBL.OrderBLController;
import businessLogicService.orderBLService.OrderBLService;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import vo.OrderVO;

public class AbnormalOrderView2 {
	
	OrderBLService orderController;
	ClientRemoteHelper clientRemoteHelper = ClientRemoteHelper.getInstance();
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper.setIPandPort("localhost", "8889");
		orderController = OrderBLController.getInstance();
		IDReserve.getInstance().setUserID("100001");
	}

	@Test
	public void test() {
		OrderVO orderVO = orderController.getOrderDetail("101420161218");
		assertEquals(orderVO.orderGeneralVO.hotelName,"南京天丰大酒店");
	}

}
