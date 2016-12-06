package businessLogic.hotelBL.hotel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataService.hotelDataService.HotelDataService;
import dataService.hotelDataService.HotelDataService_Stub;
import po.RoomInfoPO;
import utilities.Operation;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.RoomInfoVO;

/**
 * @Description:对于一个酒店里面客房信息的基本操作，由Hotel委托，Rooms具体实现
 * @author:Harvey Gong
 * @time:2016年12月4日 下午7:17:05
 */
class Rooms {

	List<RoomInfoPO> roomInfoPOList;
	private String hotelID;
	private HotelDataService hotelDataService;

	public Rooms(String hotelID) {
		//		this.hotelDataService = ClientRemoteHelper.getInstance().getHotelDataService();
		try {
			hotelDataService = new HotelDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.hotelID = hotelID;
		initRoomInfoPO();
	}

	/**
	 * @Description:当Rooms初始化以及酒店客房信息被添加或者更新时，调用此方法，
	 * 获得最新的酒店客房信息
	 * void
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月6日 上午11:16:21
	 */
	private void initRoomInfoPO(){
		try {
			hotelDataService.getRoomInfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description:获得该酒店的所有客房信息
	 * @return
	 * Iterator<RoomInfoVO>
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 上午10:59:13
	 */
	public Iterator<RoomInfoVO> getRoomInfo(){
		List<RoomInfoVO> roomInfoVOList = new ArrayList<RoomInfoVO>();

		for(RoomInfoPO roomInfoPO:roomInfoPOList){
			roomInfoVOList.add(new RoomInfoVO(roomInfoPO));
		}
		return roomInfoVOList.iterator();
	}

	/**
	 * @Description:为该酒店添加新的客房信息
	 * @param roomInfoVO
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 上午11:16:09
	 */
	public ResultMessage addRoomInfo(RoomInfoVO roomInfoVO){

		try {
			hotelDataService.addRoomInfo(new RoomInfoPO(roomInfoVO));
			initRoomInfoPO();
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}

	/**
	 * @Description:删除一条客房信息
	 * @param roomType
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 上午11:21:31
	 */
	public ResultMessage deleteRoomInfo(String roomType){

		try {
			hotelDataService.deleteRoomInfo(hotelID,roomType);
			initRoomInfoPO();
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}

	/**
	 * @Description:更新一条hotel的客房信息
	 * @param roomInfoVO
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 上午11:03:24
	 */
	public ResultMessage updateHotelRoomInfo(RoomInfoVO roomInfoVO,String oldRoomType) {

		try {
			hotelDataService.updateRoomInfo(new RoomInfoPO(roomInfoVO),oldRoomType);
			initRoomInfoPO();
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	/**
	 * @Description:当入住或退房时，调用此方法，更新该房型的剩余房间数量，线上线下均调用此方法
	 * @param roomType
	 * @param operationedNum
	 * @param operation
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午8:05:19
	 */
	public ResultMessage updateRemainRoomNum(String roomType,int operationedNum,Operation operation){
		RoomInfoPO po = roomInfoPOList.get(findPO(roomType));
		if(operation == Operation.CHECK_IN){
			po.setRemainNum(po.getRemainNum()- operationedNum);
		}
		else
		{
			po.setRemainNum(po.getRemainNum()+ operationedNum);
		}
		return updateHotelRoomInfo(new RoomInfoVO(po),roomType);
	}

	/**
	 * @Description:获得该酒店所有房间类型
	 * @return
	 * Iterator<String>
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午6:53:53
	 */
	public Iterator<RoomType> getRoomType(){
		List<RoomType> allRoomType = new ArrayList<RoomType>();
		for(int i = 0;i<roomInfoPOList.size();i++){
			allRoomType.add(roomInfoPOList.get(i).getRoomType());
		}
		return allRoomType.iterator();
	}

	/**
	 * @Description:获取当前所选房间类型的剩余房间数量
	 * @param roomType
	 * @return
	 * int
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午7:20:02
	 */
	public int getRemainNumOfSpecificType(String roomName){
		for(int i = 0;i<roomInfoPOList.size();i++){
			if(roomInfoPOList.get(i).getRoomName().equals(roomName)){
				return roomInfoPOList.get(i).getRemainNum();
			}
		}
		return 0;
	}

	/**
	 * @Description:获取该酒店最低价格
	 * @return
	 * double
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午2:11:12
	 */
	public double getLowestPrice(){
		double min = roomInfoPOList.get(0).getPrice();
		for(int i = 1;i<roomInfoPOList.size();i++){
			if(min>roomInfoPOList.get(i).getPrice()){
				min = roomInfoPOList.get(i).getPrice();
			}
		}
		return min;
	}

	private int findPO(String roomType){
		for(int i = 0;i<roomInfoPOList.size();i++){
			if(roomInfoPOList.get(i).getRoomType().equals(roomType)){
				return i;
			}
		}
		return -1;
	}

	public int getRemainRoomNum() {
		int remainRoomNum = 0;
		for(int i = 0;i < roomInfoPOList.size();i++){
			remainRoomNum = remainRoomNum + roomInfoPOList.get(i).getRemainNum();
		}
		return 0;
	}
}
