package businessLogic.hotelBL.hotelScan;

import java.util.List;

import po.HotelGeneralPO;

public interface SearchCriteria {
	public List<HotelGeneralPO> meetCriteria(List<HotelGeneralPO> hotelGeneralVOList);
}
