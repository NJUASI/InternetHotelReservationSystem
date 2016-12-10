package businessLogicService.userBLService;

import java.util.List;

import exception.verificationException.ParameterInvalidException;
import exception.verificationException.UserInexistException;
import utilities.ResultMessage;
import utilities.UserType;
import vo.HotelVO;
import vo.UserVO;

public interface UserBLService {

	public UserVO add(UserVO newUserVO ,UserType userType) throws ParameterInvalidException;

	public ResultMessage modify(UserVO userVO);
	
	public UserVO getSingle(String userID) throws UserInexistException;
	
	public HotelVO addHotel(HotelVO newHotelVO);
	
	public List<UserVO> getAll(UserType userType);
	
	public String getLogInInfo(String userID, UserType userType) throws UserInexistException;
	
}
