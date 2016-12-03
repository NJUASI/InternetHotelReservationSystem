package businessLogic.userBL.stub;

import java.time.LocalDate;
import java.util.List;

import businessLogicService.userBLService.UserBLService;
import utilities.ResultMessage;
import utilities.UserType;
import vo.CreditVO;
import vo.GuestVO;
import vo.HotelVO;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService {

	
	public List<UserVO> getAll(UserType userType) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public UserVO getSingle(String userID, UserType userType) {
		LocalDate s  = LocalDate.parse("2014-02-28"); 
		UserVO userVO = new GuestVO("123456", s, "人寿保险", "gaoy", "s", "123456", "1908486942", 50);
		return userVO;
	}

	
	public List<CreditVO> getAllCreditDetail(String guestID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ResultMessage add(UserVO newUserVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage addHotel(HotelVO newHotelVO, String hotelID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage modify(UserVO userVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage modifyCredit(String guestID, double creditNum) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
	public String getLogInInfo(String userID, UserType userType) {
		// TODO Auto-generated method stub
		return "000000";
	}
}
