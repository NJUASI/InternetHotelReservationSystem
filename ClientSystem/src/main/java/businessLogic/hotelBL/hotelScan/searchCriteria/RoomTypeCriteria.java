package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.HotelInfoOperation;
import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.hotelBL.hotelScan.SearchCriteria;
import vo.HotelVO;

public class RoomTypeCriteria implements SearchCriteria {

	String roomType;

	public RoomTypeCriteria(String roomType) {
		this.roomType = roomType;
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
		HotelInfoOperation hotel;
		for(int i = 0;i<hotelVOList.size();i++){
			hotel = new Hotel(hotelVOList.get(i).hotelID);
			List<String> roomTypes = hotel.getRoomType();
			if(!roomTypes.contains(roomTypes)){
				hotelVOList.remove(i);
			}
		}
		return hotelVOList;
	}
	
}
