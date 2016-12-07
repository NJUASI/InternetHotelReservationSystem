package businessLogic.logInBL;

import businessLogic.userBL.User;
import businessLogic.userBL.userService.Guest;
import businessLogicService.logInBLService.LogInBLService;
import utilities.Detector;
import utilities.UserType;
import vo.GuestVO;
import vo.UserVO;

/**
 * 
 * @author 61990
 * @lastChangedBy Byron Dong
 *
 */
public class LogIn implements LogInBLService{

	private User user;
	private LogInFactory factory;

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * 构造函数，初始化成员变量
	 */
	public LogIn() {
		user = new User();
		factory = new LogInFactory();
	}

	/**
	 * @Description:根据用户id获取用户的密码，并验证登录
	 * @param userID
	 * @param password
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Byron Dong
	 * @time:2016年12月7日 
	 */
	public UserType logIn(String userID,String password){
		
		UserType userType = this.factory.getUserType(userID);
		
		if(!this.hasUserType(userType)){return null;} //
		
		String tempPassword = user.getLogInInfo(userID,userType); 
		
		if(!tempPassword.equals(password)){return null;} //得到的结果为null, 登录失败
		
		return userType;
	}

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @param guestVO
	 *           从注册界面层传下来的guestVO
	 * @return 客户是否成功注册
	 */
	public GuestVO guestSignUp(UserVO guestVO) {
		
		if(!this.infoDetector(guestVO)){return null;} //检查内容是否符合规范，不符合返回null
		
		return (GuestVO)user.add(guestVO);
	}
	
	private boolean hasUserType(UserType userType){
		if(userType==null){
			return false;
		}
		else{
			return true;
		}
	}
	
	private boolean infoDetector(UserVO userVO){
		GuestVO guestVO = (GuestVO)userVO;
		Detector detector = new Detector();
		boolean name = detector.infoDetector(guestVO.name);
		boolean password = detector.passwordDetector(guestVO.password);
		boolean phone = detector.phoneDetector(guestVO.phone);
		
		if(name&&password&&phone){
			return true;
		}
		else{
			return false;
		}
	}
}
