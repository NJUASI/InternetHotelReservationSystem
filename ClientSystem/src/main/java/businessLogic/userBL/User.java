package businessLogic.userBL;

import java.util.List;

import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.userBL.userService.UserFactory;
import businessLogic.userBL.userService.UserLengthFactory;
import businessLogic.userBL.userService.service.UserService;
import exception.operationFailedException.AddFaidException;
import exception.verificationException.ParameterInvalidException;
import exception.verificationException.UserInexistException;
import utilities.ResultMessage;
import utilities.UserType;
import vo.HotelVO;
import vo.HotelWorkerVO;
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
	 * @throws AddFaidException 
	 * @throws ParameterInvalidException 
	 */
	public UserVO add(UserVO newUserVO,UserType userType) {

		user = factory.createUser(userType);
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
		
		//TODO 董金玉：USER_UNEXISTENCE
		return ResultMessage.FAIL;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Harvey Gong
	 * @updateTime 2016/11/27
	 * @param userVO，userType 从客户界面层传下来的userInfo载体和指定用户类型
	 * @return UserVO 单一userInfo载体
	 * @throws UserInexistException 
	 */
	public UserVO getSingle(String userID) throws UserInexistException {

		user = lengthFactory.createUser(userID.length());
		
		if(isExistence(user)){
			return user.getSingle(userID);
		}
		return null;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/9
	 * @param newHotelVO 从客户界面层传下来的hotelInfo载体
	 * @return ResultMessage 酒店是否添加成功
	 * @throws AddFaidException 
	 */
	public HotelVO addHotel(HotelVO newHotelVO) {

		if(newHotelVO==null){return null;}
		
		Hotel hotel = new Hotel();
		
		HotelWorkerVO  hotelWorkerVO = new HotelWorkerVO(newHotelVO.hotelName);
		hotelWorkerVO = (HotelWorkerVO) this.add(hotelWorkerVO, UserType.HOTEL_WORKER);
		
		newHotelVO.hotelID = hotelWorkerVO.userID;
		
		if(hotel.addHotelInfo(newHotelVO)==ResultMessage.SUCCESS){ //与该酒店工作人员同步
			return newHotelVO;
		}
		else{
			return null;
		}
			

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
	 * @throws UserInexistException 
	 */
	public String getLogInInfo(String userID,UserType userType) throws UserInexistException {
		
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
