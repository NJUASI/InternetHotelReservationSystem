package vo;

import po.HotelPO;

public final class HotelVO {

	//	酒店编号 酒店名称 酒店城市 酒店商圈 酒店星级 评分
	public HotelGeneralVO hotelGeneralVO;

	//  酒店ID
	public String hotelID;

	//  酒店名
	public String hotelName;

	//  酒店所在城市
	public String city;

	//  酒店所在商圈
	public String cycle;

	//  酒店等级
	public String level;

	//  酒店评分
	public double score;
	
	//  最低价格
	public double minPrice;

	//	酒店地址
	public String hotelAddress;

	//	简介
	public String introduction;	

	//	设施服务
	public String equipment;

	public HotelVO(String hotelID, String hotelName, String city, String cycle, String hotelAddress, 
			String level, double score, double minPrice, String introduction, String equipment) {
		this.hotelGeneralVO = new HotelGeneralVO(hotelID, hotelName, city, cycle, level, score, minPrice);

		this.hotelAddress = hotelAddress;
		this.introduction = introduction;
		this.equipment = equipment;
	}

	public HotelVO(HotelGeneralVO hotelGeneralVO, String hotelAddress, 
			String introduction, String equipment) {
		this.hotelGeneralVO = hotelGeneralVO;

		this.hotelAddress = hotelAddress;
		this.introduction = introduction;
		this.equipment = equipment;
	}

	public HotelVO(HotelPO hotelPO) {
		this.hotelID = hotelPO.getHotelID();
		this.hotelName = hotelPO.getHotelName();
		this.city = hotelPO.getCity();
		this.cycle = hotelPO.getCity();
		this.level = hotelPO.getLevel();
		this.score = hotelPO.getScore();
		this.minPrice = hotelPO.getMinPrice();
		this.hotelAddress = hotelPO.getHotelAddress();
		this.introduction = hotelPO.getIntroduction();
		this.equipment = hotelPO.getEquipment();
	}
}
