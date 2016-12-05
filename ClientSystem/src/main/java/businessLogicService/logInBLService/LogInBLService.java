package businessLogicService.logInBLService;

import utilities.ResultMessage;
import utilities.UserType;
import vo.GuestVO;

public interface LogInBLService {

	public ResultMessage logIn (String webManager, String password,UserType userType);
	
	public ResultMessage guestSignUp (GuestVO guestVO);
	
}
