package businessLogicService.userBLService;

import java.util.List;

<<<<<<< HEAD
import utilities.enums.ResultMessage;
import utilities.enums.UserType;
=======
import exception.verificationException.ParameterInvalidException;
import exception.verificationException.UserInexistException;
import utilities.ResultMessage;
import utilities.UserType;
>>>>>>> master
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
