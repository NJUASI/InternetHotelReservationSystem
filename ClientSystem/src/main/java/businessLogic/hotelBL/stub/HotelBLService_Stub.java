package businessLogic.hotelBL.stub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import businessLogicService.hotelBLService.HotelBLService;
import utilities.Operation;
import utilities.ResultMessage;
import utilities.RoomType;
import utilities.SortStrategy;
import vo.AddressVO;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.HotelEvaluationVO;
import vo.HotelGeneralVO;
import vo.HotelVO;
import vo.RemainRoomInfoVO;
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


	public ResultMessage updateHotelRoomInfo(List<RoomInfoVO> list) {
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


	public Iterator<RemainRoomInfoVO> getRemainRoomInfo(String userID) {
		List<RemainRoomInfoVO> list = new LinkedList<RemainRoomInfoVO>();
		list.add(new RemainRoomInfoVO("12345678", RoomType.SINGLE_BED, 13, 200));
		list.add(new RemainRoomInfoVO("12345678", RoomType.DOUBLE_BED, 6, 300));
		return list.iterator();
	}


	public ResultMessage updateRemainRoomInfo(String hotelID, Operation operation, Map<RoomType, Integer> roomInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<HotelEvaluationVO> getEvaluations(String hotelID) {
		// TODO 自动生成的方法存根
		return null;
	}

	
	
	@Override
	public Iterator<HotelGeneralVO> getHotels(AddressVO addressVO) {
		List<HotelGeneralVO> list = new ArrayList<HotelGeneralVO>();
		list.add(new HotelGeneralVO("12345678", "thisHotel", "NanJing", "center", "4", 5, 123));
		list.add(new HotelGeneralVO("12345678", "thisHotel", "NanJing", "center", "4", 5, 123));
		return list.iterator();
	}

	@Override
	public Iterator<HotelGeneralVO> sortHotels(SortStrategy sortStrategy) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	@Override
	public Iterator<HotelGeneralVO> getBookedHotels() {
		// TODO 自动生成的方法存根
		return null;
	}
	
	@Override
	public Iterator<HotelGeneralVO> searchHotels(List<SearchCriteria> searchCriteria) {
		// TODO 自动生成的方法存根
		return null;
	}

}
