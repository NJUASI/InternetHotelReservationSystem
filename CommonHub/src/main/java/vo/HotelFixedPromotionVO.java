package vo;

import po.HotelFixedPromotionPO;
import utilities.enums.PromotionType;

public class HotelFixedPromotionVO{

	public String hotelID;
	

	public PromotionType promotionType;
	public double discount;

	public HotelFixedPromotionVO(HotelFixedPromotionPO hotelFixedPromotion) {
		this.hotelID = hotelFixedPromotion.getHotelID();
		this.promotionType = hotelFixedPromotion.getPromotionType();
		this.discount = hotelFixedPromotion.getDiscount();
	}


	public HotelFixedPromotionVO(String hotelID, PromotionType promotionType, double discount) {
		super();
		this.hotelID = hotelID;
		this.promotionType = promotionType;
		this.discount = discount;

	}


	public HotelFixedPromotionVO() {
		// TODO 自动生成的构造函数存根
	}

}
