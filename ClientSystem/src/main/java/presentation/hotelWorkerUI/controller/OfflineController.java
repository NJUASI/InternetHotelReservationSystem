package presentation.hotelWorkerUI.controller;

import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import utilities.IDReserve;
import utilities.enums.RoomType;

public class OfflineController {

	@FXML
	private ComboBox<String> roomType,roomType2;
	@FXML
	private ComboBox<Integer> roomNum,roomNum2;
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
	@FXML
	void Initialize(){
		for (int i = 0; i < 5; i++) {
			roomNum.getItems().add(i);
			roomNum2.getItems().add(i);
		}
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @线下客户入住
	 */
	@FXML
	protected void checkIn(){
		
//		TODO fjj 不知道@谁
//		TODO gcm roomType显示和数据库存的不一样
		hotelBLController.checkInOffline(hotelID, RoomType.valueOf(roomType.getValue()), Integer.valueOf(roomNum.getValue()));
		roomType.setValue("");
		roomNum.setValue(null);
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
		 * TODO fjj注意：这里将roomType2改为roomName2，roomNum2也改为选择的，
		 * 我把已经入住的房间数量加载进来，不然又会加入条件检测；
		 * 我加了已经，房间的初始数目在前面初始化
		 * roomNum.getItems().add(i);for循环
		 */
		
		hotelBLController.checkOutOffline(hotelID,RoomType.valueOf(roomType2.getValue()), Integer.valueOf(roomNum2.getValue()));
		roomType2.setValue("");
		roomNum2.setValue(null);;
	}
}
