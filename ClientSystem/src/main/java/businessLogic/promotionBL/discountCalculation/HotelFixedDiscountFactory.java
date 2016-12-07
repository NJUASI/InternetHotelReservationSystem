package businessLogic.promotionBL.discountCalculation;

import java.time.LocalDate;

import businessLogic.promotionBL.discountCalculation.discountOfPromotions.EnterpriseMemberDiscount;
import businessLogic.promotionBL.discountCalculation.discountOfPromotions.ThreeAndAboveDiscount;
import businessLogic.promotionBL.discountCalculation.discountOfPromotions.VIPBirthdayDiscount;
import utilities.PreOrder;
import utilities.PromotionType;

/**
 * @Description:创建酒店无特定期间的促销策略的工厂
 * @author:Harvey Gong
 * @time:2016年12月1日 下午3:20:15
 */
public class HotelFixedDiscountFactory {

	PreOrder preOrder;
	LocalDate today;
	

	public HotelFixedDiscountFactory(PreOrder preOrder, LocalDate today) {
		this.preOrder = preOrder;
		this.today = today;
	}

	public CalculateDiscount createCalculateDiscount(PromotionType promotionType,double discount){
		switch(promotionType){
		case 会员生日折扣:
			return new VIPBirthdayDiscount(discount,preOrder.guestID,today);
		case 三间及以上预订折扣:
			return new ThreeAndAboveDiscount(discount,preOrder.roomNum);
		case 企业会员折扣:
			return new EnterpriseMemberDiscount(discount,preOrder.guestID);
		default:
			return null;
		}
	}
	
}
