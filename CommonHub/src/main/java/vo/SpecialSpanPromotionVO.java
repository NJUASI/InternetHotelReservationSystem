package vo;

import java.time.LocalDate;

import po.SpecialSpanPromotionPO;

public class SpecialSpanPromotionVO{

	public String userID;
	public String promotionName;	
	public double discount;
	public LocalDate startDate;
	public LocalDate endDate;
	
	
	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPromotionName() {
		return promotionName;
	}


	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public SpecialSpanPromotionVO(SpecialSpanPromotionPO specialSpanPromotionPO) {
		this.userID = specialSpanPromotionPO.getUserID();
		this.promotionName = specialSpanPromotionPO.getPromotionName();
		this.discount = specialSpanPromotionPO.getDiscount();
		this.startDate = specialSpanPromotionPO.getStartDate();
		this.endDate = specialSpanPromotionPO.getEndDate();
	}


	public SpecialSpanPromotionVO() {
		// TODO 自动生成的构造函数存根
	}

}
