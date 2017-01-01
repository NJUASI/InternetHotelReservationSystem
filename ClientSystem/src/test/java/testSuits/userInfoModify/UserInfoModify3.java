package testSuits.userInfoModify;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import utilities.enums.ResultMessage;
import vo.WebMarketerVO;

public class UserInfoModify3 {

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
			WebMarketerVO tempVO =  (WebMarketerVO) userController.getSingle("100001");
			
			tempVO.password = "123456";
			
			assertEquals(ResultMessage.SUCCESS, userController.modify(tempVO));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
