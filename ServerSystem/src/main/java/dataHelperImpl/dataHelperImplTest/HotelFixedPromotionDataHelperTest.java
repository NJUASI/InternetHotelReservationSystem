package dataHelperImpl.dataHelperImplTest;

import java.util.List;

import dataHelper.HotelFixedPromotionDataHelper;
import dataHelperImpl.HotelFixedPromotionDataHelperImpl;
import po.HotelFixedPromotionPO;
import utilities.PromotionType;

public class HotelFixedPromotionDataHelperTest {
	public HotelFixedPromotionDataHelperTest() {
		// TODO 自动生成的构造函数存根
	}
	
	public static void main(String[] args) {
		HotelFixedPromotionDataHelper test = new HotelFixedPromotionDataHelperImpl();
		List<HotelFixedPromotionPO> list = test.getHotelFixedPromotion("123456");
		HotelFixedPromotionPO temp = list.get(0);
		System.out.println(temp.toString());
		
		temp.setDiscount(0.7);
		temp.setPromotionType(PromotionType.HOTEL__ENTERPRISE);
		
		list = test.getHotelFixedPromotion("123456");
		temp = list.get(0);
		System.out.println(temp.toString()); 
	}
}
