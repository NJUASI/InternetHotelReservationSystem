package po;

import utilities.PromotionType;
import vo.HotelFixedPromotionVO;

public class HotelFixedPromotionPO {

	private String hotelID;
	private PromotionType promotionType;
	private double discount;

	public HotelFixedPromotionPO(HotelFixedPromotionVO hotelFixedPromotionVO) {
		this.hotelID = hotelFixedPromotionVO.hotelID;
		this.promotionType = hotelFixedPromotionVO.promotionType;
		this.discount = hotelFixedPromotionVO.discount;
	}

	public HotelFixedPromotionPO() {
		// TODO 自动生成的构造函数存根
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public PromotionType getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(PromotionType prmotionType) {
		this.promotionType = prmotionType;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discout) {
		this.discount = discout;
	}

	@Override
	public String toString() {
		return "HotelFixedPromotionPO [hotelID=" + hotelID + ", promotionType=" + promotionType.toString() + ", discount="
				+ discount + "]";
	}

}
