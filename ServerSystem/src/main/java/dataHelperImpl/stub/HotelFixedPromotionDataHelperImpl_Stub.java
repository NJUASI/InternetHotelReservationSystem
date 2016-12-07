package dataHelperImpl.stub;

import java.util.ArrayList;
import java.util.List;

import dataHelper.HotelFixedPromotionDataHelper;
import po.HotelFixedPromotionPO;
import utilities.PromotionType;
import utilities.ResultMessage;

public class HotelFixedPromotionDataHelperImpl_Stub implements HotelFixedPromotionDataHelper{

	@Override
	public List<HotelFixedPromotionPO> getHotelFixedPromotion(String hotelWorkerID) {
		List<HotelFixedPromotionPO> list = new ArrayList<HotelFixedPromotionPO>();
		list.add(new HotelFixedPromotionPO("12345678",PromotionType.会员生日折扣,0.9));
		list.add(new HotelFixedPromotionPO("12345678",PromotionType.企业会员折扣,0.8));
		list.add(new HotelFixedPromotionPO("12345678",PromotionType.三间及以上预订折扣,0.7));
		return list;
	}

	@Override
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionPO hotelFixedPromotionPO) {
		return ResultMessage.SUCCESS;
	}

}
