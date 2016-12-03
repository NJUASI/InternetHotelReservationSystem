package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import po.HotelGeneralPO;
import utilities.RoomType;

public class RoomTypeCriteria implements SearchCriteria {

	RoomType roomType;
	
	public RoomTypeCriteria(RoomType roomType) {
		this.roomType = roomType;
	}
	
	/**
	 * @Description:TODO   HotelGeneralVO中没有roomtype
	 * @param hotelGeneralVOList
	 * @return
	 * List<HotelGeneralVO>
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午7:07:01
	 */
	public List<HotelGeneralPO> meetCriteria(List<HotelGeneralPO> hotelGeneralVOList) {
		for(int i = 0;i<hotelGeneralVOList.size();i++){
			
		}
		return null;
	}

}
