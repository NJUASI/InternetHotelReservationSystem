package presentation.webManagerUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import vo.GuestVO;
import vo.HotelWorkerVO;

/**
 * @author 61990s
 *
 */
public class HotelWorkerController {

	HotelWorkerVO hotelWorkerVO;
	@FXML
	private Pane hotelInfoPane;
	@FXML
	private Pane hotelModifyPane;
	@FXML
	private TextField inputID, hotelName2, password2;
	@FXML
	private Label hotelID, hotelName, password, hotelID2;

	@FXML
	private void initialize() {

	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @搜索酒店并初始化界面
	 */
	@FXML
	protected void search() {
		// 通过IDget hotelworker
		hotelWorkerVO = new HotelWorkerVO("12345678", "876543231", "七天连锁");
		hotelID.setText(hotelWorkerVO.userID);
		hotelName.setText(hotelWorkerVO.hotelName);
		password.setText(hotelWorkerVO.password);

		hotelInfoPane.setVisible(true);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @初始化酒店工作人員信息界面
	 */
	@FXML
	protected void modifyHotel() {
		if (hotelWorkerVO != null) {
			hotelID2.setText(hotelWorkerVO.userID);
			hotelName2.setText(hotelWorkerVO.hotelName);
			password2.setText(hotelWorkerVO.password);

			hotelModifyPane.setVisible(true);
			hotelInfoPane.setVisible(false);
		}
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @保存酒店工作人員信息
	 */
	@FXML
	protected void saveModify() {
		hotelWorkerVO.hotelName = hotelName2.getText();
		hotelWorkerVO.password = password2.getText();
		// save(hotelVO)

		hotelModifyPane.setVisible(false);
		hotelInfoPane.setVisible(true);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @取消更改酒店工作人員信息
	 */
	@FXML
	protected void cancelModify() {
		hotelModifyPane.setVisible(false);
		hotelInfoPane.setVisible(true);
	}
}
