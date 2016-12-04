package dataService.hotelWorkerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.HotelWorkerPO;
import utilities.ResultMessage;

public interface HotelWorkerDataService extends Remote{

	public HotelWorkerPO getSingleHotelWorker(String hotelWorkerID) throws RemoteException;
	
	public List<HotelWorkerPO> getAllHotelWorker() throws RemoteException;
	
	public ResultMessage add(HotelWorkerPO newHotelWorkerPO) throws RemoteException;

	public ResultMessage modify(HotelWorkerPO hotelWorkerPO) throws RemoteException;
	
	public ResultMessage initHotelWorker(String hotelWorkerID) throws RemoteException;


}
