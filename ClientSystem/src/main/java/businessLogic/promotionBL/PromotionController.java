package businessLogic.promotionBL;

import java.util.Iterator;

import businessLogic.promotionBL.promotions.HotelFixedPromotion;
import businessLogic.promotionBL.promotions.SpecialCirclePromotion;
import businessLogic.promotionBL.promotions.SpecialSpanPromotion;
import businessLogicService.promotionBLService.PromotionBLService;
import utilities.ResultMessage;
import vo.AddressVO;
import vo.HotelFixedPromotionVO;
import vo.SpecialSpanPromotionVO;

public class PromotionController implements PromotionBLService {

	private static PromotionController promotionController = new PromotionController();
	
	private HotelFixedPromotion hotelFixedPromotion;
	private SpecialSpanPromotion specialSpanPromotion;
	private SpecialCirclePromotion specialCirclePromotion;
	
	private PromotionController() {
		hotelFixedPromotion = new HotelFixedPromotion();
		specialSpanPromotion = new SpecialSpanPromotion();
		specialCirclePromotion = new SpecialCirclePromotion();
	}

	public static PromotionController getInstance(){
		return promotionController;
	}

	@Override
	public Iterator<HotelFixedPromotionVO> getHotelFixedPromotions(String hotelWorkerID) {
		return hotelFixedPromotion.getHotelFixedPromotions(hotelWorkerID);
	}

	@Override
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionVO hotelFixedPromotionVO) {
		return hotelFixedPromotion.updateHotelFixedPromotion(hotelFixedPromotionVO);
	}
	
	@Override
	public Iterator<SpecialSpanPromotionVO> getHotelSpecialSpanPromotions(String hotelID) {
		return specialSpanPromotion.getHotelSpecialSpanPromotions(hotelID);
	}
	
	@Override
	public Iterator<SpecialSpanPromotionVO> getWebSpecialSpanPromotions() {
		return specialSpanPromotion.getWebSpecialSpanPromotions();
	}
	
	@Override
	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO) {
		return specialSpanPromotion.addSpecialSpanPromotion(specialSpanPromotionVO);
	}

	@Override
	public ResultMessage updateSpecialSpanPromotions(SpecialSpanPromotionVO specialSpanPromotionVO) {
		return specialSpanPromotion.updateSpecialSpanPromotion(specialSpanPromotionVO);
	}

	@Override
	public ResultMessage deleteSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO) {
		return specialSpanPromotion.deleteSpecialSpanPromotion(specialSpanPromotionVO);
	}
	
	@Override
	public Iterator<AddressVO> getSpecialCirclePromotions(String city) {
		return specialCirclePromotion.getSpecialCirclePromoitons(city);
	}

	@Override
	public ResultMessage updateSpecialCirclePromotions(AddressVO addressVO) {
		return specialCirclePromotion.updateSpecialCirclePromotion(addressVO);
	}
	
}
