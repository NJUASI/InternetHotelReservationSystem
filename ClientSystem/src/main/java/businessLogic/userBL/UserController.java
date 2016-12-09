package businessLogic.userBL;

import java.util.List;

import businessLogic.userBL.userService.Guest;
import businessLogic.userBL.userService.service.GuestCreditService;
import businessLogicService.userBLService.UserBLService;
import utilities.ResultMessage;
import utilities.UserType;
import vo.HotelVO;
import vo.UserVO;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * updateTime 2016/11/27
 *
 */
public class UserController implements UserBLService{

	
	private User user;
	private static UserController userController;
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	private UserController() {
		//new the mock object
		user = new MockUser();
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param 
	 * @return 唯一userController对象
	 */
	public static UserController getInstance(){ //采用单例模式
		if(userController == null) userController = new UserController();
		return userController;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userVO 从客户界面层传下来的userInfo载体
	 * @return ResultMessage 用户是否成功添加用户信息
	 */
	public UserVO add(UserVO newUserVO , UserType userType) {
		return user.add(newUserVO , userType);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userVO 从客户界面层传下来的userInfo载体
	 * @return ResultMessage 用户是否成功修改用户信息
	 */
	public ResultMessage modify(UserVO userVO) {
		return user.modify(userVO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userVO，userType 从客户界面层传下来的userInfo载体和指定用户类型
	 * @return UserVO 单一userInfo载体
	 */
	public UserVO getSingle(String userID) {
		return user.getSingle(userID);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param newHotelVO，hotelID 从客户界面层传下来的hotelInfo载体和指定酒店ID
	 * @return ResultMessage 酒店是否添加成功
	 */
	public ResultMessage addHotel(HotelVO newHotelVO) {
		return user.addHotel(newHotelVO);
	}
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/9
	 * @param guestID，creditNum 客户ID和需要修改的信用值
	 * @return ResultMessage 信用值是否添加成功
	 */
	public ResultMessage modifyCredit(String guestID, double creditNum) {
		GuestCreditService guest = new Guest(); 
		return guest.modifyCredit(guestID, creditNum);
	}


	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param  userType 从客户界面层传下来的指定用户类型
	 * @return List<UserVO> 指定用户类型的所有userInfo载体
	 */
	public List<UserVO> getAll(UserType userType) {
		return user.getAll(userType);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param  guestID, userType 从客户界面层传下来的指定用户ID和指定用户类型
	 * @return String 指定用户 的登录信息
	 */
	public String getLogInInfo(String userID,UserType userType) {
		return user.getLogInInfo(userID,userType);
	}
}
