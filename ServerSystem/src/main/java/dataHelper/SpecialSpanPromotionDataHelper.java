package dataHelper;

import java.util.List;

import po.SpecialSpanPromotionPO;
import utilities.ResultMessage;

public interface SpecialSpanPromotionDataHelper {

public List<SpecialSpanPromotionPO> getHotelSpecialSpanPromotion(String hotelID);
	
	public List<SpecialSpanPromotionPO> getWebSpecialSpanPromotion();
	
	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO);
	
	public ResultMessage updateSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO);
	
	public ResultMessage deleteSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO);
	
}
