package businessLogicService.logInBLService;

import utilities.UserType;
import vo.GuestVO;
import vo.UserVO;

public interface LogInBLService {

	public UserType logIn (String userID, String password);
	
	public GuestVO guestSignUp (UserVO guestVO);
	
}
