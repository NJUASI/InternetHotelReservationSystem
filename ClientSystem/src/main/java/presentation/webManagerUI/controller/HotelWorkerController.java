package presentation.webManagerUI.controller;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import exception.verificationException.UserInexistException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.PopUp.PopUp;
import utilities.enums.ResultMessage;
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
//			TODO djy得不到不是可以直接弄到异常里吗
				new PopUp("请检查输入内容", "sorry");
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
		
		new PopUp(message.toString(), "congratulation");	


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
