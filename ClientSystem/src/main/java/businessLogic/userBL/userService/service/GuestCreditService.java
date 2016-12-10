package businessLogic.userBL.userService.service;

import utilities.enums.ResultMessage;

public interface GuestCreditService {
	
	public ResultMessage modifyCredit(String guestID, double creditNum);
	
}
