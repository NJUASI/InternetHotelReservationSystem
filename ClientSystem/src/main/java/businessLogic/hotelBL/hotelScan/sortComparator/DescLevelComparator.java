package businessLogic.hotelBL.hotelScan.sortComparator;

import java.util.Comparator;

import vo.HotelVO;

public class DescLevelComparator implements Comparator<HotelVO> {

	@Override
	public int compare(HotelVO o1, HotelVO o2) {
		return new Integer(o2.level)-new Integer(o1.level);
	}
	
}
