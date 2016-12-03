package dataService.hotelDataService;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import po.CheckInPO;
import po.CheckOutPO;
import po.HotelEvaluationPO;
import po.HotelGeneralPO;
import po.HotelPO;
import po.RemainRoomInfoPO;
import po.RoomInfoPO;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.AddressVO;

public class HotelDataService_Stub implements HotelDataService  {
	
	
	public HotelPO getHotelInfo(String hotelID) {
		return new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,123,"good", "allEquipment");
	}

	
	public ResultMessage updateHotelInfo(HotelPO hotelInfoPO) {
		return ResultMessage.SUCCESS;
	}

	
	public List<RoomInfoPO> getHotelRoomInfo(String hotelID) {
		List<RoomInfoPO> list = new ArrayList<RoomInfoPO>();
		list.add(new RoomInfoPO("123", RoomType.AMBASSADOR, 1, 100));
		return list;
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

	
	public List<RemainRoomInfoPO> getRemainRoomInfo(String hotelID) {
		List<RemainRoomInfoPO> list = new ArrayList<RemainRoomInfoPO>();
		list.add(new RemainRoomInfoPO("12345678", RoomType.AMBASSADOR, 2, 200));
		return list;
	}

	public ResultMessage updateRemainRoomInfo(RemainRoomInfoPO remainRoomPO) throws RemoteException {
		return null;
	}	

	public HotelPO getHotelDetail(String hotelID) {
		return new HotelPO("12345678", "thisHotel", "NanJing", "center", "address", "4",
				5,123,"good", "allEquipment");
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
	public List<HotelGeneralPO> getHotelGeneralList(AddressVO addressVO) {
		List<HotelGeneralPO> list = new ArrayList<HotelGeneralPO>();
		list.add(new HotelGeneralPO("12345678","rujia","Nanjing","xianlin","4",5,123));
		list.add(new HotelGeneralPO("12345678","ruji","Nanjing","xianlin","3",4,124));
		list.add(new HotelGeneralPO("12345679","ruja","Nanjing","xianlin","2",3,125));
		return list;
	}

}
