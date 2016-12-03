package businessLogic.userBL.userService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.userBL.userService.service.UserService;
import dataService.webManagerDataService.WebManagerDataService;
import dataService.webManagerDataService.WebManagerDataService_Stub;
import po.WebManagerPO;
import utilities.ResultMessage;
import utilities.UserType;
import vo.UserVO;
import vo.WebManagerVO;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * updateTime 2016/11/28
 *
 */

public class WebManager implements UserService{

	
	private static int IDLength = 4; // 网站管理人员的ID长度为4

	private static UserType type = UserType.WEB_MANAGER;

	private WebManagerDataService webManagerDataService;

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * 构造函数，初始化成员变量
	 */
	public WebManager() {
		webManagerDataService = new WebManagerDataService_Stub();
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param newUserVO 从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功添加网站管理人员信息
	 */
	public ResultMessage add(UserVO newUserVO) {

		ResultMessage msg = ResultMessage.USER_ADD_FAILURE;

		try {
			WebManagerPO webManagerPO = this.convert(newUserVO);
			msg = webManagerDataService.add(webManagerPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param newUserVO 从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功修改网站管理人员信息
	 */
	public ResultMessage modify(UserVO userVO) {

		ResultMessage msg = ResultMessage.USER_INFO_UPDATE_FAILURE;

		try {
			WebManagerPO webManagerPO = this.convert(userVO);
			msg = webManagerDataService.modify(webManagerPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param userVO 从userDoMain传下来的用户ID
	 * @return UserVO 单一webManagerInfo载体
	 */
	public UserVO getSingle(String userID) {

		try {
			return this.convert(webManagerDataService.getSingleWebManager(userID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param  
	 * @return List<UserVO> 指定用户类型的所有webManagerInfo载体
	 */
	public List<UserVO> getAll() {

		try {
			return this.convert(webManagerDataService.getAllWebManager());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  userID 从userDoMain传下来的指定用户ID
	 * @return String 指定用户 的登录信息
	 */
	public String getLogInInfo(String userID) {

		try {
			return webManagerDataService.getSingleWebManager(userID).getPassword();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param  IDLength 用户ID长度
	 * @return boolean 判断指定用户是否为网站管理人员类型
	 */
	public static boolean isWebManager(int length) {
		if (WebManager.IDLength == length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  type 用户类型
	 * @return boolean 判断指定用户是否为网站管理人员类型
	 */
	public static boolean isWebManager(UserType type) {
		if (WebManager.type == type) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  webManagerPO 来自本类webManagerInfo载体
	 * @return UserVO userInfo载体
	 */
	private UserVO convert(WebManagerPO webManagerPO) {
		return new WebManagerVO(webManagerPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  userPO 来自本类userInfo载体
	 * @return WebManagerPO webManagerInfo载体
	 */
	private WebManagerPO convert(UserVO userVO) {
		return new WebManagerPO((WebManagerVO) userVO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  List<WebManagerPO> 来自本类所有webManagerInfo载体
	 * @return List<UserVO> 所有对应的userInfo载体
	 */
	private List<UserVO> convert(List<WebManagerPO> list) {
		List<UserVO> result = new ArrayList<UserVO>();
		for (int i = 0; i < list.size(); i++) {
			result.add(new WebManagerVO(list.get(i)));
		}
		return result;
	}

}
