package testSuits.orderView;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.orderBL.OrderBLController;
import businessLogicService.orderBLService.*;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import utilities.enums.UserType;
import vo.OrderGeneralVO;
import vo.OrderVO;

public class OrderView1 {

	OrderBLService orderController;
	ClientRemoteHelper clientRemoteHelper = ClientRemoteHelper.getInstance();
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper.setIPandPort("localhost", "8889");
		orderController = OrderBLController.getInstance();
		IDReserve.getInstance().setUserID("1234567900");
	}
	
	@Test
	public void test1() {
		OrderVO orderVO = orderController.getOrderDetail("101420161218");
		assertEquals(orderVO.orderGeneralVO.hotelName,"南京天丰大酒店");
	}
	
	@Test
	public void test2() {
		OrderGeneralVO orderVO = orderController.getAllOrderGenerals(IDReserve.getInstance().getUserID(), UserType.GUEST).next();
		assertEquals(orderVO.hotelName,"南京天丰大酒店");
	}

}
