package businessLogic.userBL.userService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.userBL.userService.service.UserService;
import dataService.webMarketerDataService.WebMarketerDataService;
import dataService.webMarketerDataService.WebMarketerDataService_Stub;
import po.WebMarketerPO;
import utilities.Ciphertext;
import utilities.ResultMessage;
import vo.UserVO;
import vo.WebMarketerVO;

/**
 * 
 * @author Byron Dong lastChangedBy Byron Dong updateTime 2016/11/28
 *
 */
public class WebMarketer implements UserService {

	public static int IDLength = 6; // 营销人员的ID长度为6

	private WebMarketerDataService webMarketerDataService;

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28 构造函数，初始化成员变量
	 */
	public WebMarketer() {
		// webMarketerDataService =
		// ClientRemoteHelper.getInstance().getWebMarketerDataService();
		try {
			webMarketerDataService = new WebMarketerDataService_Stub();
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
	 * @return ResultMessage 用户是否成功添加网站营销人员信息
	 */
	public WebMarketerVO add(UserVO newUserVO) {

		try {
			WebMarketerPO webMarketerPO = this.convert(newUserVO);
			return convert(webMarketerDataService.add(webMarketerPO));
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
	 * @return ResultMessage 用户是否成功修改网站营销人员信息
	 */
	public ResultMessage modify(UserVO userVO) {

		//TODO 董金玉：USER_INFO_UPDATE_FAILURE
		ResultMessage msg = ResultMessage.FAIL;

		if (!this.hasWebMarketer(userVO.userID)) {
			return msg;
		} // 不存在ID对应项

		try {
			WebMarketerPO webMarketerPO = this.convert(userVO);
			msg = webMarketerDataService.modify(webMarketerPO);
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
	 * @return UserVO 单一webMarketerInfo载体
	 */
	public UserVO getSingle(String userID) {

		try {
			return this.convert(webMarketerDataService.getSingleWebMarketer(userID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param userVO
	 *            从userDoMain传下来的用户ID
	 * @return UserVO 单一webMarketerInfo载体
	 */
	public List<UserVO> getAll() {

		try {
			return this.convert(webMarketerDataService.getAllWebMarketer());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
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

		if (!this.hasWebMarketer(userID)) {
			return null;
		} // 不存在ID对应项,后期细化

		try {
			return convert(webMarketerDataService.getSingleWebMarketer(userID)).password;

		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param webMarketerPO
	 *            来自本类webMarketerInfo载体
	 * @return UserVO userInfo载体
	 */
	private WebMarketerVO convert(WebMarketerPO webMarketerPO) {
		if (webMarketerPO == null) {
			return null;
		}
		return new WebMarketerVO(this.decode(webMarketerPO));
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param userPO
	 *            来自本类userInfo载体
	 * @return WebMarketerPO webMarketerInfo载体
	 */
	private WebMarketerPO convert(UserVO userVO) {
		if (userVO == null) {
			return null;
		}
		return this.encrypt(new WebMarketerPO((WebMarketerVO) userVO));
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param List<WebMarketerPO>
	 *            来自本类所有webMarketerInfo载体
	 * @return List<UserVO> 所有对应的userInfo载体
	 */
	private List<UserVO> convert(List<WebMarketerPO> list) {
		List<UserVO> result = new ArrayList<UserVO>();
		for (int i = 0; i < list.size(); i++) {
			result.add(new WebMarketerVO(this.decode(list.get(i))));
		}
		return result;
	}

	private boolean hasWebMarketer(String webMarketerID) {
		UserVO webMarketerVO = this.getSingle(webMarketerID);

		if (webMarketerVO == null) {
			return false;
		} else {
			return true;
		}
	}

	private WebMarketerPO encrypt(WebMarketerPO webMaketerPO) {
		Ciphertext encrypt = new Ciphertext();
		webMaketerPO.setPassword(encrypt.encrypt(webMaketerPO.getPassword()));
		return webMaketerPO;
	}

	private WebMarketerPO decode(WebMarketerPO webMaketerPO) {
		Ciphertext decode = new Ciphertext();
		webMaketerPO.setPassword(decode.decode(webMaketerPO.getPassword()));
		return webMaketerPO;
	}

}
