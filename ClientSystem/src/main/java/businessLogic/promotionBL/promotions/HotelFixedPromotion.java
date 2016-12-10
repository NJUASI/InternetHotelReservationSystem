package businessLogic.promotionBL.promotions;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.promotionBL.discountCalculation.CalculateDiscount;
import businessLogic.promotionBL.discountCalculation.HotelFixedDiscountFactory;
import dataService.promotionDataService.PromotionDataService;
import dataService.promotionDataService.PromotionDataService_Stub;
import exception.verificationException.UserInexistException;
import po.HotelFixedPromotionPO;
import rmi.ClientRemoteHelper;
import utilities.PreOrder;
import utilities.enums.PromotionType;
import utilities.enums.ResultMessage;
import vo.HotelFixedPromotionVO;

/**
 * @Description:对于酒店会员生日折扣，企业会员折扣以及三间及以上预订的促销策略操作的具体实现
 * 只有get和update，没有添加的功能
 * @author:Harvey Gong
 * @time:2016年12月1日 下午2:08:44
 */
public class HotelFixedPromotion {

	private PromotionDataService promotionDataService;
	private List<HotelFixedPromotionPO> hotelFixedPromotions;

	public HotelFixedPromotion() {
		promotionDataService = ClientRemoteHelper.getInstance().getPromotionDataService();
//		try {
//			promotionDataService = new PromotionDataService_Stub();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * @Description:获取酒店没有特定期间的促销策略，会员生日、三间及以上和合作企业会员的策略
	 * @param hotelWorkerID
	 * @return
	 * Iterator<HotelFixedPromotionVO>
	 * @author: Harvey Gong
	 * @time:2016年12月1日 下午2:07:11
	 */
	public Iterator<HotelFixedPromotionVO> getHotelFixedPromotions(String hotelWorkerID){
		try {
			hotelFixedPromotions = promotionDataService.getHotelFixedPromotion(hotelWorkerID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return convertPOListToVOListIterator(hotelFixedPromotions);
	}


	/**
	 * @Description:更新酒店没有特定期间的促销策略，会员生日、三间及以上和合作企业会员的策略
	 * 只进行单条更新
	 * @param hotelFixedPromotionVO
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @time:2016年12月1日 下午2:08:49
	 */
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionVO hotelFixedPromotionVO){
		try {
			return promotionDataService.updateHotelFixedPromotion(new HotelFixedPromotionPO(hotelFixedPromotionVO));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	/**
	 * @Description:根据传入的订单信息和需要计算策略的日期，
	 * 计算酒店没有特定期间的促销策略的折扣，会员生日、三间及以上和合作企业会员的策略
	 * @param preOrder
	 * @return
	 * double
	 * @author: Harvey Gong
	 * @param today 
	 * @throws UserInexistException 
	 * @time:2016年12月1日 下午2:09:29
	 */
	public double getDiscountOneday(PreOrder preOrder, LocalDate today) throws UserInexistException{
		List<CalculateDiscount> calculateFixedPromotions = initCalculateFixedPromotions(preOrder,today);
		double discount = 1;
		for(int i = 0;i<calculateFixedPromotions.size();i++){
			discount = discount * calculateFixedPromotions.get(i).getDiscount();
		}
		return discount;
	}

	private List<CalculateDiscount> initCalculateFixedPromotions(PreOrder preOrder, LocalDate today){
		List<CalculateDiscount> calculateFixedPromotions = new ArrayList<CalculateDiscount>();
		initHotelFixedPromotions(preOrder.hotelID);
		HotelFixedDiscountFactory factory = new HotelFixedDiscountFactory(preOrder,today);
		for(int i = 0;i<hotelFixedPromotions.size();i++){
			HotelFixedPromotionPO tempHotelFixedPromotion = hotelFixedPromotions.get(i);
			PromotionType promotionType = tempHotelFixedPromotion.getPromotionType();
			double discount = tempHotelFixedPromotion.getDiscount();
			calculateFixedPromotions.add(factory.createCalculateDiscount(promotionType,discount));
		}
		return calculateFixedPromotions;
	}

	private void initHotelFixedPromotions(String hotelID) {
		try {
			hotelFixedPromotions = promotionDataService.getHotelFixedPromotion(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private Iterator<HotelFixedPromotionVO> convertPOListToVOListIterator(List<HotelFixedPromotionPO> POList){
		List<HotelFixedPromotionVO> hotelFixedPromotionVOList = new ArrayList<HotelFixedPromotionVO>();
		for(HotelFixedPromotionPO hotelFixedPromotion: POList){
			hotelFixedPromotionVOList.add(new HotelFixedPromotionVO(hotelFixedPromotion));
		}
		return hotelFixedPromotionVOList.iterator();
	}

}
