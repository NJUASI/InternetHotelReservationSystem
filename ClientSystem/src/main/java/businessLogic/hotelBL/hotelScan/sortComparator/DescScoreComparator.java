package businessLogic.hotelBL.hotelScan.sortComparator;

import java.util.Comparator;

import vo.HotelVO;

public class DescScoreComparator implements Comparator<HotelVO> {

	@Override
	public int compare(HotelVO o1, HotelVO o2) {
		return (int) (o2.score-o1.score);
	}

}
