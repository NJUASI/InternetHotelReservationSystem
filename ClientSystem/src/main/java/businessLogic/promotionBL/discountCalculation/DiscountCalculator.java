package businessLogic.promotionBL.discountCalculation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.promotionBL.DiscountInSpan;
import businessLogic.promotionBL.promotions.HotelFixedPromotion;
import businessLogic.promotionBL.promotions.MemberLevelPromotion;
import businessLogic.promotionBL.promotions.SpecialCirclePromotion;
import businessLogic.promotionBL.promotions.SpecialSpanPromotion;
import utilities.PreOrder;

/**
 * @Description:实现DiscountInSpan接口，
 * 向order提供一个直接获取入住期间内每天的折扣的方法
 * @author:Harvey Gong
 * @time:2016年12月2日 下午7:38:05
 */
public class DiscountCalculator implements DiscountInSpan{
	
	private HotelFixedPromotion hotelFixedPromotion;
	private SpecialSpanPromotion specialSpanPromotion;
	private SpecialCirclePromotion specialCirclePromotion;
	private MemberLevelPromotion memberLevelPromotion;
	
	public DiscountCalculator() {
		hotelFixedPromotion = new HotelFixedPromotion();
		specialSpanPromotion = new SpecialSpanPromotion();
		specialCirclePromotion = new SpecialCirclePromotion();
		memberLevelPromotion = new MemberLevelPromotion();
	}
	
	/**
	 * @Description:根据传入的PreOrder，结合四种策略，然后算出每天需要打的折扣
	 * @param preOrder
	 * @return
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月2日 下午7:42:18
	 */
	@Override
	public Iterator<Double> getDiscountInSpan(PreOrder preOrder) {
		List<Double> discountsInSpan = new ArrayList<Double>();
		LocalDate today = preOrder.checkInDate;
		String guestID = preOrder.guestID;
		String hotelID = preOrder.hotelID;
		for(int i = 0;i<preOrder.lastDays;i++){
			discountsInSpan.add(hotelFixedPromotion.getDiscountOneday(preOrder,today)
					*specialSpanPromotion.getDiscountOneday(guestID,today)
					*specialCirclePromotion.getDiscount(guestID,hotelID)
					*memberLevelPromotion.getDiscount(guestID));
		}
		return discountsInSpan.iterator();
	}
}
