package businessLogic.userBL.userService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.userBL.userService.service.UserService;
import dataService.webManagerDataService.WebManagerDataService;
import dataService.webManagerDataService.WebManagerDataService_Stub;
import po.WebManagerPO;
import utilities.Ciphertext;
import utilities.ResultMessage;
import vo.UserVO;
import vo.WebManagerVO;

/**
 * 
 * @author Byron Dong lastChangedBy Byron Dong updateTime 2016/11/28
 *
 */

public class WebManager implements UserService {

	public static int IDLength = 4; // 网站管理人员的ID长度为4

	private WebManagerDataService webManagerDataService;

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28 构造函数，初始化成员变量
	 */
	public WebManager() {
		// webManagerDataService =
		// ClientRemoteHelper.getInstance().getWebManagerDataService();
		try {
			webManagerDataService = new WebManagerDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param newUserVO
	 *            从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功添加网站管理人员信息
	 */
	public UserVO add(UserVO newUserVO) {

		try {
			WebManagerPO webManagerPO = this.convert(newUserVO);
			return this.convert(webManagerDataService.add(webManagerPO));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param newUserVO
	 *            从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功修改网站管理人员信息
	 */
	public ResultMessage modify(UserVO userVO) {

		//TODO 董金玉：USER_INFO_UPDATE_FAILURE
		ResultMessage msg = ResultMessage.FAIL;

		if (!this.hasWebManager(userVO.userID)) {
			return msg;
		} // 不存在ID对应项

		try {
			WebManagerPO webManagerPO = this.convert(userVO);
			msg = webManagerDataService.modify(webManagerPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param userVO
	 *            从userDoMain传下来的用户ID
	 * @return UserVO 单一webManagerInfo载体
	 */
	public UserVO getSingle(String userID) {

		try {
			return this.convert(webManagerDataService.getSingleWebManager(userID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null; // 若为空，则返回null
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
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
		return null; // 若为空，则返回null，后期需要定夺
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param userID
	 *            从userDoMain传下来的指定用户ID
	 * @return String 指定用户 的登录信息
	 */
	public String getLogInInfo(String userID) {

		if (!this.hasWebManager(userID)) {
			return null;
		} // 不存在ID对应项,后期细化

		try {
			return convert(webManagerDataService.getSingleWebManager(userID)).password;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param webManagerPO
	 *            来自本类webManagerInfo载体
	 * @return UserVO userInfo载体
	 */
	private UserVO convert(WebManagerPO webManagerPO) {
		if (webManagerPO == null) {
			return null;
		}
		return new WebManagerVO(this.decode(webManagerPO));
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param userPO
	 *            来自本类userInfo载体
	 * @return WebManagerPO webManagerInfo载体
	 */
	private WebManagerPO convert(UserVO userVO) {
		if (userVO == null) {
			return null;
		}
		return this.encrypt(new WebManagerPO((WebManagerVO) userVO));
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param List<WebManagerPO>
	 *            来自本类所有webManagerInfo载体
	 * @return List<UserVO> 所有对应的userInfo载体
	 */
	private List<UserVO> convert(List<WebManagerPO> list) {
		List<UserVO> result = new ArrayList<UserVO>();
		for (int i = 0; i < list.size(); i++) {
			result.add(new WebManagerVO(this.decode(list.get(i))));
		}
		return result;
	}

	private boolean hasWebManager(String webManagerID) {
		UserVO webManagerVO = this.getSingle(webManagerID);

		if (webManagerVO == null) {
			return false;
		} else {
			return true;
		}
	}

	private WebManagerPO encrypt(WebManagerPO webManagerPO) {
		Ciphertext encrypt = new Ciphertext();
		webManagerPO.setPassword(encrypt.encrypt(webManagerPO.getPassword()));
		return webManagerPO;
	}

	private WebManagerPO decode(WebManagerPO webManagerPO) {
		Ciphertext decode = new Ciphertext();
		webManagerPO.setPassword(decode.decode(webManagerPO.getPassword()));
		return webManagerPO;
	}

}
