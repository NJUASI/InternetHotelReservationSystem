package businessLogic.userBL.userService.service;

import utilities.ResultMessage;

public interface CreditService {
	
	public ResultMessage modifyCredit (String guestID, double creditNum);
	
}
