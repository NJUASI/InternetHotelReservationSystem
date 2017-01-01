package testSuits.hotelPromotion;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionBL.PromotionBLController;
import businessLogicService.promotionBLService.PromotionBLService;
import rmi.ClientRemoteHelper;
import utilities.enums.ResultMessage;
import vo.SpecialSpanPromotionVO;

public class hotelPromotionSuite2 {

	PromotionBLService promotionController;
	ClientRemoteHelper clientRemoteHelper;
	Iterator<SpecialSpanPromotionVO> itr;
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper = ClientRemoteHelper.getInstance();
		clientRemoteHelper.setIPandPort("localhost", "8889");
		promotionController = PromotionBLController.getInstance();
		itr = promotionController.getHotelSpecialSpanPromotions("98765441");
	}

	@Test
	//选定特定期间策略列表中的春节，点击修改，修改折扣为0.8折，
	//开始时间选择为2017-01-05，结束时间选择为2017-01-10
	public void test1() {
		SpecialSpanPromotionVO vo = itr.next();
		while(itr.hasNext() && !vo.promotionName.equals("春节")){
			vo = itr.next();
		}
		vo.discount = 0.8;
		vo.startDate = LocalDate.of(2017, 1, 5);
		vo.endDate = LocalDate.of(2017, 1, 10);
		promotionController.updateHotelSpecialSpanPromotion(vo);
		
		Iterator<SpecialSpanPromotionVO> itr2 =  promotionController.getHotelSpecialSpanPromotions("98765441");
		vo = itr2.next();
		while(itr2.hasNext()&&vo.promotionName != "春节"){
			vo = itr2.next();
		}
		assertEquals(0.8,vo.discount,0.01);
		assertEquals(LocalDate.of(2017, 1, 5),vo.startDate);
	}
	
	@Test
	//在特定期间策略添加信息栏中输入中的国庆节，点击修改，
	//修改折扣为0.5折，开始时间选择为2017-10-01，结束时间选择为2017-10-07
	public void test2(){
		SpecialSpanPromotionVO vo = new SpecialSpanPromotionVO();
		vo.discount = 0.5;
		vo.promotionName = "国庆节";
		vo.startDate = LocalDate.of(2017, 10, 1);
		vo.endDate = LocalDate.of(2017, 10, 7);
		vo.userID = "98765441";
		
		promotionController.addHotelSpecialSpanPromotion(vo);
		
		Iterator<SpecialSpanPromotionVO> itr2 =  promotionController.getHotelSpecialSpanPromotions("98765441");
		vo = itr2.next();
		while(itr2.hasNext() && !vo.promotionName.equals("国庆节")){
			vo = itr2.next();
		}
		assertEquals(0.5,vo.discount,0.01);
		assertEquals(LocalDate.of(2017, 10, 1),vo.startDate);
	}
	
	@Test
	//在特定期间策略中选择国庆节促销策略点击删除
	public void test3(){
		assertEquals(ResultMessage.SUCCESS,promotionController.deleteHotelSpecialSpanPromotion("98765441", "国庆节"));
	}

}
