package businessLogic.userBL.userService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.userBL.userService.service.GuestCreditService;
import businessLogic.userBL.userService.service.UserService;
import dataService.guestDataService.GuestDataService;
import dataService.guestDataService.GuestDataService_Stub;
import exception.verificationException.UserInexistException;
import po.GuestPO;
import utilities.Ciphertext;
import utilities.ResultMessage;
import vo.GuestVO;
import vo.UserVO;

/**
 * 
 * @author Byron Dong lastChangedBy Byron Dong updateTime 2016/11/27
 *
 */
public class Guest implements UserService, GuestCreditService {

	public static int IDLength = 10; // 客户的ID长度为10

	private GuestDataService guestDataService;

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	public Guest() {
		// guestDataService =
		// ClientRemoteHelper.getInstance().getGuestDataService();
		try {
			guestDataService = new GuestDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/9
	 * @param newUserVO
	 *            从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功添加客户信息
	 */
	public UserVO add(UserVO newUserVO) {

		try {
			GuestPO guestPO = convert(newUserVO);
			return convert(guestDataService.add(guestPO));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param newUserVO
	 *            从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功修改客户信息
	 */
	public ResultMessage modify(UserVO userVO) {

		//TODO 董金玉：USER_INFO_UPDATE_FAILURE
		ResultMessage msg = ResultMessage.FAIL;

		if (!this.hasGuest(userVO.userID)) {
			return msg;
		} // 不存在ID对应项

		try {
			GuestPO guestPO = convert(userVO);
			msg = guestDataService.modify(guestPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param userVO
	 *            从userDoMain传下来的用户ID
	 * @return UserVO 单一guestInfo载体
	 * @throws UserInexistException 
	 */
	public UserVO getSingle(String userID) throws UserInexistException {

		try {
			return this.convert(guestDataService.getSingleGuest(userID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param
	 * @return List<UserVO> 指定用户类型的所有guestInfo载体
	 */
	public List<UserVO> getAll() {

		try {
			return this.convert(guestDataService.getAllGuest());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/9
	 * @param userID
	 *            从userDoMain传下来的指定用户ID
	 * @return String 指定用户 的登录信息
	 * @throws UserInexistException 
	 */
	public String getLogInInfo(String userID) throws UserInexistException {

		try {
			return convert(guestDataService.getSingleGuest(userID)).password;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null; // 出现异常返回null
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Harvey Gong
	 * @updateTime 2016/12/5
	 * @param guestID,
	 *            creditNum从userDoMain传下来的指定客户ID和需修改的信用值
	 * @return ResultMessage 信用值是否添加成功
	 * @throws UserInexistException 
	 */
	public ResultMessage modifyCredit(String guestID, double creditNum) throws UserInexistException {

		GuestPO guestPO = null;
		try {
			guestPO = guestDataService.getSingleGuest(guestID);
			
			guestPO.setCredit(creditNum);
			return guestDataService.modify(guestPO);
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/27
	 * @param IDLength
	 *            用户ID长度
	 * @return boolean 判断指定用户是否为客户类型
	 */
	public boolean isGuest(int length) {
		if (Guest.IDLength == length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param guestPO
	 *            来自本类guestInfo载体
	 * @return UserVO userInfo载体
	 */
	private UserVO convert(GuestPO guestPO) {
		if (guestPO == null) {
			return null;
		}
		return new GuestVO(this.decode(guestPO));
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param userPO
	 *            来自本类userInfo载体
	 * @return GuestVO guestInfo载体
	 */
	private GuestPO convert(UserVO userVO) {
		if (userVO == null) {
			return null;
		}
		return this.encrypt(new GuestPO((GuestVO) userVO));
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param List<GuestPO>
	 *            来自本类所有guestInfo载体
	 * @return List<UserVO> 所有对应的userInfo载体
	 */
	private List<UserVO> convert(List<GuestPO> list) {
		List<UserVO> result = new ArrayList<UserVO>();
		for (int i = 0; i < list.size(); i++) {
			result.add(new GuestVO(this.decode(list.get(i))));
		}
		return result;
	}

	public boolean hasGuest(String guestID) { // 放在后面，该方法一般只在本类使用，可以等同private,只有member会用到
		
		try {
			UserVO guestVO = this.getSingle(guestID);
		} catch (UserInexistException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private GuestPO encrypt(GuestPO guestPO) {
		Ciphertext encrpyt = new Ciphertext();

		guestPO.setName(encrpyt.encrypt(guestPO.getName()));
		guestPO.setPassword(encrpyt.encrypt(guestPO.getPassword()));
		guestPO.setPhone(encrpyt.encrypt(guestPO.getPhone()));

		return guestPO;
	}

	private GuestPO decode(GuestPO guestPO) {
		Ciphertext decode = new Ciphertext();

		guestPO.setName(decode.decode(guestPO.getName()));
		guestPO.setPassword(decode.decode(guestPO.getPassword()));
		guestPO.setPhone(decode.decode(guestPO.getPhone()));

		return guestPO;
	}

}
