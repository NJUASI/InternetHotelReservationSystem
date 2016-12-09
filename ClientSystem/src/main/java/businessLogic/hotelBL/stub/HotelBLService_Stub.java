package businessLogic.hotelBL.stub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogicService.hotelBLService.HotelBLService;
import utilities.ResultMessage;
import utilities.RoomType;
import utilities.SearchCriteriaType;
import utilities.SortStrategy;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.RoomInfoVO;
import vo.SearchCriteriaVO;

public class HotelBLService_Stub implements HotelBLService{

	public HotelBLService_Stub() {

	}

	public HotelVO getHotelInfo(String userID) {
		return new HotelVO("12345678","thisHotel", "南京", "center", "address", "4" ,
				5,123,"good","allEquipment");
	}


	public ResultMessage updateHotelInfo(HotelVO hotelVO) {
		return null;
	}


	public Iterator<RoomInfoVO> getHotelRoomInfo(String userID) {
		return null;
	}

	public ResultMessage updateHotelRoomInfo(RoomInfoVO roomInfoVO) {
		return null;
	}


	public ResultMessage updateCheckIn(CheckInVO checkInVO) {
		return null;
	}


	public ResultMessage updateCheckOut(CheckOutVO checkOutVO) {
		return null;
	}

	public Iterator<HotelEvaluationVO> getEvaluations(String hotelID) {
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
		return null;
	}
	
	@Override
	public Iterator<HotelVO> searchHotels(List<SearchCriteriaType> searchCriteriaTypes, SearchCriteriaVO vo) {
		return null;
	}

	@Override
	public ResultMessage addHotel(HotelVO hotelVO) {
		return null;
	}

	@Override
	public ResultMessage checkInOffline(String hotelID, RoomType RoomName, int roomNum) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage checkOutOffline(String hotelID, RoomType RoomName, int roomNum) {
		// TODO 自动生成的方法存根
		return null;
	}


}
