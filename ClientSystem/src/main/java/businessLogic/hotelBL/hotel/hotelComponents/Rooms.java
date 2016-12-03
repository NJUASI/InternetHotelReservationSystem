package businessLogic.hotelBL.hotel.hotelComponents;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataService.hotelDataService.HotelDataService;
import po.RoomInfoPO;
import utilities.ResultMessage;
import vo.RemainRoomInfoVO;
import vo.RoomInfoVO;

public class Rooms {
	private List<RoomInfoPO> roomInfoPOList;
	private String hotelID;
	private RemainRooms remainRooms;
	private HotelDataService hotelDataService;

	public Rooms(String hotelID, HotelDataService hotelDataService) {
		this.hotelDataService = hotelDataService;
		this.hotelID = hotelID;
		initRooms();

	}

	private void initRooms() {
		initRoomInfoPoList();
		initRemainRooms(hotelID,hotelDataService);
	}

	private void initRemainRooms(String hotelID, HotelDataService hotelDataService) {
		remainRooms = new RemainRooms(hotelID,hotelDataService);
	}

	private void initRoomInfoPoList() {
		try {
			roomInfoPOList = hotelDataService.getHotelRoomInfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public Iterator<RemainRoomInfoVO> getRemainRooms(){
		return remainRooms.getRemainRooms();
	}

	public ResultMessage updataRemainRooms(List<RemainRoomInfoVO> remainRoomInfoVOList){
		return remainRooms.updataRemainRooms(remainRoomInfoVOList);
	}

	public Iterator<RoomInfoVO> getRoomInfo(){
		List<RoomInfoVO> roomInfoVOList = new ArrayList<RoomInfoVO>();

		for(RoomInfoPO roomInfoPO:roomInfoPOList){
			roomInfoVOList.add(new RoomInfoVO(roomInfoPO));
		}

		return roomInfoVOList.iterator();
	}

	public ResultMessage updateHotelRoomInfo(List<RoomInfoVO> roomInfoVOList) {

		for(RoomInfoVO roomInfoVO: roomInfoVOList){
			roomInfoPOList.add(new RoomInfoPO(roomInfoVO));
		}
		try {
			return hotelDataService.updateHotelRoomInfo(roomInfoPOList);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}


}
