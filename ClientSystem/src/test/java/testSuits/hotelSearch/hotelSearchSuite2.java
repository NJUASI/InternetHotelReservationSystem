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
import vo.RoomInfoVO;
import vo.SearchCriteriaVO;

public class hotelSearchSuite2 {

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
	//酒店搜索后，查看酒店详情
	public void test() {
		Iterator<HotelVO> itr = hotelController.getHotels("南京", "新街口地区");
		itr.next();
		itr.next();
		HotelVO vo1 = itr.next();
		Iterator<RoomInfoVO> itr2 = hotelController.getHotelRoomInfo(vo1.hotelID);
		RoomInfoVO roomVO = itr2.next();
		assertEquals(559,roomVO.price,0.01);
	}

}
