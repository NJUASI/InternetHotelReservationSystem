package businessLogic.hotelBL.hotel;

import java.rmi.RemoteException;
import java.util.Iterator;


import dataService.hotelDataService.HotelDataService;
import dataService.hotelDataService.HotelDataService_Stub;
import po.CheckInPO;
import po.CheckOutPO;
import po.HotelPO;
import utilities.Address;
import utilities.ResultMessage;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.RoomInfoVO;

/**
 * @Description:TODO
 * @author:Harvey Gong
 * @time:2016年12月3日 下午9:52:08
 */
/**
 * @Description:TODO
 * @author:Harvey Gong
 * @time:2016年12月3日 下午9:52:10
 */
public class Hotel{

	private HotelDataService hotelDataService;
	private HotelPO hotelPO;
	private String hotelID;
	private Rooms rooms;
	private Evaluations evaluations;

	public Hotel() {

	}

	public Hotel(String hotelWorkerID) {
		this.hotelID = hotelWorkerID;
		initHotel();
	}

	private void initHotel() {
		initHotelDataService();
		initHotelPO();
		initRooms();
		initEvaluations();
	}

	private void initEvaluations() {
		evaluations = new Evaluations(hotelID);
	}

	private void initRooms() {
		rooms = new Rooms(hotelID);
	}

	private void initHotelPO() {
		try {
			hotelPO = hotelDataService.getHotelInfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void initHotelDataService() {
		hotelDataService = new HotelDataService_Stub();
	}


	/**
	 * @Description:根据酒店工作人员id获取酒店的基本信息
	 * @param hotelWorkerID
	 * @return
	 * HotelVO
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:44:37
	 */
	public HotelVO getHotelInfo(String hotelWorkerID) {
		return new HotelVO(hotelPO);
	}

	/**
	 * @Description:更新酒店基本信息
	 * @param hotelVO
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:49:19
	 */
	public ResultMessage updateHotelInfo(HotelVO hotelVO) {

		hotelPO = new HotelPO(hotelVO);
		try {
			return hotelDataService.updateHotelInfo(hotelPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}

	/**
	 * @Description:添加新的酒店
	 * @param hotelVO
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:49:40
	 */
	public ResultMessage addHotelInfo(HotelVO hotelVO){
		hotelPO = new HotelPO(hotelVO);

		try {
			return hotelDataService.addHotelInfo(hotelPO);
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}

	}


	/**
	 * @Description:委托给room，获取客房信息
	 * @param hotelWorkerID
	 * @return
	 * Iterator<RoomInfoVO>
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:49:59
	 */
	public Iterator<RoomInfoVO> getHotelRoomInfo(String hotelWorkerID) {
		return rooms.getRoomInfo();
	}
	
	/**
	 * @Description:委托给room，增加一条客房信息
	 * @param roomInfoVO
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午3:13:09
	 */
	public ResultMessage addRoomInfo(RoomInfoVO roomInfoVO){
		return rooms.addRoomInfo(roomInfoVO);
	}
	
	/**
	 * @Description:委托给room，删除一条客房信息
	 * @param roomType
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午3:14:25
	 */
	public ResultMessage deleteRoomInfo(String roomType){
		return rooms.deleteRoomInfo(roomType);
	}

	/**
	 * @Description:委托给room，更新客房信息
	 * @param roomInfoVOList
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:50:41
	 */
	public ResultMessage updateHotelRoomInfo(RoomInfoVO roomInfoVO,String oldRoomType) {
		return rooms.updateHotelRoomInfo(roomInfoVO,oldRoomType);
	}


	/**
	 * @Description:更新入住信息
	 * @param checkInVO
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:51:02
	 */
	public ResultMessage updateCheckIn(CheckInVO checkInVO) {
		// TODO
		CheckInPO checkInPO = new CheckInPO(checkInVO);
		try {
			return hotelDataService.updateCheckInInfo(checkInPO);
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}

	/**
	 * @Description:更新退房信息
	 * @param checkOutVO
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:51:13
	 */
	public ResultMessage updateCheckOut(CheckOutVO checkOutVO) {
		// TODO
		CheckOutPO checkOutPO = new CheckOutPO(checkOutVO);
		try {
			return hotelDataService.updateCheckOutInfo(checkOutPO);
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}


	/**
	 * @Description:委托给evaluations，获取对该酒店的所有评价
	 * @return
	 * Iterator<HotelEvaluationVO>
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:53:05
	 */
	public Iterator<HotelEvaluationVO> getEvaluations(){
		return evaluations.getEvaluations();
	}

	//	public ResultMessage updateEvaluation(EvaluationVO evaluationVO) {
	//		return evaluations.addEvaluation(evaluationVO);
	//	}

	/**
	 * @Description:对外的接口，能够通过酒店的id获取酒店所在的城市商圈
	 * @param hotelID
	 * @return
	 * Address
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:54:07
	 */
	public Address getHotelAddress(String hotelID){
		this.hotelID = hotelID;
		initHotelPO();
		return new Address(hotelPO.getCity(), hotelPO.getCircle());
	}


	/**
	 * 方便测试用，严格来说不能暴露，后期删除
	 * @return
	 */
	public HotelPO getHotelPO(){
		return hotelPO;
	}
}