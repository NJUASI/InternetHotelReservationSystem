package businessLogic.userBL;

import java.util.List;

import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.userBL.userService.UserFactory;
import businessLogic.userBL.userService.UserLengthFactory;
import businessLogic.userBL.userService.service.UserService;
import utilities.ResultMessage;
import utilities.UserType;
import vo.HotelVO;
import vo.UserVO;

/**
 * 
 * @author Byron Dong
 * lastChangedBy Harvey Gong
 * updateTime 2016/12/5
 *
 */
public class User {

	private UserService user;//该变量在方法中实时修改
	
	private UserFactory factory; //根据用户类型创建用户的工厂
	private UserLengthFactory lengthFactory; //根据用户id的长度创建用户的工厂

	/**
	 * @author Byron Dong
	 * @lastChangedBy Harvey Gong
	 * @updateTime 2016/12/5
	 * 构造函数，根据成员变量注释初始化成员变量
	 */
	public User() {
		factory = new UserFactory();
		lengthFactory = new UserLengthFactory();
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/5
	 * @param userVO 从客户界面层传下来的userInfo载体
	 * @return ResultMessage 用户是否成功添加用户信息
	 */
	public UserVO add(UserVO newUserVO) {

		user = lengthFactory.createUser(newUserVO.userID.length());
		if(isExistence(user))
		{
			return user.add(newUserVO);
		}
		return null;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Harvey Gong
	 * @updateTime 2016/12/5
	 * @param userVO 从客户界面层传下来的userInfo载体
	 * @return ResultMessage 用户是否成功修改用户信息
	 */
	public ResultMessage modify(UserVO userVO) {

		user = lengthFactory.createUser(userVO.userID.length());
		if(isExistence(user)){
			return user.modify(userVO);
		}
		return ResultMessage.USER_UNEXISTENCE;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Harvey Gong
	 * @updateTime 2016/11/27
	 * @param userVO，userType 从客户界面层传下来的userInfo载体和指定用户类型
	 * @return UserVO 单一userInfo载体
	 */
	public UserVO getSingle(String userID) {

		user = lengthFactory.createUser(userID.length());
		
		if(isExistence(user)){
			return user.getSingle(userID);
		}
		return null;
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

		if (hotel.getHotelInfo(hotelID) == null) {
			return hotel.addHotelInfo(newHotelVO);
		}

		return ResultMessage.HOTEL_EXIST;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param  userType 从客户界面层传下来的指定用户类型
	 * @return List<UserVO> 指定用户类型的所有userInfo载体
	 */
	public List<UserVO> getAll(UserType userType) {

		user = factory.createUser(userType);

		return user.getAll();

	}

	/**
	 * @author Byron Dong
	 * @param userType 
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param  guestID, userType 从客户界面层传下来的指定用户ID和指定用户类型
	 * @return String 指定用户 的登录信息
	 */
	public String getLogInInfo(String userID,UserType userType) {
		
		user = factory.createUser(userType);
		
		if(isExistence(user)){
			return user.getLogInInfo(userID); 
		}
		return null;
	}
	
	/**
	 * @Description:判断user是否被初始化成功
	 * @param user
	 * @return
	 * boolean
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月5日 上午11:17:45
	 */
	private boolean isExistence(UserService user){
		if(user == null){
			return false;
		}
		return true;
	}
}
