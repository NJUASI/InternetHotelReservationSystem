package testSuits.webPromotion;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionBL.PromotionBLController;
import businessLogicService.promotionBLService.PromotionBLService;
import rmi.ClientRemoteHelper;
import vo.AddressVO;

public class webPromotionSuite2 {

	PromotionBLService promotionController;
	ClientRemoteHelper clientRemoteHelper;
	Iterator<AddressVO> itr;
	@Before
	public void setUp() throws Exception {
		clientRemoteHelper = ClientRemoteHelper.getInstance();
		clientRemoteHelper.setIPandPort("localhost", "8889");
		promotionController = PromotionBLController.getInstance();
		itr = promotionController.getSpecialCirclePromotions("南京");
	}

	@Test
	//选择制定vip特定商圈折扣，选择城市南京，选定新街口地区策略，点击修改，更改折扣0.8折
	public void test1() {
		AddressVO vo = itr.next();
		while(itr.hasNext() && !vo.circle.equals("新街口地区"))
		{
			vo = itr.next();
		}
		
		vo.discout = 0.8;
		promotionController.updateSpecialCirclePromotions(vo);
		assertEquals(0.8,promotionController.getSpecialCirclePromotion("南京", "新街口地区"),0.01);
	}

}
