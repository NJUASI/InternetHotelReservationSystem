package vo;

import po.RemainRoomInfoPO;
import utilities.RoomType;

public class RemainRoomInfoVO {

	// 酒店编号
	public String hotelID;

	// 房间类型
	public RoomType roomType;

	// 房间数
	public int roomNumCount;

	// 价格
	public double price;

	public RemainRoomInfoVO(String hotelID, RoomType roomType, int roomNumCount, double price) {
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.roomNumCount = roomNumCount;
		this.price = price;
	}

	public RemainRoomInfoVO(RemainRoomInfoPO remainRoomInfoPO) {
		this.hotelID = remainRoomInfoPO.getHotelID();
		this.roomType = remainRoomInfoPO.getRoomType();
		this.roomNumCount = remainRoomInfoPO.getRoomNumCount();
		this.price = remainRoomInfoPO.getPrice();
	}

}
