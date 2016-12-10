package businessLogicService.userBLService;

import java.util.List;

import utilities.enums.ResultMessage;
import utilities.enums.UserType;
import vo.HotelVO;
import vo.UserVO;

public interface UserBLService {

	public UserVO add(UserVO newUserVO ,UserType userType);

	public ResultMessage modify(UserVO userVO);
	
	public UserVO getSingle(String userID);
	
	public HotelVO addHotel(HotelVO newHotelVO);
	
	public List<UserVO> getAll(UserType userType);
	
	public String getLogInInfo(String userID, UserType userType);
	
}
