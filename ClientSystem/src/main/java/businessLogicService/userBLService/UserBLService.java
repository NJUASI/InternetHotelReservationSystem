package businessLogicService.userBLService;

import java.util.List;

import utilities.ResultMessage;
import utilities.UserType;
import vo.CreditVO;
import vo.HotelVO;
import vo.UserVO;

public interface UserBLService {

	public ResultMessage add(UserVO newUserVO);

	public ResultMessage modify(UserVO userVO);
	
	public UserVO getSingle(String userID, UserType userType);
	
	public ResultMessage addHotel(HotelVO newHotelVO, String hotelID);
	
	public ResultMessage modifyCredit (String guestID, double creditNum);
		
	public List<UserVO> getAll(UserType userType);
	
	public List<CreditVO> getAllCreditDetail(String guestID);
	
	public String getLogInInfo(String userID, UserType userType);
	
}
