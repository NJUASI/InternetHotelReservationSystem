package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import vo.HotelVO;

public class BookedOnlyCriteria implements SearchCriteria{

	@Override
	public List<HotelVO> meetCriteria(List<HotelVO> hotelVOList) {
		for(int i = 0;i<hotelVOList.size();i++){
			if(hotelVOList.get(i).orderState == null){
				hotelVOList.remove(i);
			}
		}
		return hotelVOList;
	}

}
