package presentation.webManagerUI.controller;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import exception.verificationException.UserInexistException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utilities.ResultMessage;
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
	
	private UserBLService userBLController;

	@FXML
	private void initialize() {
		userBLController = UserController.getInstance();
	}

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @搜索酒店并初始化界面
	 */
	@FXML
	protected void search() {
		System.out.println(inputID.getText());
		try {
			hotelWorkerVO = (HotelWorkerVO) userBLController.getSingle(inputID.getText());
		} catch (UserInexistException e1) {
			e1.printStackTrace();
			// 为了保证编译能通过
		}
		
		hotelInfoPane.setVisible(true);
		
		if(hotelWorkerVO == null){
			// TODO gy 获取到的hotelWorkerVO为空，代表找不到对应ID的酒店工作人员，界面做提示处理，界面不跳转
		}
		
		
		try {
			hotelID.setText(hotelWorkerVO.userID);
			hotelName.setText(hotelWorkerVO.hotelName);
			password.setText(hotelWorkerVO.password);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @保存酒店工作人員信息
	 */
	@FXML
	protected void saveModify() {
		
		HotelWorkerVO tempHotelWorkerVO = hotelWorkerVO;
		
		tempHotelWorkerVO.hotelName = hotelName2.getText();
		tempHotelWorkerVO.password = password2.getText();
		
		ResultMessage message = userBLController.modify(tempHotelWorkerVO);
		// TODO gy 返回是否成功修改的信息，界面需做提示处理

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
