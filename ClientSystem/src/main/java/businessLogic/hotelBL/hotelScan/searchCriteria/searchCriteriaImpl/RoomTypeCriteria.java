package businessLogic.hotelBL.hotelScan.searchCriteria.searchCriteriaImpl;

import java.util.List;

import businessLogic.hotelBL.HotelInfoOperation;
import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.hotelBL.hotelScan.searchCriteria.SearchCriteria;
import utilities.enums.RoomType;
import vo.HotelVO;

public class RoomTypeCriteria implements SearchCriteria {

	List<RoomType> roomTypes;

	public RoomTypeCriteria(List<RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}

	/**
	 * @Description:根据所选房间类型，筛选出有这些房间类型的酒店
	 * @param hotelGeneralVOList
	 * @return
	 * List<HotelGeneralVO>
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午7:07:01
	 */
	public List<HotelVO> meetCriteria(List<HotelVO> hotelVOList) {
		HotelInfoOperation hotel = new Hotel();
		for(int i = 0;i<hotelVOList.size();i++){
			for(int j = 0;j<roomTypes.size();j++){

			}
		}
		return hotelVOList;
	}

}
