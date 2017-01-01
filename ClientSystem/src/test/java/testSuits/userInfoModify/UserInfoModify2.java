package testSuits.userInfoModify;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import utilities.enums.ResultMessage;
import vo.HotelWorkerVO;

public class UserInfoModify2 {

	UserBLService userController;
	ClientRemoteHelper clientRemoteHelper = ClientRemoteHelper.getInstance();
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper.setIPandPort("localhost", "8889");
		userController = UserController.getInstance();
		IDReserve.getInstance().setUserID("1010");
	}

	@Test
	public void test() {
		try {
			HotelWorkerVO tempGuestVO = (HotelWorkerVO) userController.getSingle("98765441");
			
			tempGuestVO.password = "123456";
			
			assertEquals(ResultMessage.SUCCESS, userController.modify(tempGuestVO));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
