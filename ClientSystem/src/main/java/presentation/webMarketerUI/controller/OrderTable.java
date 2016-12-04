package presentation.webMarketerUI.controller;

import javafx.beans.property.SimpleStringProperty;

public class OrderTable {
	
	public final SimpleStringProperty orderID;
	public final SimpleStringProperty hotelName;
	public final SimpleStringProperty address;
	public final SimpleStringProperty checkInTime;
	public final SimpleStringProperty checkOutTime;
	public final SimpleStringProperty price;
	public final SimpleStringProperty state;
	
	public OrderTable(String orderID, String hotelName,String address, String checkInTime,String checkOutTime,String price, String state) {
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
