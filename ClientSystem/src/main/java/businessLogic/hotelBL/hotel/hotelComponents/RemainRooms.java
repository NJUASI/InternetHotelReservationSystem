package businessLogic.hotelBL.hotel.hotelComponents;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataService.hotelDataService.HotelDataService;
import po.RemainRoomInfoPO;
import utilities.ResultMessage;
import vo.RemainRoomInfoVO;

public class RemainRooms {
	private HotelDataService hotelDataService;
	private List<RemainRoomInfoPO> remainRoomInfoPOList; 
	private String hotelID;
	
	public RemainRooms(String hotelID, HotelDataService hotelDataService) {
		this.hotelID = hotelID;
		this.hotelDataService = hotelDataService;
		initRemainRoomInfoPOList();
	}

	private void initRemainRoomInfoPOList() {
		try {
			remainRoomInfoPOList = hotelDataService.getRemainRoomInfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public Iterator<RemainRoomInfoVO> getRemainRooms(){
		List<RemainRoomInfoVO> remainRoomInfoVOList = new ArrayList<RemainRoomInfoVO>();
		
		for(RemainRoomInfoPO remainRoomInfoPO:remainRoomInfoPOList){
			remainRoomInfoVOList.add(new RemainRoomInfoVO(remainRoomInfoPO));
		}
		
		return remainRoomInfoVOList.iterator();
	}
	
	public ResultMessage updataRemainRooms(List<RemainRoomInfoVO> remainRoomInfoVOList){
		// TODO
		return null;
	}
}
