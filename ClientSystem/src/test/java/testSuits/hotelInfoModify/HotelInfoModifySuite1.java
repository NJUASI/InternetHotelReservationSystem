package testSuits.hotelInfoModify;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import rmi.ClientRemoteHelper;
import vo.HotelVO;

public class HotelInfoModifySuite1 {
	
	HotelBLService hotelController;
	ClientRemoteHelper clientRemoteHelper;
	HotelVO vo;
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper = ClientRemoteHelper.getInstance();
		clientRemoteHelper.setIPandPort("localhost", "8889");
		hotelController = HotelBLController.getInstance();
		hotelController.setHotelID("98765441");
		vo = hotelController.getHotelInfo("98765441");
	}

	@Test
	//更改酒店名为7天
	public void test() {
		vo.hotelName = "7天";
		hotelController.updateHotelInfo(vo);
		vo = hotelController.getHotelInfo("98765441");
		assertEquals("7天",vo.hotelName);
	}
	
	@Test
	//更改城市为北京、商圈为五里屯
	public void test2(){
		vo.city = "北京";
		vo.circle = "五里屯";
		hotelController.updateHotelInfo(vo);
		vo = hotelController.getHotelInfo("98765441");
		assertEquals("北京",vo.city);
	}
	
	@Test
	//更改设施服务为“提供免费无线网”
	public void test3(){
		vo.equipment = "提供免费无线网";
		hotelController.updateHotelInfo(vo);
		vo = hotelController.getHotelInfo("98765441");
		assertEquals("提供免费无线网",vo.equipment);
	}

}
