package vo;

import po.RoomInfoPO;
import utilities.RoomType;

public class RoomInfoVO {
	
	// 酒店编号
	public String hotelID;
	
	// 房间类型
	public RoomType roomType;
	
	// 房间类型
	public String roomName;
	
	// 房间数
	public int roomNum;
	
	// 剩余房间数量
	public int remainNum; 
	
	// 价格
	public double price;
	
	public RoomInfoVO(String hotelID, RoomType roomType, String roomName, int roomNum, int remainNum ,double price) {
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.roomName = roomName;
		this.roomNum = roomNum;
		this.remainNum = remainNum;
		this.price = price;
	}

	public RoomInfoVO(RoomInfoPO roomInfoPO) {
		this.hotelID = roomInfoPO.getHotelID();
		this.roomType = roomInfoPO.getRoomType();
		this.roomName = roomInfoPO.getRoomName();
		this.roomNum = roomInfoPO.getRoomNum();
		this.remainNum = roomInfoPO.getRemainNum();
		this.price = roomInfoPO.getPrice();
	}
}
