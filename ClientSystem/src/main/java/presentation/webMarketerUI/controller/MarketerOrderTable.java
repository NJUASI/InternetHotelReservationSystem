package presentation.webMarketerUI.controller;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

public class MarketerOrderTable {
	
	public final SimpleStringProperty orderID;
	public final SimpleStringProperty hotelName;
	public final SimpleStringProperty address;
	public final SimpleStringProperty checkInTime;
	public final SimpleStringProperty price;
	public final SimpleStringProperty state;
	
	public MarketerOrderTable(String orderID, String hotelName,String address, String checkInTime,String price, String state) {
		this.orderID = new SimpleStringProperty(orderID);
		this.hotelName = new SimpleStringProperty(hotelName);
		this.address = new SimpleStringProperty(address);
		this.checkInTime = new SimpleStringProperty(checkInTime);
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

	public String getPrice() {
		return price.get();
	}

	public String getState() {
		return state.get();
	}

}
