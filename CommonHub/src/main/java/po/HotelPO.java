package po;

import java.io.Serializable;

import vo.HotelVO;

public final class HotelPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8529466667245846060L;

	//	酒店编号 酒店名称 酒店城市 酒店商圈 酒店星级 评分
	private HotelGeneralPO hotelGeneralPO;
	
	//	酒店地址
	private String hotelAddress;
	
	//	简介
	private String introduction;	
	
	//	设施服务
	private String equipment;
	
	private double minPrice;
	
	public HotelPO(String hotelID, String hotelName, String city, String cycle, String hotelAddress, 
			String level, double score, double minPrice, String introduction, String equipment) {
		this.hotelGeneralPO = new HotelGeneralPO(hotelID, hotelName, city, cycle, level, score, minPrice);
		
		this.hotelAddress = hotelAddress;
		this.introduction = introduction;
		this.equipment = equipment;
	}
	
	public HotelPO(HotelGeneralPO hotelGeneralPO, String hotelAddress,
			String introduction, String equipment) {
		this.hotelGeneralPO = hotelGeneralPO;
		
		this.hotelAddress = hotelAddress;
		this.introduction = introduction;
		this.equipment = equipment;
	}
	
	public HotelPO(HotelVO hotelVO) {
		
	}
	
	public String getHotelID() {
		return hotelGeneralPO.getHotelID();
	}
	public void setHotelID(String hotelID) {
		this.hotelGeneralPO.setHotelID(hotelID);
	}
	
	public String getHotelName() {
		return hotelGeneralPO.getHotelName();
	}
	public void setHotelName(String hotelName) {
		hotelGeneralPO.setHotelName(hotelName);
	}
	
	public String getCity() {
		return hotelGeneralPO.getCity();
	}
	public void setCity(String city) {
		this.hotelGeneralPO.setCity(city);
	}
	
	public String getCircle() {
		return hotelGeneralPO.getCycle();
	}
	public void setCircle(String cycle) {
		this.hotelGeneralPO.setCycle(cycle);
	}
	
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	
	public String getLevel() {
		return hotelGeneralPO.getLevel();
	}
	public void setLevel(String level) {
		hotelGeneralPO.setLevel(level);
	}
	
	public double getScore() {
		return hotelGeneralPO.getScore();
	}
	public void setScore(double score) {
		hotelGeneralPO.setScore(score);
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	
}
