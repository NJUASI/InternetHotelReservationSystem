package businessLogic.hotelBL.stub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import businessLogicService.hotelBLService.HotelBLService;
import utilities.ResultMessage;
import utilities.SortStrategy;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.RoomInfoVO;

public class HotelBLService_Stub implements HotelBLService{

	public HotelBLService_Stub() {

	}

//	public ResultMessage updateEvaluation(EvaluationVO evaluationVO) {
//		return ResultMessage.SUCCESS;
//	}


	public HotelVO getHotelInfo(String userID) {
		return new HotelVO("12345678","thisHotel", "NanJing", "center", "address", "4" ,
				5,123,"good","allEquipment");
	}


	public ResultMessage updateHotelInfo(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public Iterator<RoomInfoVO> getHotelRoomInfo(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateHotelRoomInfo(RoomInfoVO roomInfoVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage updateCheckIn(CheckInVO checkInVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage updateCheckOut(CheckOutVO checkOutVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<HotelEvaluationVO> getEvaluations(String hotelID) {
		// TODO 自动生成的方法存根
		return null;
	}

	
	
	@Override
	public Iterator<HotelVO> getHotels(String city,String circle) {
		List<HotelVO> list = new ArrayList<HotelVO>();
		list.add(new HotelVO("12345678","thisHotel", "NanJing", "center", "address", "4" ,
				5,123,"good","allEquipment"));
		list.add(new HotelVO("12345678","thisHotel", "NanJing", "center", "address", "4" ,
				5,123,"good","allEquipment"));
		return list.iterator();
	}

	@Override
	public Iterator<HotelVO> sortHotels(SortStrategy sortStrategy) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	@Override
	public Iterator<HotelVO> searchHotels(List<SearchCriteria> searchCriteria) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage updateHotelRoomInfo(RoomInfoVO roomInfoVO, String roomType) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addHotel(HotelVO hotelVO) {
		// TODO 自动生成的方法存根
		return null;
	}

}
