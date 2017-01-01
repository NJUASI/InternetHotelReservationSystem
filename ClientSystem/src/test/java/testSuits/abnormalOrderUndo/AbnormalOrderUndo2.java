package testSuits.abnormalOrderUndo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.orderBL.OrderBLController;
import businessLogicService.orderBLService.OrderBLService;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import utilities.enums.ResultMessage;

public class AbnormalOrderUndo2 {
	
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
		assertEquals(ResultMessage.SUCCESS, orderController.undoAbnormalOrder("101420161218", 0.5));
	}

}
