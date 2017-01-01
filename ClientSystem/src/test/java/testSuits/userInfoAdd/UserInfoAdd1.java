package testSuits.userInfoAdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import utilities.enums.UserType;
import vo.WebMarketerVO;

public class UserInfoAdd1 {

	UserBLService userController;
	ClientRemoteHelper clientRemoteHelper = ClientRemoteHelper.getInstance();
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper.setIPandPort("localhost", "8889");
		userController = UserController.getInstance();
		IDReserve.getInstance().setUserID("1010");
	}

	@Test
	public void test1() {
		try {
			WebMarketerVO tempVO = new WebMarketerVO("","");
			
			tempVO = (WebMarketerVO) userController.add(tempVO, UserType.WEB_MARKETER);
			
			assertEquals("100010", tempVO.userID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
