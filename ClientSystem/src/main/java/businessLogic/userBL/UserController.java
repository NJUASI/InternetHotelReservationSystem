package businessLogic.userBL;

import java.util.List;

import businessLogicService.userBLService.UserBLService;
import utilities.ResultMessage;
import utilities.UserType;
import vo.CreditVO;
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
	public static UserController getInstance(){ //采用单粒模式
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
	public ResultMessage add(UserVO newUserVO) {
		// TODO Auto-generated method stub
		return user.add(newUserVO);
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
	public UserVO getSingle(String userID, UserType userType) {
		return user.getSingle(userID, userType);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param newHotelVO，hotelID 从客户界面层传下来的hotelInfo载体和指定酒店ID
	 * @return ResultMessage 酒店是否添加成功
	 */
	public ResultMessage addHotel(HotelVO newHotelVO, String hotelID) {
		return user.addHotel(newHotelVO, hotelID);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param guestID, creditNum从客户界面层传下来的指定客户ID和需修改的信用值
	 * @return ResultMessage 信用值是否添加成功
	 */
	public ResultMessage modifyCredit(String guestID, double creditNum) {
		return user.modifyCredit(guestID, creditNum);
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
	 * @param  guestID 从客户界面层传下来的指定用户ID
	 * @return List<CreditVO> 指定客户的所有creditInfo载体
	 */
	public List<CreditVO> getAllCreditDetail(String guestID) {
		return user.getAllCreditDetail(guestID);
	}


	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param  guestID, userType 从客户界面层传下来的指定用户ID和指定用户类型
	 * @return String 指定用户 的登录信息
	 */
	public String getLogInInfo(String userID, UserType userType) {
		return user.getLogInInfo(userID, userType);
	}

}
