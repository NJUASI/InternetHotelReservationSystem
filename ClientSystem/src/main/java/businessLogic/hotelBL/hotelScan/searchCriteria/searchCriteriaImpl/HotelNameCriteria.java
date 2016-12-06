package businessLogic.hotelBL.hotelScan.searchCriteria.searchCriteriaImpl;

import java.util.List;

import businessLogic.hotelBL.hotelScan.searchCriteria.SearchCriteria;
import vo.HotelVO;

public class HotelNameCriteria implements SearchCriteria {

	private String keyHotelName;
	
	public HotelNameCriteria(String hotelName) {
		this.keyHotelName = hotelName;
	}
	
	@Override
	public List<HotelVO> meetCriteria(List<HotelVO> hotelGeneralVOList) {
		// TODO 自动生成的方法存根
		return null;
	}

}
