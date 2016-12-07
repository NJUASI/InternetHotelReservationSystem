package businessLogic.logInBL;

import businessLogicService.logInBLService.LogInBLService;
import utilities.UserType;
import vo.GuestVO;
import vo.UserVO;

/**
 * 
 * @author 61990
 *
 */
public final class LogInController implements LogInBLService {

	private LogIn logIn;
	
	private static LogInController logInController = new LogInController();


	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	private LogInController() {
		// new the mock object
		logIn = new MockLogIn();
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @return login controller的实例，单例化
	 */
	public static LogInController getInstance() {
		return logInController;
	}
	
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestVO
	 *           从注册界面层传下来的guestVO
	 * @return 客户是否成功注册
	 */
	public GuestVO guestSignUp(UserVO guestVO) {
		return logIn.guestSignUp(guestVO);
	}

	@Override
	public UserType logIn(String userID, String password) {
		return logIn.logIn(userID, password);
	}

}
