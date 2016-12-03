package businessLogic.hotelBL.hotelScan.sortComparator;

import java.util.Comparator;

import vo.HotelGeneralVO;

public class DescLevelComparator implements Comparator<HotelGeneralVO> {

	@Override
	public int compare(HotelGeneralVO o1, HotelGeneralVO o2) {
		return new Integer(o2.level)-new Integer(o1.level);
	}
	
}
