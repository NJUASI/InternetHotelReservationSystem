package businessLogicService.userBLService;

import java.util.List;

import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.operationFailedException.UpdateFaiedException;
import exception.verificationException.ParameterInvalidException;
import exception.verificationException.UserInexistException;
import utilities.enums.ResultMessage;
import utilities.enums.UserType;
import vo.HotelVO;
import vo.UserVO;

public interface UserBLService {

	public UserVO add(UserVO newUserVO ,UserType userType) throws ParameterInvalidException;

	public ResultMessage modify(UserVO userVO) throws InvalidLengthInputException, InvalidInputException, PasswordInputException, UpdateFaiedException;
	
	public UserVO getSingle(String userID) throws UserInexistException;
	
	public HotelVO addHotel(HotelVO newHotelVO);
	
	public List<UserVO> getAll(UserType userType);
	
	public String getLogInInfo(String userID, UserType userType) throws UserInexistException;
	
}
