package businessLogic.promotionBL.promotions;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.promotionBL.discountCalculation.CalculateDiscount;
import businessLogic.promotionBL.discountCalculation.discountOfPromotions.SpecialSpanDiscount;
import dataService.promotionDataService.PromotionDataService;
import dataService.promotionDataService.PromotionDataService_Stub;
import javafx.scene.control.Separator;
import po.SpecialSpanPromotionPO;
import utilities.PreOrder;
import utilities.ResultMessage;
import vo.SpecialSpanPromotionVO;

/**
 * @Description:对酒店和网站特定期间的促销策略操作的具体实现
 * @author:Harvey Gong
 * @time:2016年12月1日 下午3:22:57
 */
public class SpecialSpanPromotion {

	PromotionDataService promotionDataService;
	List<SpecialSpanPromotionPO> specialSpanPromotions;

	public SpecialSpanPromotion() {
		promotionDataService = new PromotionDataService_Stub();
	}

	/**
	 * @Description:根据酒店查找到所有特定期间的促销策略
	 * @param userID
	 * @return
	 * Iterator<SpecialSpanPromotionVO>
	 * @author: Harvey Gong
	 * @time:2016年12月1日 下午3:25:34
	 */
	public Iterator<SpecialSpanPromotionVO> getHotelSpecialSpanPromotions(String hotelID){
		initSpecialSpanPromotionDiscountOneday(hotelID);
		return convertPOListToVOListIterator(specialSpanPromotions);
	}

	/**
	 * @Description:查找网站所有特定期间的促销策略
	 * @return
	 * Iterator<SpecialSpanPromotionVO>
	 * @author: Harvey Gong
	 * @time:2016年12月1日 下午3:40:53
	 */
	public Iterator<SpecialSpanPromotionVO> getWebSpecialSpanPromotions(){
		initSpecialSpanPromotionDiscountOneday(null);
		return convertPOListToVOListIterator(specialSpanPromotions);
	}

	/**
	 * @Description:添加特定期间的促销策略
	 * @param specialSpanPromotionVO
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @time:2016年12月2日 下午6:56:05
	 */
	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO){
		try {
			return promotionDataService.addSpecialSpanPromotion(new SpecialSpanPromotionPO(specialSpanPromotionVO));
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}
	
	/**
	 * @Description:修改并更新特定期间的促销策略
	 * @param list
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @time:2016年12月1日 下午3:26:32
	 */
	public ResultMessage updateSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO){
		try {
			return promotionDataService.updateSpecialSpanPromotion(new SpecialSpanPromotionPO(specialSpanPromotionVO));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	/**
	 * @Description:根据被删除的promotion的数据，将数据库里对应的一条promotion删除
	 * @param specialSpanPromotionVO
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @time:2016年12月2日 下午7:23:31
	 */
	public ResultMessage deleteSpecialSpanPromotion(SpecialSpanPromotionVO specialSpanPromotionVO){
		try {
			return promotionDataService.deleteSpecialSpanPromotion(new SpecialSpanPromotionPO(specialSpanPromotionVO));
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}	
	}
	
	/**
	 * @Description:根据传入的订单信息和需要计算策略的日期，
	 * 计算酒店和网站特定期间的促销策略的折扣
	 * @param preOrder
	 * @param today
	 * @return
	 * double
	 * @author: Harvey Gong
	 * @time:2016年12月1日 下午3:27:17
	 */
	public double getDiscountOneday(String hotelID, LocalDate today){
		double discount = 1;
		initSpecialSpanPromotionDiscountOneday(hotelID);
		discount = discount * getSpecialSpanDiscount(today);
		initSpecialSpanPromotionDiscountOneday(null);
		discount = discount * getSpecialSpanDiscount(today); 
		return discount;
	}

	private double getSpecialSpanDiscount(LocalDate today){
		double discount = 1;
		List<CalculateDiscount> specialSpanDiscount = initCalculateSpecialSpanDiscount(today);
		for(int i = 0;i<specialSpanDiscount.size();i++){
			discount = discount * specialSpanDiscount.get(i).getDiscount();
		}
		return discount;
	}

	private List<CalculateDiscount> initCalculateSpecialSpanDiscount(LocalDate today){
		double discount;
		LocalDate startDate;
		LocalDate endDate;
		List<CalculateDiscount> specialSpanDiscount = new ArrayList<CalculateDiscount>();
		for(int i = 0;i<specialSpanPromotions.size();i++){
			SpecialSpanPromotionPO tempPO = specialSpanPromotions.get(i);
			discount = tempPO.getDiscount();
			startDate = tempPO.getStartDate();
			endDate = tempPO.getEndDate();
			specialSpanDiscount.add(new SpecialSpanDiscount(discount,startDate,endDate,today));
		}
		return specialSpanDiscount;
	}

	private void initSpecialSpanPromotionDiscountOneday(String hotelID){
		try{
			if(hotelID == null){
				specialSpanPromotions = promotionDataService.getWebSpecialSpanPromotion();
			} 
			else
			{
				specialSpanPromotions = promotionDataService.getHotelSpecialSpanPromotion(hotelID);
			}
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private Iterator<SpecialSpanPromotionVO> convertPOListToVOListIterator(List<SpecialSpanPromotionPO> POList){
		List<SpecialSpanPromotionVO> specialSpanPromotions = new ArrayList<SpecialSpanPromotionVO>();
		for(SpecialSpanPromotionPO specialSpanPromotion: POList){
			specialSpanPromotions.add(new SpecialSpanPromotionVO(specialSpanPromotion));
		}
		return specialSpanPromotions.iterator();
	}

}
