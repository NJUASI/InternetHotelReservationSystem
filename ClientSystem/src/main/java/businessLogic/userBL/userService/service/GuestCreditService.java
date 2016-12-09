package businessLogic.userBL.userService.service;

import utilities.ResultMessage;

public interface GuestCreditService {
	
	public ResultMessage modifyCredit(String guestID, double creditNum);
	
}
