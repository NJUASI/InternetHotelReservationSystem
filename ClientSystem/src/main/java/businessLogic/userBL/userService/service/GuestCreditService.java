package businessLogic.userBL.userService.service;

import exception.verificationException.UserInexistException;
import utilities.ResultMessage;

public interface GuestCreditService {
	
	public ResultMessage modifyCredit(String guestID, double creditNum) throws UserInexistException;
	
}
