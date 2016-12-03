package businessLogic.hotelBL.hotelScan.sortComparator;

import java.util.Comparator;
import vo.HotelGeneralVO;

public class AscPriceComparator implements Comparator<HotelGeneralVO>{

	@Override
	public int compare(HotelGeneralVO o1, HotelGeneralVO o2) {
		return (int) (o1.minPrice-o2.minPrice);
	}
	
}
