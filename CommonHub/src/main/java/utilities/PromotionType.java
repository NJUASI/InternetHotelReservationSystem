package utilities;

import java.io.Serializable;

public enum PromotionType implements Serializable{
	
	//	酒店促销策略
	会员生日折扣, 企业会员折扣, 三间及以上预订折扣, HOTEL_HOLIDAY, 
	
	//	网站促销策略
	WEB_HOLIDAY, WEB__VIP_APPOINTED_CYCLE;
	
	
}
