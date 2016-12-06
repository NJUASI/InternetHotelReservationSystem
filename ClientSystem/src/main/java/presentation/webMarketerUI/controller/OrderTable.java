package presentation.webMarketerUI.controller;

import javafx.beans.property.SimpleStringProperty;

public class OrderTable {
	public SimpleStringProperty guestID;
	public SimpleStringProperty orderID;
	public SimpleStringProperty name;
	public SimpleStringProperty phone;
	public SimpleStringProperty hotelName;
	public SimpleStringProperty address;
	public SimpleStringProperty checkInTime;
	public SimpleStringProperty checkOutTime;
	public SimpleStringProperty price;
	public SimpleStringProperty state;
	
	public OrderTable(String guestID ,String orderID,String name,String phone, String hotelName,String address, String checkInTime,String checkOutTime,String price, String state) {
		this.guestID = new SimpleStringProperty(guestID);
		this.orderID = new SimpleStringProperty(orderID);
		this.name = new SimpleStringProperty(name);
		this.phone = new SimpleStringProperty(phone);
		this.hotelName = new SimpleStringProperty(hotelName);
		this.address = new SimpleStringProperty(address);
		this.checkInTime = new SimpleStringProperty(checkInTime);
		this.checkOutTime = new SimpleStringProperty(checkOutTime);
		this.price = new SimpleStringProperty(price);
		this.state = new SimpleStringProperty(state);
	}
	public OrderTable(String orderID ,String guestID, String name ,String phone, String checkInTime,String checkOutTime,String price, String state) {
		this.orderID = new SimpleStringProperty(orderID);
		this.guestID = new SimpleStringProperty(guestID);
		this.name=new SimpleStringProperty(name);
		this.phone = new SimpleStringProperty(phone);
		this.checkInTime = new SimpleStringProperty(checkInTime);
		this.checkOutTime = new SimpleStringProperty(checkOutTime);
		this.price = new SimpleStringProperty(price);
		this.state = new SimpleStringProperty(state);
	}
	public OrderTable(String orderID ,String hotelName,String address, String checkInTime,String checkOutTime,String price, String state) {
		this.orderID = new SimpleStringProperty(orderID);
		this.hotelName = new SimpleStringProperty(hotelName);
		this.address = new SimpleStringProperty(address);
		this.checkInTime = new SimpleStringProperty(checkInTime);
		this.checkOutTime = new SimpleStringProperty(checkOutTime);
		this.price = new SimpleStringProperty(price);
		this.state = new SimpleStringProperty(state);
	}
	public String getOrderID() {
		return orderID.get();
	}

	public String getHotelName() {
		return hotelName.get();
	}

	public String getAddress() {
		return address.get();
	}

	public String getCheckInTime() {
		return checkInTime.get();
	}
	public String getCheckOutTime() {
		return checkOutTime.get();
	}

	public String getPrice() {
		return price.get();
	}

	public String getState() {
		return state.get();
	}

}
