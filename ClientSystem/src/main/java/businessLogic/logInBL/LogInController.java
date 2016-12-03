package businessLogic.logInBL;

import businessLogicService.logInBLService.LogInBLService;
import utilities.ResultMessage;
import vo.GuestVO;

/**
 * 
 * @author 61990
 *
 */
public final class LogInController implements LogInBLService {

	private LogIn logIn;
	
	private static LogInController logInController;


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
		if (logInController == null) {
			logInController = new LogInController();
		}
		return logInController;
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guest
	 *            从登录界面层传下来的ID
	 * @param password
	 *            从登录界面层传下来的密码
	 * @return 客户是否成功登录
	 */
	public ResultMessage guestLogIn(final String guest, final String password) {
		return logIn.guestLogIn(guest, password);
	}


	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param hotelWorker
	 *            从登录界面层传下来的ID
	 * @param password
	 *            从登录界面层传下来的密码
	 * @return 酒店是否成功登录
	 */
	public ResultMessage hotelWorkerLogIn(final String hotelWorker, final String password) {
		return logIn.hotelWorkerLogIn(hotelWorker, password);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param webMarketer
	 *            从登录界面层传下来的ID
	 * @param password
	 *            从登录界面层传下来的密码
	 * @return 营销人员是否成功登录
	 */
	public ResultMessage webMarketerLogIn(final String webMarketer, final String password) {
		return logIn.webManagerLogIn(webMarketer, password);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param webManager
	 *            从登录界面层传下来的ID
	 * @param password
	 *            从登录界面层传下来的密码
	 * @return 管理人员是否成功登录
	 */
	public ResultMessage webManagerLogIn(final String webManager, final String password) {
		return logIn.webManagerLogIn(webManager, password);
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
		return logIn.guestSignUp(guestVO);
	}

}
