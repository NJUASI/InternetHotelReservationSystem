package presentation.hotelWorkerUI.controller;

import javafx.beans.property.SimpleStringProperty;
import utilities.RoomType;

public class TypeTable {
	public SimpleStringProperty roomType;
	public SimpleStringProperty roomName;
	public SimpleStringProperty roomNum;
	public SimpleStringProperty remainRoomNum;
	public SimpleStringProperty price;

	public TypeTable(String roomType, String roomName,String roomNum, String remainRoomNum,String price) {
		this.roomType = new SimpleStringProperty(roomType);
		this.roomName = new SimpleStringProperty(roomName);
		this.roomNum = new SimpleStringProperty(roomNum);
		this.remainRoomNum = new SimpleStringProperty(remainRoomNum);
		this.price = new SimpleStringProperty(price);
	}

	public String getRoomType() {
		return roomType.get();
	}

	public String getRoomNum() {
		return roomNum.get();
	}
	public String getRemainRoomNum() {
		return remainRoomNum.get();
	}
	public String getPrice() {
		return price.get();
	}
}
