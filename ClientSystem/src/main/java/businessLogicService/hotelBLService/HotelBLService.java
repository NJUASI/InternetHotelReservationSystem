package businessLogicService.hotelBLService;

import java.util.Iterator;
import java.util.List;

import utilities.enums.ResultMessage;
import utilities.enums.RoomType;
import utilities.enums.SearchCriteriaType;
import utilities.enums.SortStrategy;
import vo.HotelVO;
import vo.RoomInfoVO;
import vo.SearchCriteriaVO;

public interface HotelBLService {

	public HotelVO getHotelInfo (String hotelID);

	public ResultMessage updateHotelInfo (HotelVO hotelVO);
	
	public ResultMessage addHotel (HotelVO hotelVO);
	
	public ResultMessage checkInOffline (String hotelID,RoomType RoomType,int roomNum);
	
	public ResultMessage checkOutOffline (String hotelID,RoomType RoomType,int roomNum);

	public Iterator<RoomInfoVO> getHotelRoomInfo (String hotelID);

	public ResultMessage updateHotelRoomInfo (RoomInfoVO roomInfoVO);
	
	public int getRemainRoomNum(String hotelID,RoomType roomType);
	
	public double getOriginPrice(String hotelID, RoomType roomType);
	
	public void setGuestID(String guestID);
	
	public Iterator<HotelVO> getHotels(String city,String circle);
	
	public Iterator<HotelVO> sortHotels(SortStrategy sortStategy);
	
	public Iterator<HotelVO> searchHotels(List<SearchCriteriaType> searchCriteriaTypes,SearchCriteriaVO vo);
	
}
