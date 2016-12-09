package businessLogicService.hotelBLService;

import java.util.Iterator;
import java.util.List;

import utilities.ResultMessage;
import utilities.RoomType;
import utilities.SearchCriteriaType;
import utilities.SortStrategy;
import vo.HotelVO;
import vo.RoomInfoVO;
import vo.SearchCriteriaVO;

public interface HotelBLService {

	public HotelVO getHotelInfo (String hotelID);

	public ResultMessage updateHotelInfo (HotelVO hotelVO);
	
	public ResultMessage addHotel (HotelVO hotelVO);
	
	public ResultMessage checkInOffline (String hotelID,RoomType RoomName,int roomNum);
	
	public ResultMessage checkOutOffline (String hotelID,RoomType RoomName,int roomNum);

	public Iterator<RoomInfoVO> getHotelRoomInfo (String hotelID);

	public ResultMessage updateHotelRoomInfo (RoomInfoVO roomInfoVO);
	
	public Iterator<HotelVO> getHotels(String city,String circle);
	
	public Iterator<HotelVO> sortHotels(SortStrategy sortStategy);
	
	public Iterator<HotelVO> searchHotels(List<SearchCriteriaType> searchCriteriaTypes,SearchCriteriaVO vo);
	
}
