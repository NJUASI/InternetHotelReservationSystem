package vo;

import po.HotelGeneralPO;

public class HotelGeneralVO {
	
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
	
	//  最低价格
	public double minPrice;
	
	public HotelGeneralVO(String hotelID, String hotelName, String city, String cycle, String level, double score , double minPrice) {
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.city = city;
		this.cycle = cycle;
		this.level = level;
		this.score = score;
		this.minPrice = minPrice;
	}

	public HotelGeneralVO(HotelGeneralPO hotelGeneralPO) {
		this.hotelID = hotelGeneralPO.getHotelID();
		this.hotelName = hotelGeneralPO.getHotelName();
		this.city = hotelGeneralPO.getCity();
		this.cycle = hotelGeneralPO.getCycle();
		this.level = hotelGeneralPO.getLevel();
		this.score = hotelGeneralPO.getScore();
		this.minPrice = hotelGeneralPO.getMinPrice();
	}
}
