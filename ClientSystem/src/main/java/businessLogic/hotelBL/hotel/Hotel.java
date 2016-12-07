package businessLogic.hotelBL.hotel;

import java.rmi.RemoteException;
import java.util.Iterator;

import businessLogic.hotelBL.HotelInfoOperation;
import dataService.hotelDataService.HotelDataService;
import dataService.hotelDataService.HotelDataService_Stub;
import po.HotelPO;
import utilities.Address;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.HotelVO;
import vo.RoomInfoVO;


/**
 * @Description:对于单个酒店的基本操作：
 * 获取、更新酒店详细信息、客房信息，增加客房信息
 * @author:Harvey Gong
 * @time:2016年12月3日 下午9:52:10
 */
public class Hotel implements HotelInfoOperation{

	private HotelDataService hotelDataService;
	private HotelPO hotelPO;
	private String hotelID;
	private Rooms rooms;

	public Hotel(String hotelWorkerID) {
		this.hotelID = hotelWorkerID;
		initHotel();
	}
	
	public Hotel() {
		initHotelDataService();
		initRooms();
	}

	private void initHotel() {
		initHotelDataService();
		initHotelPO();
		initRooms();
	}

	private void initRooms() {
		rooms = new Rooms();
	}

	private void initHotelPO() {
		try {
			hotelPO = hotelDataService.getHotelInfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void initHotelDataService() {
//		hotelDataService = ClientRemoteHelper.getInstance().getHotelDataService();
		try {
			hotelDataService = new HotelDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
		try {
			HotelPO hotelPO = hotelDataService.getHotelInfo(hotelID);
			return new HotelVO(hotelPO);
		} catch (RemoteException e) {
			return null;
		}
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
		return rooms.getRoomInfo(hotelWorkerID);
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
	public ResultMessage deleteRoomInfo(String hotelID,String roomType){
		return rooms.deleteRoomInfo(hotelID,roomType);
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
	 * @Description:委托给Rooms，获取该酒店房间的最低价格
	 * @return
	 * double
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午7:25:02
	 */
	public double getLowestPrice(){
		return rooms.getLowestPrice();
	}

	/**
	 * @Description:获取当前所选房型的剩余房间数量
	 * @param roomType
	 * @return
	 * int
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午7:31:07
	 */
	public int getRemainNumOfSpecificType(String roomType){
		return rooms.getRemainNumOfSpecificType(roomType);
	}

	/**
	 * 方便测试用，严格来说不能暴露，后期删除
	 * @return
	 */
	public HotelPO getHotelPO(){
		return hotelPO;
	}

	@Override
	public Address getHotelAddress(){
		return new Address(hotelPO.getCity(), hotelPO.getCircle());
	}

	/**
	 * @Description:当有该酒店的订单的评价时，更新酒店的评分
	 * @param score
	 * @return
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月6日 上午11:11:51
	 */
	@Override
	public ResultMessage scoreUpdate(double score) {
		int commentsNum = hotelPO.getCommentsNum();
		hotelPO.setScore((commentsNum*hotelPO.getScore()+score)/commentsNum+1);
		return updateHotelInfo(new HotelVO(hotelPO));
	}

	@Override
	public Iterator<RoomType> getRoomType(){
		return rooms.getRoomType();
	}

	public int getRemainRoomNum(String hotelID) {
		return rooms.getRemainRoomNum();
	}
}