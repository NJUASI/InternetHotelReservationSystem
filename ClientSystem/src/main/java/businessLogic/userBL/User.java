package businessLogic.userBL;

import java.util.List;

import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.userBL.userService.Guest;
import businessLogic.userBL.userService.HotelWorker;
import businessLogic.userBL.userService.WebManager;
import businessLogic.userBL.userService.WebMarketer;
import businessLogic.userBL.userService.service.CreditService;
import businessLogic.userBL.userService.service.UserService;
import utilities.ResultMessage;
import utilities.UserType;
import vo.CreditVO;
import vo.HotelVO;
import vo.UserVO;

/**
 * 
 * @author Byron Dong
 * lastChangedBy Byron Dong
 * updateTime 2016/11/27
 *
 */
public class User {

	private UserService user;//该变量在方法中实时修改
	private CreditService guest;//在构造中new一次

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * 构造函数，根据成员变量注释初始化成员变量
	 */
	public User() {
		guest = new Guest();
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param userVO 从客户界面层传下来的userInfo载体
	 * @return ResultMessage 用户是否成功添加用户信息
	 */
	public ResultMessage add(UserVO newUserVO) {

		ResultMessage msg = ResultMessage.USER_INEXISTENCE;
		this.initial(newUserVO.userID.length());
		
		if(user==null){return msg;}

		msg = user.add(newUserVO);

		return msg;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param userVO 从客户界面层传下来的userInfo载体
	 * @return ResultMessage 用户是否成功修改用户信息
	 */
	public ResultMessage modify(UserVO userVO) {

		ResultMessage msg = ResultMessage.USER_INEXISTENCE;
		this.initial(userVO.userID.length());
		
		if(user==null){return msg;}

		msg = user.modify(userVO);

		return msg;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param userVO，userType 从客户界面层传下来的userInfo载体和指定用户类型
	 * @return UserVO 单一userInfo载体
	 */
	public UserVO getSingle(String userID, UserType userType) {

		this.initial(userID.length());
		
		if(user==null){return null;} //没有对应ID长度的用户，返回null

		return user.getSingle(userID);

	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param newHotelVO，hotelID 从客户界面层传下来的hotelInfo载体和指定酒店ID
	 * @return ResultMessage 酒店是否添加成功
	 */
	public ResultMessage addHotel(HotelVO newHotelVO, String hotelID) {

		Hotel hotel = new Hotel(hotelID);
		ResultMessage msg = ResultMessage.HOTEL_EXIST;

		if (hotel.getHotelInfo(hotelID) == null) {
			msg = hotel.addHotelInfo(newHotelVO);
		}

		return msg;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param guestID, creditNum从客户界面层传下来的指定客户ID和需修改的信用值
	 * @return ResultMessage 信用值是否添加成功
	 */
	public ResultMessage modifyCredit(String guestID, double creditNum) {
		return guest.modifyCredit(guestID, creditNum);
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param  userType 从客户界面层传下来的指定用户类型
	 * @return List<UserVO> 指定用户类型的所有userInfo载体
	 */
	public List<UserVO> getAll(UserType userType) {

		this.initial(userType);

		return user.getAll();

	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param  guestID 从客户界面层传下来的指定用户ID
	 * @return List<CreditVO> 指定客户的所有creditInfo载体
	 */
	public List<CreditVO> getAllCreditDetail(String guestID) {
		List<CreditVO> creditVOList = guest.getAllCreditDetail(guestID);
		
		if(creditVOList.isEmpty()){return null;}
		
		return creditVOList;
		
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param  guestID, userType 从客户界面层传下来的指定用户ID和指定用户类型
	 * @return String 指定用户 的登录信息
	 */
	public String getLogInInfo(String userID, UserType userType) {
		
		this.initial(userID.length());
		
		if(user==null){return null;} //如果对应ID长度不在范围，返回null
		
		return user.getLogInInfo(userID);
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param  IDLength 从本类传下来的指定用户ID长度
	 * @return  根据ID长度初始化user对象
	 */
	private void initial(int IDLength) {
		if (Guest.isGuest(IDLength)) {
			user = new Guest();
			return;
		}

		if (HotelWorker.isHotelWorker(IDLength)) {
			user = new HotelWorker();
			return;
		}

		if (WebMarketer.isWebMarketer(IDLength)) {
			user = new WebMarketer();
			return;
		}

		if (WebManager.isWebManager(IDLength)) {
			user = new WebManager();
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param  userType 从本类传下来的指定用户类型
	 * @return  根据用户类型初始化user对象
	 */
	private void initial(UserType userType) {
		if (Guest.isGuest(userType)) {
			user = new Guest();
			return;
		}

		if (HotelWorker.isHotelWorker(userType)) {
			user = new HotelWorker();
			return;
		}

		if (WebMarketer.isWebMarketer(userType)) {
			user = new WebMarketer();
			return;
		}

		if (WebManager.isWebManager(userType)) {
			user = new WebManager();
		}
	}
}
