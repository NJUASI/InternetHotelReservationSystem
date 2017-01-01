package testSuits.orderUndo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.orderBL.OrderBLController;
import businessLogicService.orderBLService.OrderBLService;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import utilities.enums.ResultMessage;

public class OrderUndo1 {
	
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
		assertEquals(ResultMessage.SUCCESS,orderController.undoNormalOrder("950820160302"));
	}

}
