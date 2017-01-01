package testSuits.hotelSearch;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import rmi.ClientRemoteHelper;
import utilities.enums.SearchCriteriaType;
import vo.HotelVO;
import vo.SearchCriteriaVO;

public class hotelSearchSuite1 {

	HotelBLService hotelController;
	ClientRemoteHelper clientRemoteHelper;
	List<SearchCriteriaType> list;
	SearchCriteriaVO searchVO;
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper = ClientRemoteHelper.getInstance();
		clientRemoteHelper.setIPandPort("localhost", "8889");
		hotelController = HotelBLController.getInstance();
		hotelController.setGuestID("1234567900");
		hotelController.getHotels("南京", "新街口地区");
		list = new ArrayList<SearchCriteriaType>();
		list.add(SearchCriteriaType.NULL);
		searchVO = new SearchCriteriaVO();
	}

	@Test
	//无任何搜索条件
	public void testSearchHotels() {
		Iterator<HotelVO> itr = hotelController.searchHotels(list, searchVO);
		HotelVO vo = itr.next();
		assertEquals("南京天丰大酒店",vo.hotelName);
	}
	
	@Test
	//酒店星级为5
	public void testSearchHotels2(){
		list.add(SearchCriteriaType.LEVEL_SPAN);
		searchVO.minLevel = 4;
		searchVO.maxLevel = 4;
		Iterator<HotelVO> itr = hotelController.searchHotels(list, searchVO);
		HotelVO vo = itr.next();
		assertEquals("南京天丰大酒店",vo.hotelName);
	}
	
	@Test
	//搜索已预订酒店
	public void testSearchHotels3(){
		list.add(SearchCriteriaType.BOOKED_ONLY);
		searchVO.bookedOnly = true;
		Iterator<HotelVO> itr = hotelController.searchHotels(list, searchVO);
		HotelVO vo = itr.next();
		assertEquals("南京天丰大酒店",vo.hotelName);
	}

}
