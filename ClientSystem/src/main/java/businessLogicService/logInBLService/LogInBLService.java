package businessLogicService.logInBLService;

import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.inputException.SpecialCharacterException;
import exception.verificationException.UserInexistException;
import exception.verificationException.WrongPasswordException;
import utilities.UserType;
import vo.GuestVO;
import vo.UserVO;

public interface LogInBLService {

	public UserType logIn (String userID, String password)throws WrongPasswordException, SpecialCharacterException, InvalidLengthInputException, UserInexistException;
	
	public GuestVO guestSignUp (UserVO guestVO) throws InvalidInputException, PasswordInputException, InvalidLengthInputException;
	
}
