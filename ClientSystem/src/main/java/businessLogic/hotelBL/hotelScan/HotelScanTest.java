package businessLogic.hotelBL.hotelScan;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelBL.hotelScan.searchCriteria.LevelSpanCriteria;
import businessLogic.hotelBL.hotelScan.searchCriteria.NullCriteria;
import utilities.SortStrategy;
import vo.HotelVO;

/**
 * @Description:测试浏览酒店、搜索酒店的排序和搜索算法
 * @author:Harvey Gong
 * @lastChangedBy:Harvey Gong
 * @time:2016年12月6日 上午9:34:34
 */
public class HotelScanTest {

	HotelScan hotelScan;
	List<SearchCriteria> searchCriteria;
	Iterator<HotelVO> itr;
	HotelVO vo1;
	HotelVO vo2;
	HotelVO vo3;
	
	@Before
	public void setUp() throws Exception {
		hotelScan = new HotelScan("12345678");
		hotelScan.getHotels("南京", "仙林");
		searchCriteria = new ArrayList<SearchCriteria>();
	}

	@Test
	public void testSortHotels() {
		//按等级升序排序
		itr = hotelScan.sortHotels(SortStrategy.ASCLEVEL);
		vo1 = itr.next();
		vo2 = itr.next();
		vo3 = itr.next();
		assertEquals("12345676",vo1.hotelID);
		assertEquals("12345677",vo2.hotelID);
		assertEquals("12345678",vo3.hotelID);
		//按等级降序排序
		itr = hotelScan.sortHotels(SortStrategy.DESCLEVEL);
		vo1 = itr.next();
		vo2 = itr.next();
		vo3 = itr.next();
		assertEquals("12345678",vo1.hotelID);
		assertEquals("12345677",vo2.hotelID);
		assertEquals("12345676",vo3.hotelID);
		
		
		//按价格排序  由于只能拿到一个价格 做不了测试 TODO
		
		//按评分降序排序
		itr = hotelScan.sortHotels(SortStrategy.DESCSCORE);
		vo1 = itr.next();
		vo2 = itr.next();
		vo3 = itr.next();
		assertEquals("12345676",vo1.hotelID);
		assertEquals("12345677",vo2.hotelID);
		assertEquals("12345678",vo3.hotelID);
	}

	@Test
	public void testSearchHotelsOfNullCriteria() {
		searchCriteria.add(new NullCriteria());
		itr = hotelScan.searchHotels(searchCriteria);
		vo1 = itr.next();
		vo2 = itr.next();
		vo3 = itr.next();
		assertEquals("12345678",vo1.hotelID);
		assertEquals("12345677",vo2.hotelID);
		assertEquals("12345676",vo3.hotelID);
	}
	
	@Test
	public void testSearchHotelsOfLevelSpanCriteria() {
		searchCriteria.add(new LevelSpanCriteria(4,5));
		itr = hotelScan.searchHotels(searchCriteria);
		vo1 = itr.next();
		vo2 = itr.next();
		assertEquals("12345678",vo1.hotelID);
		assertEquals("12345677",vo2.hotelID);
	}
	
	//TODO testSearchHotelsOfOriginCriteria() 价格相同 无法测试
	
	//TODO 评分相同无法测试

	//TODO 都有订单状态 无法测试
}
