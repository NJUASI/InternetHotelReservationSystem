package businessLogicService.userBLService;

import java.util.List;

import utilities.ResultMessage;
import utilities.UserType;
import vo.HotelVO;
import vo.UserVO;

public interface UserBLService {

	public UserVO add(UserVO newUserVO ,UserType userType);

	public ResultMessage modify(UserVO userVO);
	
	public UserVO getSingle(String userID);
	
	public ResultMessage addHotel(HotelVO newHotelVO, String hotelID);
	
	public List<UserVO> getAll(UserType userType);
	
	public String getLogInInfo(String userID, UserType userType);
	
}
