package dataHelper;

import java.util.List;

import po.HotelFixedPromotionPO;
import utilities.enums.ResultMessage;

public interface HotelFixedPromotionDataHelper {
	
	public List<HotelFixedPromotionPO> getHotelFixedPromotion(String hotelWorkerID);
	
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionPO hotelFixedPromotionPO);
	
	public ResultMessage addHotelFixedPromotion(HotelFixedPromotionPO hotelFixedPromotionPO);
}
