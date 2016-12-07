package businessLogic.userBL.userService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.userBL.userService.service.UserService;
import dataService.hotelWorkerDataService.HotelWorkerDataService;
import dataService.hotelWorkerDataService.HotelWorkerDataService_Stub;
import po.HotelWorkerPO;
import rmi.ClientRemoteHelper;
import utilities.ResultMessage;
import vo.HotelWorkerVO;
import vo.UserVO;

/**
 * 
 * @author Byron Dong
 * lastChangedBy Byron Dong
 * updateTime 2016/11/28
 *
 */
public class HotelWorker implements UserService{


	public static int IDLength = 8; // 酒店工作人员的ID长度为8

	private HotelWorkerDataService hotelWorkerDataService;

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * 构造函数，初始化成员变量
	 */
	public HotelWorker() {
//		hotelWorkerDataService = ClientRemoteHelper.getInstance().getHotelWorkerDataService();
		try {
			hotelWorkerDataService = new HotelWorkerDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param newUserVO 从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功添加酒店工作人员信息
	 */
	public UserVO add(UserVO newUserVO) {


		if(this.hasHotelWorker(newUserVO.userID)){return null;} //存在ID对应项

		try {
			HotelWorkerPO hotelWorkerPO = this.convert(newUserVO);
			return this.convert( hotelWorkerDataService.add(hotelWorkerPO));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param newUserVO 从userDoMain传下来的userInfo载体
	 * @return ResultMessage 用户是否成功修改酒店工作人员信息
	 */
	public ResultMessage modify(UserVO userVO) {

		ResultMessage msg = ResultMessage.USER_INFO_UPDATE_FAILURE;

		if(!this.hasHotelWorker(userVO.userID)){return msg;} //不存在ID对应项

		try {
			HotelWorkerPO hotelWorkerPO = this.convert(userVO);
			msg = hotelWorkerDataService.modify(hotelWorkerPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
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
		return null; //若不存在ID对应项，就返回null
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
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
		return null; //若不存在ID对应项，就返回null
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param  userID 从userDoMain传下来的指定用户ID
	 * @return String 指定用户 的登录信息
	 */
	public String getLogInInfo(String userID) {
		
		if(!this.hasHotelWorker(userID)){return null;} //不存在ID对应项，返回值后期细化

		try {
			return hotelWorkerDataService.getSingleHotelWorker(userID).getPassword();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null; //需要后期处理，是决定继续采用null，还是换其他
		}
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param  hotelWorkerPO 来自本类hotelWorkerInfo载体
	 * @return UserVO userInfo载体
	 */
	private UserVO convert(HotelWorkerPO hotelWorkerPO) {
		if(hotelWorkerPO ==null){return null;}
		return new HotelWorkerVO(hotelWorkerPO);
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/28
	 * @param  userPO 来自本类userInfo载体
	 * @return HotelWorkerVO hotelWorkerInfo载体
	 */
	private HotelWorkerPO convert(UserVO userVO) {
		if(userVO ==null){return null;}
		return new HotelWorkerPO((HotelWorkerVO) userVO);
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
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

	private boolean hasHotelWorker(String hotelWorkerID) {
		UserVO hotelWorkerVO = this.getSingle(hotelWorkerID);

		if(hotelWorkerVO==null){
			return false;
		}
		else{
			return true;
		}
	}

}
