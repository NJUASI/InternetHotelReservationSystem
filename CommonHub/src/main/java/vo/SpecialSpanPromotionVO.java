package vo;

import java.time.LocalDate;

import po.SpecialSpanPromotionPO;
import utilities.PromotionType;

public class SpecialSpanPromotionVO{

	public String userID;
	public PromotionType promotionType;
	public String promotionName;	
	public double discount;
	public LocalDate startDate;
	public LocalDate endDate;
	
	
	public SpecialSpanPromotionVO(SpecialSpanPromotionPO specialSpanPromotionPO) {
		this.userID = specialSpanPromotionPO.getUserID();
		this.promotionType = specialSpanPromotionPO.getPromotionType();
		this.promotionName = specialSpanPromotionPO.getPromotionName();
		this.discount = specialSpanPromotionPO.getDiscount();
		this.startDate = specialSpanPromotionPO.getStartDate();
		this.endDate = specialSpanPromotionPO.getEndDate();
	}

}
