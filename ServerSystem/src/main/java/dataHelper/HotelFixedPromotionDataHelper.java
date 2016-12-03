package dataHelper;

import java.util.List;

import po.HotelFixedPromotionPO;
import utilities.ResultMessage;

public interface HotelFixedPromotionDataHelper {
	
	public List<HotelFixedPromotionPO> getHotelFixedPromotion(String hotelWorkerID);
	
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionPO hotelFixedPromotionPO);
}
