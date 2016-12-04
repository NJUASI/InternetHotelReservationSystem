package vo;

import po.RoomInfoPO;
import utilities.RoomType;

public class RoomInfoVO {
	
	// 酒店编号
	public String hotelID;
	
	// 房间类型
	public String roomType;
	
	// 房间数
	public int roomNumCount;
	
	// 剩余房间数量
	public int remainNum; 
	
	// 价格
	public double price;
	
	public RoomInfoVO(String hotelID, String roomType, int roomNumCount, double price, int i) {
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.roomNumCount = roomNumCount;
		this.price = price;
	}

	public RoomInfoVO(RoomInfoPO roomInfoPO) {
		this.hotelID = roomInfoPO.getHotelID();
		this.roomType = roomInfoPO.getRoomType();
		this.roomNumCount = roomInfoPO.getRoomNumCount();
		this.price = roomInfoPO.getPrice();
	}
}
