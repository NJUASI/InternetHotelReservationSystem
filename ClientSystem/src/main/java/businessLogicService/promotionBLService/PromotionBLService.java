package businessLogicService.promotionBLService;

import java.util.Iterator;
import java.util.List;

import utilities.PreOrder;
import utilities.ResultMessage;
import vo.AddressVO;
import vo.HotelFixedPromotionVO;
import vo.SpecialSpanPromotionVO;

public interface PromotionBLService {

	//对生日特惠折扣、三间及以上预订折扣、合作企业及客户折扣操作,get,update
	public Iterator<HotelFixedPromotionVO> getHotelFixedPromotions(String hotelWorkerID);

	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionVO hotelFixedPromotionVO);

	//对特定期间的折扣的操作,get,add,delete,单条操作
	public Iterator<SpecialSpanPromotionVO> getHotelSpecialSpanPromotions(String userID);

	public Iterator<SpecialSpanPromotionVO> getWebSpecialSpanPromotions();

	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO);

	public ResultMessage updateSpecialSpanPromotions(SpecialSpanPromotionVO specialSpanPromotionVO);
	
	public ResultMessage deleteSpecialSpanPromotion(SpecialSpanPromotionVO	specialSpanPromotionVO);

	//对vip会员商圈专属折扣的操作，get,update
	public Iterator<AddressVO> getSpecialCirclePromotions(String city);

	public ResultMessage updateSpecialCirclePromotions(AddressVO addressVO);

}
