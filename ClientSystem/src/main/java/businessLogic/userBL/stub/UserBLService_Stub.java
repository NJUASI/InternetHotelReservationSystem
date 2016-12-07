package businessLogic.userBL.stub;

import java.time.LocalDate;
import java.util.List;

import businessLogicService.userBLService.UserBLService;
import utilities.ResultMessage;
import utilities.UserType;
import vo.GuestVO;
import vo.HotelVO;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService {

	
	public List<UserVO> getAll(UserType userType) {
		return null;
	}

	
	public UserVO getSingle(String userID) {
		LocalDate s  = LocalDate.parse("2014-02-28"); 
		UserVO userVO = new GuestVO("1234567890", s, "人寿保险", "gaoy", "s", "123456", "1908486942", 50);
		return userVO;
	}

	public UserVO add(UserVO newUserVO) {
		LocalDate s  = LocalDate.parse("2014-02-28"); 
		UserVO userVO = new GuestVO("1234567890", s, "人寿保险", "gaoy", "s", "123456", "1908486942", 50);
		return userVO;
	}

	
	public ResultMessage addHotel(HotelVO newHotelVO, String hotelID) {
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage modify(UserVO userVO) {
		return ResultMessage.SUCCESS;
	}

	public String getLogInInfo(String userID,UserType type) {
		return "0000000";
	}


	@Override
	public UserVO getSingle(String userID, UserType userType) {
		return null;
	}


}
