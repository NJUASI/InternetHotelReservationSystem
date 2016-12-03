package businessLogic.logInBL;

import businessLogic.userBL.MockUser;
import businessLogic.userBL.User;
import utilities.ResultMessage;
import utilities.UserType;
import vo.GuestVO;

/**
 * 
 * @author 61990
 *
 */
public class MockLogIn extends LogIn {

	private User user;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public MockLogIn() {
		user = new MockUser();
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
		final String realPassword = user.getLogInInfo(guest, UserType.GUEST);
		if (realPassword.equals(password)) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAIL;
		}
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
		final String realPassword = user.getLogInInfo(hotelWorker, UserType.HOTEL_WORKER);
		if (realPassword.equals(password)) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAIL;
		}
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
		final String realPassword = user.getLogInInfo(webMarketer, UserType.WEB_MARKETER);
		if (realPassword.equals(password)) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAIL;
		}
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
		final String realPassword = user.getLogInInfo(webManager, UserType.WEB_MANAGER);
		if (realPassword.equals(password)) {
			return ResultMessage.SUCCESS;
		} else {
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
