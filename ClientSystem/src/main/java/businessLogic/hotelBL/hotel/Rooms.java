package businessLogic.hotelBL.hotel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataService.hotelDataService.HotelDataService;
import dataService.hotelDataService.HotelDataService_Stub;
import po.RoomInfoPO;
import utilities.ResultMessage;
import vo.RoomInfoVO;

public class Rooms {
	private List<RoomInfoPO> roomInfoPOList;
	private String hotelID;
	private HotelDataService hotelDataService;

	public Rooms(String hotelID) {
		this.hotelDataService = new HotelDataService_Stub();
		this.hotelID = hotelID;
		initRooms();
	}

	private void initRooms() {
		try {
			roomInfoPOList = hotelDataService.getRoomInfo(hotelID);
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
			return hotelDataService.addRoomInfo(new RoomInfoPO(roomInfoVO));
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
			return hotelDataService.deleteRoomInfo(hotelID,roomType);
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
			return hotelDataService.updateRoomInfo(new RoomInfoPO(roomInfoVO),oldRoomType);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
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
		initRooms();
		double min = roomInfoPOList.get(0).getPrice();
		for(int i = 1;i<roomInfoPOList.size();i++){
			if(min>roomInfoPOList.get(i).getPrice()){
				min = roomInfoPOList.get(i).getPrice();
			}
		}
		return min;
	}
}
