package utilities;

import java.io.Serializable;

public enum PromotionType implements Serializable{
	
	//	酒店促销策略
	HOTEL__BIRTHDAY, HOTEL__ENTERPRISE, HOTEL__ROOM_NUM_COUNT_BIGGER_THAN_THREE, HOTEL_HOLIDAY, 
	
	//	网站促销策略
	WEB_HOLIDAY, WEB__VIP_APPOINTED_CYCLE;
	
	
}
