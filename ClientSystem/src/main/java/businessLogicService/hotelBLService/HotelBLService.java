package businessLogicService.hotelBLService;

import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import utilities.ResultMessage;
import utilities.SortStrategy;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.RoomInfoVO;

public interface HotelBLService {

	public HotelVO getHotelInfo (String hotelWorkerID);

	public ResultMessage updateHotelInfo (HotelVO hotelVO);

	public Iterator<RoomInfoVO> getHotelRoomInfo (String hotelWorkerID);

	public ResultMessage updateHotelRoomInfo (RoomInfoVO roomInfoVO);

	public Iterator<HotelEvaluationVO> getEvaluations (String hotelID);

	public Iterator<HotelVO> getHotels(String city,String circle);
	
	public Iterator<HotelVO> sortHotels(SortStrategy sortStategy);
	
	public Iterator<HotelVO> searchHotels(List<SearchCriteria> searchCriteria);
	
}
