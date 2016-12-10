package businessLogic.userBL.userService.service;

<<<<<<< HEAD
import utilities.enums.ResultMessage;
=======
import exception.verificationException.UserInexistException;
import utilities.ResultMessage;
>>>>>>> master

public interface GuestCreditService {
	
	public ResultMessage modifyCredit(String guestID, double creditNum) throws UserInexistException;
	
}
