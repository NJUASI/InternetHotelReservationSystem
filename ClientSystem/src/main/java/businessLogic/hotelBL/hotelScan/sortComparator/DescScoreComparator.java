package businessLogic.hotelBL.hotelScan.sortComparator;

import java.util.Comparator;

import vo.HotelGeneralVO;

public class DescScoreComparator implements Comparator<HotelGeneralVO> {

	@Override
	public int compare(HotelGeneralVO o1, HotelGeneralVO o2) {
		return (int) (o2.score-o1.score);
	}

}
