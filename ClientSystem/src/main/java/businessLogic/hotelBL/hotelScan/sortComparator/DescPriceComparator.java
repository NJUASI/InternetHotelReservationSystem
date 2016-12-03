package businessLogic.hotelBL.hotelScan.sortComparator;

import java.util.Comparator;

import vo.HotelGeneralVO;

public class DescPriceComparator implements Comparator<HotelGeneralVO> {

	@Override
	public int compare(HotelGeneralVO vo1, HotelGeneralVO vo2) {
		return (int) (vo1.minPrice-vo2.minPrice);
	}

}
