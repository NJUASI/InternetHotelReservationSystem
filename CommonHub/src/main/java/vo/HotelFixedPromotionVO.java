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

	public HotelFixedPromotionVO() {
		// TODO 自动生成的构造函数存根
	}

}
