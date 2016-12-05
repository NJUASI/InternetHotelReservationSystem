package businessLogicService.userBLService;

import java.util.List;

import utilities.ResultMessage;
import utilities.UserType;
import vo.HotelVO;
import vo.UserVO;

public interface UserBLService {

	public ResultMessage add(UserVO newUserVO);

	public ResultMessage modify(UserVO userVO);
	
	public UserVO getSingle(String userID,UserType userType);
	
	public ResultMessage addHotel(HotelVO newHotelVO, String hotelID);
	
	public List<UserVO> getAll(UserType userType);
	
	public String getPassword(String userID,UserType userType);
	
}
