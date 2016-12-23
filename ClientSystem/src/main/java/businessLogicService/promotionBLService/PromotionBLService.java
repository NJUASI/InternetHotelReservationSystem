package businessLogicService.promotionBLService;

import java.util.Iterator;

import utilities.enums.ResultMessage;
import vo.AddressVO;
import vo.HotelFixedPromotionVO;
import vo.SpecialSpanPromotionVO;

public interface PromotionBLService {

	//对生日特惠折扣、三间及以上预订折扣、合作企业及客户折扣操作,get,update
	public Iterator<HotelFixedPromotionVO> getHotelFixedPromotions(String hotelID);

	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionVO hotelFixedPromotionVO);

	//对特定期间的折扣的操作,get,add,delete,单条操作
	public Iterator<SpecialSpanPromotionVO> getHotelSpecialSpanPromotions(String userID);

	public Iterator<SpecialSpanPromotionVO> getWebSpecialSpanPromotions();

	public ResultMessage addHotelSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO);
	
	public ResultMessage addWebSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO);

	public ResultMessage updateHotelSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO);
	
	public ResultMessage updateWebSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO);
	
	public ResultMessage deleteHotelSpecialSpanPromotion(String userID,String promotionName);
	
	public ResultMessage deleteWebSpecialSpanPromotion(String promotionName);

	//对vip会员商圈专属折扣的操作，get,update
	public Iterator<AddressVO> getSpecialCirclePromotions(String city);

	public ResultMessage updateSpecialCirclePromotions(AddressVO addressVO);
	
	//得到单个vip会员商圈的专属折扣
	public double getSpecialCirclePromotion(String city, String circle);

}
