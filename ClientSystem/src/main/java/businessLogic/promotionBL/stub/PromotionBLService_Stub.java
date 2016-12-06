package businessLogic.promotionBL.stub;

import java.util.Iterator;

import businessLogicService.promotionBLService.PromotionBLService;
import utilities.PreOrder;
import utilities.ResultMessage;
import vo.AddressVO;
import vo.HotelFixedPromotionVO;
import vo.SpecialSpanPromotionVO;

public class PromotionBLService_Stub implements PromotionBLService{

	
	public PromotionBLService_Stub() {
		// TODO Auto-generated constructor stub
	}

	public double getDiscout(PreOrder preOrder) {
		// TODO Auto-generated method stub
		return 0.8;
	}

	@Override
	public Iterator<HotelFixedPromotionVO> getHotelFixedPromotions(String hotelWorkerID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionVO hotelFixedPromotionVO) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Iterator<SpecialSpanPromotionVO> getHotelSpecialSpanPromotions(String userID) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	@Override
	public Iterator<SpecialSpanPromotionVO> getWebSpecialSpanPromotions() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage updateSpecialSpanPromotions(SpecialSpanPromotionVO specialSpanPromotionVO) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Iterator<AddressVO> getSpecialCirclePromotions(String city) {
		// TODO 自动生成的方法存根
		return null;
	}

	
	@Override
	public ResultMessage updateSpecialCirclePromotions(AddressVO addressVO) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deleteSpecialSpanPromotion(String userID, String promotionName) {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
