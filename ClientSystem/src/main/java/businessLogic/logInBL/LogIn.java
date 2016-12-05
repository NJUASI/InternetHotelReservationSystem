package businessLogic.logInBL;

import businessLogic.userBL.User;
import businessLogicService.logInBLService.LogInBLService;
import utilities.ResultMessage;
import utilities.UserType;
import vo.GuestVO;

/**
 * 
 * @author 61990
 * @lastChangedBy Harvey Gong
 *
 */
public class LogIn implements LogInBLService{

	private User user;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public LogIn() {
		user = new User();
	}

	/**
	 * @Description:根据用户id获取用户的密码，并验证登录
	 * @param userID
	 * @param password
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月5日 下午3:06:55
	 */
	public ResultMessage logIn(String userID,String password,UserType userType){
		if(password == user.getLogInInfo(userID,userType)){
			return ResultMessage.SUCCESS;
		}
		else
		{
			return ResultMessage.FAIL;
		}
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestVO
	 *           从注册界面层传下来的guestVO
	 * @return 客户是否成功注册
	 */
	public ResultMessage guestSignUp(final GuestVO guestVO) {
		return user.add(guestVO);
	}
}
