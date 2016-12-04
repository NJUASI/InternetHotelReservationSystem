package businessLogic.hotelBL.hotel.hotelComponents;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataService.roomInfoDataService.RoomInfoDataService;
import dataService.roomInfoDataService.RoomInfoDataService_stub;
import po.RoomInfoPO;
import utilities.ResultMessage;
import vo.RoomInfoVO;

public class Rooms {
	private List<RoomInfoPO> roomInfoPOList;
	private String hotelID;
	private RoomInfoDataService roomInfoDataService;

	public Rooms(String hotelID) {
		this.roomInfoDataService = new RoomInfoDataService_stub();;
		this.hotelID = hotelID;
		initRooms();
	}

	private void initRooms() {
		initRoomInfoPoList();
	}

	private void initRoomInfoPoList() {
		try {
			roomInfoPOList = roomInfoDataService.getRoomInfo(hotelID);
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
			return roomInfoDataService.addRoomInfo(new RoomInfoPO(roomInfoVO));
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
			return roomInfoDataService.deleteRoomInfo(hotelID,roomType);
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}
	
	/**
	 * @Description:更新hotel的客房信息,更新一条
	 * @param roomInfoVO
	 * @return
	 * ResultMessage
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 上午11:03:24
	 */
	public ResultMessage updateHotelRoomInfo(RoomInfoVO roomInfoVO,String oldRoomType) {

		try {
			return roomInfoDataService.updateRoomInfo(new RoomInfoPO(roomInfoVO),oldRoomType);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
}
