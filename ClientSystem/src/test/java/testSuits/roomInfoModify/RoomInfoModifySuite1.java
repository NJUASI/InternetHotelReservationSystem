package testSuits.roomInfoModify;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import rmi.ClientRemoteHelper;
import utilities.enums.RoomType;
import vo.RoomInfoVO;

public class RoomInfoModifySuite1 {

	HotelBLService hotelController;
	ClientRemoteHelper clientRemoteHelper;
	Iterator<RoomInfoVO> itr;
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper = ClientRemoteHelper.getInstance();
		clientRemoteHelper.setIPandPort("localhost", "8889");
		hotelController = HotelBLController.getInstance();
		hotelController.setHotelID("98765441");
		itr = hotelController.getHotelRoomInfo("98765441");
	}

	@Test
	//选择单人间，修改价格为300元
	public void test1() {
		RoomInfoVO vo = itr.next();
		vo.price = 300;
		hotelController.updateHotelRoomInfo(vo);
		assertEquals(300,hotelController.getHotelRoomInfo("98765441").next().price,0.01);
	}
	
	@Test
	//选择双人间，修改房间总数为18间
	public void test2(){
		itr.next();
		RoomInfoVO vo = itr.next();
		vo.roomNum = 18;
		hotelController.updateHotelRoomInfo(vo);
		Iterator<RoomInfoVO> itr2 = hotelController.getHotelRoomInfo("98765441");
		itr2.next();
		assertEquals(18,itr2.next().roomNum,0.1);
	}
	
	@Test
	//选择商务套房，输入房间总数为10间，价格为500元，确认添加
	public void test3(){
		RoomInfoVO vo = new RoomInfoVO();
		vo.hotelID = "98765441";
		vo.price = 500;
		vo.roomType = RoomType.BUSINESS_SUITE;
		vo.roomNum = 10;
		hotelController.addRoomType(vo);
		Iterator<RoomInfoVO> itr2 = hotelController.getHotelRoomInfo("98765441");
		itr2.next();
		itr2.next();
		itr2.next();
		assertEquals(RoomType.BUSINESS_SUITE,itr2.next().roomType);
	}

}
