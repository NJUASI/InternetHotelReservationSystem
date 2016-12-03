package businessLogic.userBL.userService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.userBL.userService.service.CreditService;
import businessLogic.userBL.userService.service.UserService;
import dataService.guestDataService.GuestDataService;
import dataService.guestDataService.GuestDataService_Stub;
import po.CreditPO;
import po.GuestPO;
import utilities.ResultMessage;
import utilities.UserType;
import vo.CreditVO;
import vo.GuestVO;
import vo.UserVO;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * updateTime 2016/11/27
 *
 */
public class Guest implements UserService ,CreditService{

	
	private static int IDLength = 10; // 客户的ID长度为10

	private static UserType type = UserType.GUEST;

	private GuestDataService guestDataService;

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public Guest() {
		guestDataService = new GuestDataService_Stub();
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param newUserVO 从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功添加客户信息
	 */
	public ResultMessage add(UserVO newUserVO) {

		ResultMessage msg = ResultMessage.USER_ADD_FAILURE;

		try {
			GuestPO guestPO = this.convert(newUserVO);
			msg = guestDataService.add(guestPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param newUserVO 从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功修改客户信息
	 */
	public ResultMessage modify(UserVO userVO) {

		ResultMessage msg = ResultMessage.USER_INFO_UPDATE_FAILURE;

		try {
			GuestPO guestPO = this.convert(userVO);
			msg = guestDataService.modify(guestPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userVO 从userDoMain传下来的用户ID
	 * @return UserVO 单一guestInfo载体
	 */
	public UserVO getSingle(String userID) {

		try {
			return this.convert(guestDataService.getSingleGuest(userID));
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
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param  userID 从userDoMain传下来的指定用户ID
	 * @return String 指定用户 的登录信息
	 */
	public String getLogInInfo(String userID) {

		try {
			return guestDataService.getSingleGuest(userID).getPassword();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param guestID, creditNum从userDoMain传下来的指定客户ID和需修改的信用值
	 * @return ResultMessage 信用值是否添加成功
	 */
	public ResultMessage modifyCredit(String guestID, double creditNum) {

		ResultMessage msg = ResultMessage.FAIL;

		try {
			GuestPO guestPO = guestDataService.getSingleGuest(guestID);
			guestPO.setCredit(creditNum);
			msg = guestDataService.modify(guestPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param  guestID 从userDoMain传下来的指定用户ID
	 * @return List<CreditVO> 指定客户的所有creditInfo载体
	 */
	public List<CreditVO> getAllCreditDetail(String guestID) {

		List<CreditVO> result = new ArrayList<CreditVO>();

		try {
			List<CreditPO> list = guestDataService.getAllCreditDetail(guestID);
			for (int i = 0; i < list.size(); i++) {
				result.add(new CreditVO(list.get(i)));
			}
			return result;
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
	 * @return boolean 判断指定用户是否为客户类型
	 */
	public static boolean isGuest(int length) {
		if (Guest.IDLength == length) {
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
	 * @return boolean 判断指定用户是否为客户类型
	 */
	public static boolean isGuest(UserType type) {
		if (Guest.type == type) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  guestPO 来自本类guestInfo载体
	 * @return UserVO userInfo载体
	 */
	private UserVO convert(GuestPO guestPO) {
		return new GuestVO(guestPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  userPO 来自本类userInfo载体
	 * @return GuestVO guestInfo载体
	 */
	private GuestPO convert(UserVO userVO) {
		return new GuestPO((GuestVO) userVO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  List<GuestPO> 来自本类所有guestInfo载体
	 * @return List<UserVO> 所有对应的userInfo载体
	 */
	private List<UserVO> convert(List<GuestPO> list) {
		List<UserVO> result = new ArrayList<UserVO>();
		for (int i = 0; i < list.size(); i++) {
			result.add(new GuestVO(list.get(i)));
		}
		return result;
	}

}
