package presentation.hotelWorkerUI.controller;

import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import utilities.IDReserve;
import utilities.RoomType;

public class OfflineController {

	@FXML
	private ComboBox<String> roomType,roomType2;
	@FXML
	private TextField roomNum,roomNum2;
	@FXML
	private DatePicker date1,date2;
	@FXML
	private TextField phone;

	HotelBLService hotelBLController;
	String hotelID;
	public OfflineController() {
		hotelBLController = HotelBLController.getInstance();
		hotelID = IDReserve.getInstance().getUserID();
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @线下客户入住
	 */
	@FXML
	protected void checkIn(){
		
		//TODO gy注意：将roomType改为roomName，roomNum改为comboBox，我把这种房间的剩余房间数量加载进来
		hotelBLController.checkInOffline(hotelID, RoomType.valueOf(roomType.getValue()), Integer.valueOf(roomNum.getText()));
		roomType.setValue("");
		roomNum.setText("");
		date1.setValue(null);
		date2.setValue(null);
		phone.setText("");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @线下客户退房
	 */
	@FXML
	protected void checkOut(){
		/**
		 * TODO gy注意：这里将roomType2改为roomName2，roomNum2也改为选择的，
		 * 我把已经入住的房间数量加载进来，不然又会加入条件检测；
		 */
		hotelBLController.checkOutOffline(hotelID,RoomType.valueOf(roomType2.getValue()), Integer.valueOf(roomNum2.getText()));
		roomType2.setValue("");
		roomNum2.setText("");
	}
}
