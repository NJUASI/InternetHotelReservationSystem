package dataService.hotelWorkerDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.HotelWorkerPO;
import utilities.ResultMessage;

public class HotelWorkerDataService_Stub extends UnicastRemoteObject implements HotelWorkerDataService{

	
	public HotelWorkerDataService_Stub() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}


	public HotelWorkerPO getSingleHotelWorker(String hotelWorkerID) {
		return new HotelWorkerPO("00001111", "123456","school");
	}

	
	public List<HotelWorkerPO> getAllHotelWorker() {
		List<HotelWorkerPO>  list= new ArrayList<HotelWorkerPO>();
		HotelWorkerPO b= new HotelWorkerPO("00001111", "123456","school");
		list.add(b);
		return list;
	}
	
	
	public ResultMessage add(HotelWorkerPO newHotelWorkerPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage modify(HotelWorkerPO hotelWorkerPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage initHotelWorker(String hotelWorkerID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
