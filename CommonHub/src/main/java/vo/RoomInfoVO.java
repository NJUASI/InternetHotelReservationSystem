package vo;

import po.RoomInfoPO;
import utilities.RoomType;

public class RoomInfoVO {
	
	// 酒店编号
	public String hotelID;
	
	// 房间类型
	public RoomType roomType;
	
	// 房间数
	public int roomNumCount;
	
	// 价格
	public double price;
	
	public RoomInfoVO(String hotelID, RoomType roomType, int roomNumCount, double price) {
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
