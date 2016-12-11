package businessLogic.promotionBL.promotions;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.MockHotel;
import businessLogic.memberBL.MockMember;
import dataService.promotionDataService.PromotionDataService;
import po.AddressPO;
import rmi.ClientRemoteHelper;
import utilities.Address;
import utilities.enums.MemberType;
import utilities.enums.ResultMessage;
import vo.AddressVO;

/**
 * @Description:对于VIP会员特定商圈专属折扣
 * @author:Harvey Gong
 * @time:2016年12月1日 下午9:29:44
 */
public class SpecialCirclePromotion {

	private PromotionDataService promotionDataService;
	private List<AddressPO> specialCirclePromotions;

	public SpecialCirclePromotion() {
		promotionDataService = ClientRemoteHelper.getInstance().getPromotionDataService();
//		try {
//			promotionDataService = new PromotionDataService_Stub();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * @Description:根据所选城市，返回该城市所有的商圈和对应商圈的vip折扣
	 * @param city
	 * @return
	 * Iterator<AddressVO>
	 * @author: Harvey Gong
	 * @time:2016年12月1日 下午9:41:48
	 */
	public Iterator<AddressVO> getSpecialCirclePromoitons(String city){
		initSpecialCirclePromotions(city);
		return convertPOListToVOListIterator(specialCirclePromotions);
	}
	
	/**
	 * @Description:更新商圈的vip折扣,单条更新
	 * @param addressVO
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @time:2016年12月1日 下午9:45:02
	 */
	public ResultMessage updateSpecialCirclePromotion(AddressVO addressVO){
		try {
			return promotionDataService.updateSepecialCirclePromotion(new AddressPO(addressVO));
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}

	/**
	 * @Description:根据guestID判断是否是会员，若是再根据hotelID分别获得该酒店的城市和商圈
	 * @param guestID
	 * @param hotelID
	 * @return
	 * double
	 * @author: Harvey Gong
	 * @time:2016年12月2日 下午7:08:54
	 */
	public double getDiscount(String guestID,String hotelID){
		if(isVIP(guestID)){
			//TODO 龚尘淼：mock，修改实现
			Address hotelAddress = new MockHotel().getHotelAddress(hotelID);
			String city = hotelAddress.city;
			String cycle = hotelAddress.circle;
			try {
				return promotionDataService.getSpecialCircleDiscount(city,cycle);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
		
	private boolean isVIP(String guestID){
		//TODO 龚尘淼：mock，修改实现
		return new MockMember().isMember(guestID, MemberType.COMMON);
	}
	
	private Iterator<AddressVO> convertPOListToVOListIterator(List<AddressPO> POList){
		List<AddressVO> specialCirclePromotionVOList = new ArrayList<AddressVO>();
		for(AddressPO specialCirclePromotion: POList){
			specialCirclePromotionVOList.add(new AddressVO(specialCirclePromotion));
		}
		return specialCirclePromotionVOList.iterator();
	}
	
	private void initSpecialCirclePromotions(String city) {
		try {
			specialCirclePromotions = promotionDataService.getSpecialCirclePromotion(city);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
