package presentation.hotelWorkerUI.controller;

import javafx.beans.property.SimpleStringProperty;
import utilities.RoomType;

public class TypeTable {
	public final SimpleStringProperty roomType;
	public final SimpleStringProperty roomNum;
	public final SimpleStringProperty remainRoomNum;
	public final SimpleStringProperty price;

	public TypeTable(String roomType, String roomNum, String remainRoomNum,String price) {
		this.roomType = new SimpleStringProperty(roomType);
		this.roomNum = new SimpleStringProperty(roomNum);
		this.remainRoomNum = new SimpleStringProperty(remainRoomNum);
		this.price = new SimpleStringProperty(price);
	}

	public TypeTable(String roomType, String remainRoomNum,String price) {
		this.roomType = new SimpleStringProperty(roomType);
		this.roomNum = null;
		this.remainRoomNum = new SimpleStringProperty(remainRoomNum);
		this.price = new SimpleStringProperty(price);
	}
	public RoomType getRoomType() {
		return RoomType.valueOf(roomType.get());
	}
	public String getPrice() {
		return price.get();
	}
}
