package businessLogic.logInBL.stub;

import java.time.LocalDate;

import businessLogicService.logInBLService.LogInBLService;
import utilities.ResultMessage;
import utilities.UserType;
import vo.GuestVO;
import vo.UserVO;

/**
 * 
 * @author 61990
 *
 */
public class LogInBLService_Stub implements LogInBLService {

//	String guest;
//	String hotelWorker;
//	String webMarketer;
//	String webManager;
//	String password;
//	
//	public LogInBLService_Stub(String ID, String password) {
//		this.guest = ID;
//		this.password = password;
//	}
	
//	/**
//	 * @author 61990
//	 * @lastChangedBy 61990
//	 * @updateTime 2016/11/27
//	 * @param guest
//	 *            从登录界面层传下来的ID
//	 * @param password
//	 *            从登录界面层传下来的密码
//	 * @return 客户是否成功登录
//	 */
//	public ResultMessage guestLogIn(final String guest, final String password) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/**
//	 * @author 61990
//	 * @lastChangedBy 61990
//	 * @updateTime 2016/11/27
//	 * @param hotelWorker
//	 *            从登录界面层传下来的ID
//	 * @param password
//	 *            从登录界面层传下来的密码
//	 * @return 酒店是否成功登录
//	 */
//	public ResultMessage hotelWorkerLogIn(final String hotelWorker, final String password) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/**
//	 * @author 61990
//	 * @lastChangedBy 61990
//	 * @updateTime 2016/11/27
//	 * @param webMarketer
//	 *            从登录界面层传下来的ID
//	 * @param password
//	 *            从登录界面层传下来的密码
//	 * @return 营销人员是否成功登录
//	 */
//	public ResultMessage webMarketerLogIn(final String webMarketer, final String password) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}
//
//	/**
//	 * @author 61990
//	 * @lastChangedBy 61990
//	 * @updateTime 2016/11/27
//	 * @param webManager
//	 *            从登录界面层传下来的ID
//	 * @param password
//	 *            从登录界面层传下来的密码
//	 * @return 管理人员是否成功登录
//	 */
//	public ResultMessage webManagerLogIn(final String webManager, final String password) {
//		// TODO Auto-generated method stub
//		return ResultMessage.SUCCESS;
//	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestVO
	 *           从注册界面层传下来的guestVO
	 * @return 客户是否成功注册
	 */
	public GuestVO guestSignUp(UserVO guestVO) {
		return new GuestVO("1234567890", LocalDate.of(1995, 4, 1), "school", "zhangsan", 
				"xiaosan", "000000", "13523456789", 100);
	}

	@Override
	public ResultMessage logIn(String userID, String password,UserType userType) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

}
