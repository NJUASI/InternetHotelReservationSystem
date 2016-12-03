package businessLogicService.logInBLService;

import utilities.ResultMessage;
import vo.GuestVO;

public interface LogInBLService {

	public ResultMessage guestLogIn (String guest, String password);
	
	public ResultMessage hotelWorkerLogIn (String hotelWorker, String password);
	
	public ResultMessage webMarketerLogIn (String webMarketer, String password);
	
	public ResultMessage webManagerLogIn (String webManager, String password);
	
	public ResultMessage guestSignUp (GuestVO guestVO);
	
}
