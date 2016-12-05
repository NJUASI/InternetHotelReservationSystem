package dataService.hotelDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.HotelPO;
import po.RoomInfoPO;
import utilities.ResultMessage;

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

	//因为可能会修改名字，为了能够找到数据并修改，必须传入原名字的参数
	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO,String oldRoomType) throws RemoteException;

	public ResultMessage addRoomInfo(RoomInfoPO roomInfoPO) throws RemoteException;

	public ResultMessage deleteRoomInfo(String hotelID, String roomType) throws RemoteException;

}
