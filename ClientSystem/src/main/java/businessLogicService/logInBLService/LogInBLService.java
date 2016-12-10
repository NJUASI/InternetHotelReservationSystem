package businessLogicService.logInBLService;

import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.inputException.SpecialCharacterException;
import exception.verificationException.WrongPasswordException;
import utilities.enums.UserType;
import vo.GuestVO;
import vo.UserVO;

public interface LogInBLService {

	public UserType logIn (String userID, String password)throws WrongPasswordException, SpecialCharacterException, InvalidLengthInputException;
	
	public GuestVO guestSignUp (UserVO guestVO) throws InvalidInputException, PasswordInputException, InvalidLengthInputException;
	
}
