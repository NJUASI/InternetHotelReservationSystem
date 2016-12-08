package dataService.hotelDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.HotelPO;
import po.RoomInfoPO;
import utilities.ResultMessage;
import utilities.RoomType;

public class HotelDataService_Stub extends UnicastRemoteObject implements HotelDataService  {
	
	public HotelDataService_Stub() throws RemoteException {
		super();
	}

	@Override
	public List<HotelPO> getHotels(String city,String circle) {
		List<HotelPO> list = new ArrayList<HotelPO>();
		list.add(new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "5",
				3,"good", "allEquipment",5));
		list.add(new HotelPO("12345677", "thisHotel", "NanJing", "center", "address", "4",
				4,"good", "allEquipment",4));
		list.add(new HotelPO("12345676", "thisHotel", "NanJing", "center", "address", "3",
				5,"good", "allEquipment",4));
		return list;
	}
	
	public HotelPO getHotelInfo(String hotelID) {
		return new HotelPO("12345678", "thisHotel", "南京", "仙林中心", "115号", "4",
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
		List<RoomInfoPO> list = new ArrayList<RoomInfoPO>();
		list.add(new RoomInfoPO("12345678",RoomType.单人间,1,0,100));
		list.add(new RoomInfoPO("12345678",RoomType.双人间,1,1,300));
		list.add(new RoomInfoPO("12345678",RoomType.三人间,1,0,300));
		list.add(new RoomInfoPO("12345678",RoomType.商务套房,1,1,400));
		list.add(new RoomInfoPO("12345678",RoomType.总统套房,1,0,500));
		return list;
	}


	@Override
	public ResultMessage addRoomInfo(RoomInfoPO roomInfoPO) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addHotelInfo(HotelPO hotelPO) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteRoomInfo(String hotelID, RoomType roomType) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

}
