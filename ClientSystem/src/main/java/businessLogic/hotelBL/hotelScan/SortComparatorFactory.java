package businessLogic.hotelBL.hotelScan;

import java.util.Comparator;

import businessLogic.hotelBL.hotelScan.sortComparator.AscLevelComparator;
import businessLogic.hotelBL.hotelScan.sortComparator.AscPriceComparator;
import businessLogic.hotelBL.hotelScan.sortComparator.DescLevelComparator;
import businessLogic.hotelBL.hotelScan.sortComparator.DescPriceComparator;
import businessLogic.hotelBL.hotelScan.sortComparator.DescScoreComparator;
import utilities.SortStrategy;
import vo.HotelVO;

public class SortComparatorFactory {
	Comparator<HotelVO> comparator;
	
	public SortComparatorFactory() {
		// TODO 自动生成的构造函数存根
	}
	
	public Comparator<HotelVO> createComparator(SortStrategy sortStrategy){
		if(sortStrategy == SortStrategy.ASCLEVEL){
			comparator = new AscLevelComparator();
		}
		else if(sortStrategy == SortStrategy.ASCPRICE){
			comparator = new AscPriceComparator();
		}
		else if(sortStrategy == SortStrategy.DESCLEVEL){
			comparator = new DescLevelComparator();
		}
		else if(sortStrategy == SortStrategy.DESCPRICE){
			comparator = new DescPriceComparator();
		}
		else if(sortStrategy == SortStrategy.DESCSCORE){
			comparator = new DescScoreComparator();
		}
		return comparator;
	}
}
