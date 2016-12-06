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
		list.add(new HotelFixedPromotionPO("12345678",PromotionType.HOTEL__BIRTHDAY,0.9));
		list.add(new HotelFixedPromotionPO("12345678",PromotionType.HOTEL__ENTERPRISE,0.8));
		list.add(new HotelFixedPromotionPO("12345678",PromotionType.HOTEL__ROOM_NUM_COUNT_BIGGER_THAN_THREE,0.7));
		return list;
	}

	@Override
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionPO hotelFixedPromotionPO) {
		return ResultMessage.SUCCESS;
	}

}
