package testSuits.hotelPromotion;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionBL.PromotionBLController;
import businessLogicService.promotionBLService.PromotionBLService;
import rmi.ClientRemoteHelper;
import utilities.enums.PromotionType;
import vo.HotelFixedPromotionVO;

public class hotelPromotionSuite1 {

	PromotionBLService promotionController;
	ClientRemoteHelper clientRemoteHelper;
	Iterator<HotelFixedPromotionVO> itr;
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper = ClientRemoteHelper.getInstance();
		clientRemoteHelper.setIPandPort("localhost", "8889");
		promotionController = PromotionBLController.getInstance();
		itr = promotionController.getHotelFixedPromotions("98765441");
	}

	@Test
	//选定会员生日折扣，并点击修改，修改折扣为0.9折
	public void test1() {
		HotelFixedPromotionVO vo = itr.next();
		assertEquals(PromotionType.HOTEL_BIRTHDAY,vo.promotionType);
		vo.discount = 0.9;
		promotionController.updateHotelFixedPromotion(vo);
		Iterator<HotelFixedPromotionVO> itr2 = promotionController.getHotelFixedPromotions("98765441");
		vo = itr2.next();
		assertEquals(0.9,vo.discount,0.1);
	}
	
	@Test
	//选定企业会员折扣，并点击修改，修改折扣为0.8折
	public void test2() {
		itr.next();
		HotelFixedPromotionVO vo = itr.next();
		assertEquals(PromotionType.HOTEL_ENTERPRISE,vo.promotionType);
		vo.discount = 0.8;
		promotionController.updateHotelFixedPromotion(vo);
		Iterator<HotelFixedPromotionVO> itr2 = promotionController.getHotelFixedPromotions("98765441");
		itr2.next();
		vo = itr2.next();
		assertEquals(0.8,vo.discount,0.1);
	}

}
