package dataService.hotelDataService;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import po.CheckInPO;
import po.CheckOutPO;
import po.HotelEvaluationPO;
import po.HotelPO;
import po.RoomInfoPO;
import utilities.ResultMessage;
import utilities.RoomType;

public class HotelDataService_Stub implements HotelDataService  {
	
	
	public HotelPO getHotelInfo(String hotelID) {
		return new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,"good", "allEquipment");
	}

	
	public ResultMessage updateHotelInfo(HotelPO hotelInfoPO) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage updateHotelRoomInfo(List<RoomInfoPO> list) {
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage updateCheckInInfo(CheckInPO checkInInfo) {
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage updateCheckOutInfo(CheckOutPO checkOutInfo) {
		return ResultMessage.SUCCESS;
	}

	public HotelPO getHotelDetail(String hotelID) {
		return new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,"good", "allEquipment");
	}
	
//	public ResultMessage addEvaluation(EvaluationPO evaluationPO) {
//		return ResultMessage.SUCCESS;
//	}


	public List<HotelEvaluationPO> getEvaluations(String hotelID) {
		List<HotelEvaluationPO> list =  new ArrayList<HotelEvaluationPO>();
		list.add(new HotelEvaluationPO("1234567890", LocalDate.of(2016, 11, 21), 4.5, "good"));
		return list;
	}

//	public ResultMessage updateEvaluation(EvaluationPO evaluationPO) throws RemoteException {
//		return ResultMessage.SUCCESS;
//	}


	@Override
	public List<HotelPO> getHotels(String city,String circle) {
		List<HotelPO> list = new ArrayList<HotelPO>();
		list.add(new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,"good", "allEquipment"));
		list.add(new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,"good", "allEquipment"));
		list.add(new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,"good", "allEquipment"));
		return list;
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
