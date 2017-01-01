package testSuits.abnormalOrderView;

import static org.junit.Assert.*;

import java.util.List;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import businessLogic.orderBL.OrderBLController;
import businessLogicService.orderBLService.OrderBLService;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import vo.OrderGeneralVO;

public class AbnormalOrderView1 {

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
	
		List<OrderGeneralVO> list = orderController.getAllAbnormalOrderGeneral(LocalDate.of(2016,12 , 17));
		OrderGeneralVO orderGeneralVO = list.get(0);
		
		assertEquals("101420161218",orderGeneralVO.orderID);
	}

}
