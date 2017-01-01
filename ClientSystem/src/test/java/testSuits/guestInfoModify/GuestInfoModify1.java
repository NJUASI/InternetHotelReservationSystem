package testSuits.guestInfoModify;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.operationFailedException.UpdateFaiedException;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import utilities.enums.ResultMessage;
import vo.GuestVO;

public class GuestInfoModify1 {

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
		try {
			GuestVO tempGuestVO = (GuestVO) userController.getSingle(IDReserve.getInstance().getUserID());
			
			tempGuestVO.nickName = "冯二狗";
			
			assertEquals(ResultMessage.SUCCESS,userController.modify(tempGuestVO));
			
		} catch (InvalidLengthInputException e) {
			e.printStackTrace();
		} catch (InvalidInputException e) {
			e.printStackTrace();
		} catch (PasswordInputException e) {
			e.printStackTrace();
		} catch (UpdateFaiedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
