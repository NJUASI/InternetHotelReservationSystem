package businessLogic.userBL.userService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.userBL.userService.service.UserService;
import dataService.hotelWorkerDataService.HotelWorkerDataService;
import dataService.hotelWorkerDataService.HotelWorkerDataService_Stub;
import po.HotelWorkerPO;
import utilities.ResultMessage;
import utilities.UserType;
import vo.HotelWorkerVO;
import vo.UserVO;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * updateTime 2016/11/28
 *
 */
public class HotelWorker implements UserService{

	
	private static int IDLength = 8; // 酒店工作人员的ID长度为8

	private static UserType type = UserType.HOTEL_WORKER;

	private HotelWorkerDataService hotelWorkerDataService;

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * 构造函数，初始化成员变量
	 */
	public HotelWorker() {
		hotelWorkerDataService = new HotelWorkerDataService_Stub();
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param newUserVO 从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功添加酒店工作人员信息
	 */
	public ResultMessage add(UserVO newUserVO) {

		ResultMessage msg = ResultMessage.USER_ADD_FAILURE;

		try {
			HotelWorkerPO hotelWorkerPO = this.convert(newUserVO);
			msg = hotelWorkerDataService.add(hotelWorkerPO);
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
	 * @return ResultMessage 用户是否成功修改酒店工作人员信息
	 */
	public ResultMessage modify(UserVO userVO) {

		ResultMessage msg = ResultMessage.USER_INFO_UPDATE_FAILURE;

		try {
			HotelWorkerPO hotelWorkerPO = this.convert(userVO);
			msg = hotelWorkerDataService.modify(hotelWorkerPO);
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
	 * @return UserVO 单一hotelWorkerInfo载体
	 */
	public UserVO getSingle(String userID) {

		try {
			return this.convert(hotelWorkerDataService.getSingleHotelWorker(userID));
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
	 * @return List<UserVO> 指定用户类型的所有hotelWorkerInfo载体
	 */
	public List<UserVO> getAll() {

		try {
			return this.convert(hotelWorkerDataService.getAllHotelWorker());
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
			return hotelWorkerDataService.getSingleHotelWorker(userID).getPassword();
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
	 * @return boolean 判断指定用户是否为酒店工作人员类型
	 */
	public static boolean isHotelWorker(int length) {
		if (HotelWorker.IDLength == length) {
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
	 * @return boolean 判断指定用户是否为酒店工作人员类型
	 */
	public static boolean isHotelWorker(UserType type) {
		if (HotelWorker.type == type) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  hotelWorkerPO 来自本类hotelWorkerInfo载体
	 * @return UserVO userInfo载体
	 */
	private UserVO convert(HotelWorkerPO hotelWorkerPO) {
		return new HotelWorkerVO(hotelWorkerPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  userPO 来自本类userInfo载体
	 * @return HotelWorkerVO hotelWorkerInfo载体
	 */
	private HotelWorkerPO convert(UserVO userVO) {
		return new HotelWorkerPO((HotelWorkerVO) userVO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param  List<HotelWorkerPO> 来自本类所有hotelWorkerInfo载体
	 * @return List<UserVO> 所有对应的userInfo载体
	 */
	private List<UserVO> convert(List<HotelWorkerPO> list) {
		List<UserVO> result = new ArrayList<UserVO>();
		for (int i = 0; i < list.size(); i++) {
			result.add(new HotelWorkerVO(list.get(i)));
		}
		return result;
	}

}
