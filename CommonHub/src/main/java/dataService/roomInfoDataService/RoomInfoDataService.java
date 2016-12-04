package dataService.roomInfoDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


import po.RoomInfoPO;
import utilities.ResultMessage;

public interface RoomInfoDataService extends Remote{

	public List<RoomInfoPO> getRoomInfo(String hotelID) throws RemoteException;

	//因为可能会修改名字，为了能够找到数据并修改，必须传入原名字的参数
	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO,String oldRoomType) throws RemoteException;

	public ResultMessage addRoomInfo(RoomInfoPO roomInfoPO) throws RemoteException;

	public ResultMessage deleteRoomInfo(String hotelID, String roomType) throws RemoteException;

}
