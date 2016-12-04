package vo;

import po.HotelPO;
import utilities.OrderState;

public final class HotelVO {

	//	酒店编号
	public String hotelID;

	//	酒店名称
	public String hotelName;

	//	酒店城市
	public String city;

	//	酒店商圈
	public String cycle;

	//	酒店星级
	public String level;

	//	评分
	public double score;

	// 最低价格
	public double minPrice;

	//	简介
	public String introduction;	

	//	设施服务
	public String equipment;
	
	//  订单的状态
	public OrderState orderState;


	public HotelVO(String hotelID, String hotelName, String city, String cycle, String hotelAddress, 
			String level, double score, double minPrice, String introduction, String equipment) {

		
	}

	public HotelVO(HotelPO hotelPO) {
		this.hotelID = hotelPO.getHotelID();
		this.hotelName = hotelPO.getHotelName();
		this.city = hotelPO.getCity();
		this.cycle = hotelPO.getCity();
		this.level = hotelPO.getLevel();
		this.score = hotelPO.getScore();
		this.introduction = hotelPO.getIntroduction();
		this.equipment = hotelPO.getEquipment();
	}
	
	public HotelVO(HotelPO hotelPO, double minPrice,OrderState orderState) {
		this(hotelPO);
		this.minPrice = minPrice;
		this.orderState = orderState;
	}

}
