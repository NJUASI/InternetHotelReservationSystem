package dataService.hotelDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.HotelPO;
import po.RoomInfoPO;
import utilities.enums.ResultMessage;
import utilities.enums.RoomType;

public interface HotelDataService extends Remote{

	public HotelPO getHotelInfo (String hotelID) throws RemoteException;
	
	public List<HotelPO> getHotels(String city, String circle) throws RemoteException;
	
	public ResultMessage updateHotelInfo(HotelPO hotelPO) throws RemoteException;
	
	public ResultMessage addHotelInfo(HotelPO hotelPO) throws RemoteException;

	/**
	 * @Description:提供修改roomInfo数据的方法，add、delete、update、get
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午1:57:07
	 */
	public List<RoomInfoPO> getRoomInfo(String hotelID) throws RemoteException;

	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO) throws RemoteException;

	public ResultMessage addRoomInfo(RoomInfoPO roomInfoPO) throws RemoteException;

	//暂时不用
	public ResultMessage deleteRoomInfo(String hotelID,RoomType roomType) throws RemoteException;

}
