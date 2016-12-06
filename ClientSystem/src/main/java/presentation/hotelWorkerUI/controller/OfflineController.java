package presentation.hotelWorkerUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class OfflineController {

	@FXML
	private ComboBox<String> roomType,roomType2;
	@FXML
	private TextField roomNum,roomNum2;
	@FXML
	private DatePicker date1,date2;
	@FXML
	private TextField phone;
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @线下客户入住
	 */
	@FXML
	protected void checkIn(){
//		roomType.getValue(), roomNum.getText();
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
		roomType2.setValue("");
		roomNum2.setText("");
	}
}
