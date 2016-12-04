package po;

import java.io.Serializable;

import utilities.RoomType;
import vo.RoomInfoVO;

public class RoomInfoPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6089646464437203567L;

	// 酒店编号
	private String hotelID;
	
	// 房间类型
	private String roomType;
	
	// 房间数
	private int roomNumCount;
	
	// 剩余房间数量
	private int remainNum;
	
	// 价格
	private double price;
	
	public RoomInfoPO(String hotelID, String roomType, int roomNumCount, double price) {
		super();
		this.hotelID = hotelID;
		this.roomType = roomType;	
		this.roomNumCount = roomNumCount;
		this.price = price;
	}
	
	public RoomInfoPO(RoomInfoVO roomInfoVO) {
		this.hotelID = roomInfoVO.hotelID;
		this.roomType = roomInfoVO.roomType;
		this.roomNumCount = roomInfoVO.roomNumCount;
		this.price = roomInfoVO.price;
	}
	public RoomInfoPO() {
		// TODO 自动生成的构造函数存根
	}

	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;	
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoomNumCount() {
		return roomNumCount;
	}
	public void setRoomNumCount(int roomNumCount) {
		this.roomNumCount = roomNumCount;
	}
	public double getPrice() {			
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
