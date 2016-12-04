package vo;

import po.RoomInfoPO;
import utilities.RoomType;

public class RoomInfoVO {
	
	// 酒店编号
	public String hotelID;
	
	// 房间类型
	public String roomType;
	
	// 房间数
	public int roomNum;
	
	// 剩余房间数量
	public int remainNum; 
	
	// 价格
	public double price;
	
	public RoomInfoVO(String hotelID, String roomType, int roomNum, double price, int i) {
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.price = price;
	}

	public RoomInfoVO(RoomInfoPO roomInfoPO) {
		this.hotelID = roomInfoPO.getHotelID();
		this.roomType = roomInfoPO.getRoomType();
		this.roomNum = roomInfoPO.getRoomNum();
		this.price = roomInfoPO.getPrice();
	}
}
