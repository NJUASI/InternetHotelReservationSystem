package businessLogicService.hotelBLService;

import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import utilities.ResultMessage;
import utilities.SortStrategy;
import vo.AddressVO;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.HotelEvaluationVO;
import vo.HotelGeneralVO;
import vo.HotelVO;
import vo.RemainRoomInfoVO;
import vo.RoomInfoVO;

public interface HotelBLService {

	public HotelVO getHotelInfo (String hotelWorkerID);

	public ResultMessage updateHotelInfo (HotelVO hotelVO);

	public Iterator<RoomInfoVO> getHotelRoomInfo (String hotelWorkerID);

	public ResultMessage updateHotelRoomInfo (List<RoomInfoVO> list);

	public ResultMessage updateCheckIn (CheckInVO checkInVO);

	public ResultMessage updateCheckOut (CheckOutVO checkOutVO);

	public Iterator<RemainRoomInfoVO> getRemainRoomInfo (String hotelWorkerID);
	
	public Iterator<HotelEvaluationVO> getEvaluations (String hotelID);

//	public ResultMessage updateEvaluation (EvaluationVO evaluationVO);	


	public Iterator<HotelGeneralVO>	getHotels(AddressVO addressVO);
	
	public Iterator<HotelGeneralVO> sortHotels(SortStrategy sortStategy);
	
	public Iterator<HotelGeneralVO> searchHotels(List<SearchCriteria> searchCriteria);
	
	public Iterator<HotelGeneralVO> getBookedHotels();
	
}
