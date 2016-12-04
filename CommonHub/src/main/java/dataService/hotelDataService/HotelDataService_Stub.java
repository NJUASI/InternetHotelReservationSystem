package dataService.hotelDataService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.HotelPO;
import po.RoomInfoPO;
import utilities.ResultMessage;

public class HotelDataService_Stub implements HotelDataService  {
	
	@Override
	public List<HotelPO> getHotels(String city,String circle) {
		List<HotelPO> list = new ArrayList<HotelPO>();
		list.add(new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,"good", "allEquipment",5));
		list.add(new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,"good", "allEquipment",4));
		return list;
	}
	
	public HotelPO getHotelInfo(String hotelID) {
		return new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,"good", "allEquipment",5);
	}
	
	public ResultMessage updateHotelInfo(HotelPO hotelInfoPO) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage updateHotelRoomInfo(List<RoomInfoPO> list) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<RoomInfoPO> getRoomInfo(String hotelID) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO, String oldRoomType) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public ResultMessage addRoomInfo(RoomInfoPO roomInfoPO) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public ResultMessage deleteRoomInfo(String hotelID, String roomType) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public ResultMessage addHotelInfo(HotelPO hotelPO) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
