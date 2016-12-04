package po;

import java.io.Serializable;

import vo.HotelVO;

public final class HotelPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8529466667245846060L;

	//	酒店编号
	private String hotelID;

	//	酒店名称
	private String hotelName;

	//	酒店城市
	private String city;

	//	酒店商圈
	private String circle;

	//	酒店星级
	private String level;

	//	评分
	private double score;

	//	简介
	private String introduction;	

	//	设施服务
	private String equipment;

	public HotelPO(String hotelID, String hotelName, String city, String cycle, String hotelAddress, 
			String level, double score, String introduction, String equipment) {

		this.introduction = introduction;
		this.equipment = equipment;
	}

	public HotelPO(HotelVO hotelVO) {
		
	}

	public HotelPO() {
		hotelID = null;
		hotelName = "";
		city = "";
		circle = "";
		level = "";
		score = 0;
		introduction = "";
		equipment = "";
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

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
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

}
