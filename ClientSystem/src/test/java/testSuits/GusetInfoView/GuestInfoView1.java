package testSuits.GusetInfoView;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import exception.verificationException.UserInexistException;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import vo.GuestVO;

public class GuestInfoView1 {

	UserBLService userController;
	ClientRemoteHelper clientRemoteHelper = ClientRemoteHelper.getInstance();
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper.setIPandPort("localhost", "8889");
		userController = UserController.getInstance();
		IDReserve.getInstance().setUserID("1234567900");
	}

	@Test
	public void test() {
			GuestVO tempGuestVO;
			try {
				tempGuestVO = (GuestVO) userController.getSingle(IDReserve.getInstance().getUserID());
				
				assertEquals("冯俊杰",tempGuestVO.name);
			} catch (UserInexistException e) {
				e.printStackTrace();
			}
			
			
	}
}
