package dataService.roomInfoDataService;

import java.rmi.RemoteException;
import java.util.List;

import po.RoomInfoPO;
import utilities.ResultMessage;

public class RoomInfoDataService_stub implements RoomInfoDataService {

	@Override
	public List<RoomInfoPO> getRoomInfo(String hotelID) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO,String oldRoomType) throws RemoteException {
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

}
