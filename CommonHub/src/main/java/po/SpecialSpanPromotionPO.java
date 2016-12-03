package po;

import java.time.LocalDate;

import utilities.PromotionType;
import vo.SpecialSpanPromotionVO;

public class SpecialSpanPromotionPO {

	private String userID;
	private PromotionType promotionType;
	private String promotionName;
	private double discount;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public SpecialSpanPromotionPO() {
	}
	
	public SpecialSpanPromotionPO(SpecialSpanPromotionVO specialSpanPromotionVO) {
		this.userID = specialSpanPromotionVO.userID;
		this.promotionType = specialSpanPromotionVO.promotionType;
		this.discount = specialSpanPromotionVO.discount;
		this.startDate = specialSpanPromotionVO.startDate;
		this.endDate = specialSpanPromotionVO.endDate;
		this.promotionName = specialSpanPromotionVO.promotionName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public PromotionType getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
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

}
