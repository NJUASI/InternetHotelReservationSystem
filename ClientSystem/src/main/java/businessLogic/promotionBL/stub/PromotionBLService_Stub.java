package businessLogic.promotionBL.stub;

import java.util.Iterator;

import businessLogicService.promotionBLService.PromotionBLService;
import utilities.PreOrder;
import utilities.enums.ResultMessage;
import vo.AddressVO;
import vo.HotelFixedPromotionVO;
import vo.SpecialSpanPromotionVO;

public class PromotionBLService_Stub implements PromotionBLService{

	
	public PromotionBLService_Stub() {
	}

	public double getDiscout(PreOrder preOrder) {
		return 0.8;
	}

	@Override
	public Iterator<HotelFixedPromotionVO> getHotelFixedPromotions(String hotelWorkerID) {
		return null;
	}

	@Override
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionVO hotelFixedPromotionVO) {
		return null;
	}

	@Override
	public Iterator<SpecialSpanPromotionVO> getHotelSpecialSpanPromotions(String userID) {
		return null;
	}
	
	@Override
	public Iterator<SpecialSpanPromotionVO> getWebSpecialSpanPromotions() {
		return null;
	}

	@Override
	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO) {
		return null;
	}

	@Override
	public ResultMessage updateSpecialSpanPromotions(SpecialSpanPromotionVO specialSpanPromotionVO) {
		return null;
	}

	@Override
	public Iterator<AddressVO> getSpecialCirclePromotions(String city) {
		return null;
	}

	
	@Override
	public ResultMessage updateSpecialCirclePromotions(AddressVO addressVO) {
		return null;
	}

	@Override
	public ResultMessage deleteSpecialSpanPromotion(String userID, String promotionName) {
		return null;
	}
	
}
