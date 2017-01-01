package testSuits.hotelOrderView;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import businessLogic.orderBL.OrderBLController;
import businessLogicService.orderBLService.OrderBLService;
import rmi.ClientRemoteHelper;
import utilities.enums.OrderState;
import utilities.enums.UserType;
import vo.OrderGeneralVO;

public class HotelOrderViewSuite {

	OrderBLService orderController;
	ClientRemoteHelper clientRemoteHelper;
	Iterator<OrderGeneralVO> itr;
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper = ClientRemoteHelper.getInstance();
		clientRemoteHelper.setIPandPort("localhost", "8889");
		orderController = OrderBLController.getInstance();
	}

	@Test
	//选择查看已执行订单
	public void test1() {
		itr = orderController.getSpecialOrderGenerals("98765441", UserType.HOTEL_WORKER, OrderState.EXECUTED);
		OrderGeneralVO vo = itr.next();
		assertEquals("15205153110",vo.phone);
	}

}
