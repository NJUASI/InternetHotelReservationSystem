package businessLogic.hotelBL.hotelScan.sortComparator;

import java.util.Comparator;

import vo.HotelGeneralVO;

public class AscLevelComparator implements Comparator<HotelGeneralVO> {

	@Override
	public int compare(HotelGeneralVO vo1, HotelGeneralVO vo2) {
		return new Integer(vo1.level)-new Integer(vo2.level);
	}


}
