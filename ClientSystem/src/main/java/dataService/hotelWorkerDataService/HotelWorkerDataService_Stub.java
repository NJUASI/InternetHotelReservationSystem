package dataService.hotelWorkerDataService;

import java.util.ArrayList;
import java.util.List;

import po.HotelWorkerPO;
import utilities.ResultMessage;

public class HotelWorkerDataService_Stub implements HotelWorkerDataService{

	
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
