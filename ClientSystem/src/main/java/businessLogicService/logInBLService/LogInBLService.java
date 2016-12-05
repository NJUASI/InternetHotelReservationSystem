package businessLogicService.logInBLService;

import utilities.ResultMessage;
import utilities.UserType;
import vo.GuestVO;
import vo.UserVO;

public interface LogInBLService {

	public ResultMessage logIn (String webManager, String password,UserType userType);
	
	public GuestVO guestSignUp (UserVO guestVO);
	
}
