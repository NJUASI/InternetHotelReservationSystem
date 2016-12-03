package po;

import java.io.Serializable;

public class HotelGeneralPO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1830401367957454463L;

	//	酒店编号
	private String hotelID;
	
	//	酒店名称
	private String hotelName;
	
	//	酒店城市
	private String city;
	
	//	酒店商圈
	private String cycle;
	
	//	酒店星级
	private String level;
	
	//	评分
	private double score;

	//  最低价格
	private double minPrice;
	
	
	public HotelGeneralPO(String hotelID, String hotelName, String city, String cycle, String level, double score, double minPrice) {
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.city = city;
		this.cycle = cycle;
		this.level = level;
		this.score = score;
		this.minPrice = minPrice;
	}
	
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice){
		this.minPrice = minPrice;
	}

}
