package businessLogic.hotelBL.hotelScan.searchCriteria.searchCriteriaImpl;

import java.util.List;

import businessLogic.hotelBL.hotelScan.searchCriteria.SearchCriteria;
import utilities.RoomType;
import vo.HotelVO;

public class RoomTypeCriteria implements SearchCriteria {

	List<RoomType> roomTypes;

	public RoomTypeCriteria(List<RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}

	/**
	 * @Description:根据
	 * @param hotelGeneralVOList
	 * @return
	 * List<HotelGeneralVO>
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午7:07:01
	 */
	public List<HotelVO> meetCriteria(List<HotelVO> hotelVOList) {
		// TODO
//		HotelInfoOperation hotel;
//		for(int i = 0;i<hotelVOList.size();i++){
//			hotel = new Hotel(hotelVOList.get(i).hotelID);
//			List<RoomType> roomTypes = hotel.getRoomType();
//			if(!roomTypes.contains(roomTypes)){
//				hotelVOList.remove(i);
//			}
//		}
//		return hotelVOList;
		return null;
	}
	
}
