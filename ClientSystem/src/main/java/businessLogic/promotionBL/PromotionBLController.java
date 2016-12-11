package businessLogic.promotionBL;

import java.util.Iterator;

import businessLogic.promotionBL.promotions.HotelFixedPromotion;
import businessLogic.promotionBL.promotions.SpecialCirclePromotion;
import businessLogic.promotionBL.promotions.SpecialSpanPromotion;
import businessLogicService.promotionBLService.PromotionBLService;
import utilities.enums.ResultMessage;
import vo.AddressVO;
import vo.HotelFixedPromotionVO;
import vo.SpecialSpanPromotionVO;

public class PromotionBLController implements PromotionBLService {

	private static PromotionBLController promotionController = new PromotionBLController();
	
	private HotelFixedPromotion hotelFixedPromotion;
	private SpecialSpanPromotion specialSpanPromotion;
	private SpecialCirclePromotion specialCirclePromotion;
	
	private PromotionBLController() {
		hotelFixedPromotion = new HotelFixedPromotion();
		specialSpanPromotion = new SpecialSpanPromotion();
		specialCirclePromotion = new SpecialCirclePromotion();
	}

	public static PromotionBLController getInstance(){
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
	public ResultMessage deleteSpecialSpanPromotion(String userID,String promotionName) {
		return specialSpanPromotion.deleteSpecialSpanPromotion(userID,promotionName);
	}
	
	@Override
	public Iterator<AddressVO> getSpecialCirclePromotions(String city) {
		return specialCirclePromotion.getSpecialCirclePromoitons(city);
	}

	@Override
	public ResultMessage updateSpecialCirclePromotions(AddressVO addressVO) {
		return specialCirclePromotion.updateSpecialCirclePromotion(addressVO);
	}

	/**
	 * @Description:根据city和circle获得该城市商圈的折扣
	 * @param city
	 * @param newCircle
	 * @return
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月11日 下午6:44:58
	 */
	@Override
	public double getSpecialCirclePromotion(String city, String newCircle) {
		return specialCirclePromotion.getSpecialCirclePromoiton(city,newCircle);
	}
	
}
