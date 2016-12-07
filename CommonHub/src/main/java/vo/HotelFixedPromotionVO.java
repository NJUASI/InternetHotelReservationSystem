package vo;

import po.HotelFixedPromotionPO;
import utilities.PromotionType;

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

}
