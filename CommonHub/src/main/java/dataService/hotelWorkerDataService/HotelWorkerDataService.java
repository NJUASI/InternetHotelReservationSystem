package dataService.hotelWorkerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import exception.verificationException.UserInexistException;
import po.HotelWorkerPO;
import utilities.enums.ResultMessage;

public interface HotelWorkerDataService extends Remote{

	public HotelWorkerPO getSingleHotelWorker(String hotelWorkerID) throws RemoteException, UserInexistException;
	
	public List<HotelWorkerPO> getAllHotelWorker() throws RemoteException;
	
	public HotelWorkerPO add(HotelWorkerPO newHotelWorkerPO) throws RemoteException;

	public ResultMessage modify(HotelWorkerPO hotelWorkerPO) throws RemoteException;
	
	public ResultMessage initHotelWorker(String hotelWorkerID) throws RemoteException;


}
